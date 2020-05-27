package tug.it.openprojectapi.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import tug.it.openprojectapi.service.CustomUserDetailService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SecurityFilterConfig extends OncePerRequestFilter {

    private final CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final String authorizationHeaderKey = request.getHeader("OPEN-PROJECT-API-KEY");

        if (authorizationHeaderKey != null) {
            Optional<UserDetails> optionalUserDetails = this.customUserDetailService.getUser(authorizationHeaderKey);
            optionalUserDetails.ifPresentOrElse(userDetails -> {
                if (userDetails.getPassword().equals(authorizationHeaderKey)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    successLogging(request, userDetails);
                } else errorLogging(request);
            }, () -> errorLogging(request));
        }
        chain.doFilter(request, response);
    }

    private void successLogging(HttpServletRequest request, UserDetails userDetails) {
        log.info("Authentication Success {}", LocalDateTime.now(ZoneId.systemDefault()));
        log.info("User Info starts");
        log.info("Api-username: {}", userDetails.getUsername());
        log.info("Api-key: {}", userDetails.getPassword());
        log.info("User Info ends");
        log.info("Header Info starts");
        request.getHeaderNames().asIterator().forEachRemaining(header ->
                log.info("Header {}: {}", header, request.getHeader(header)));
        log.info("Header Info ends");
    }

    private void errorLogging(HttpServletRequest request) {
        log.info("Authentication Failed {}", LocalDateTime.now(ZoneId.systemDefault()));
        log.info("Header Info starts");
        request.getHeaderNames().asIterator().forEachRemaining(header ->
                log.info("Header {}: {}", header, request.getHeader(header)));
        log.info("Header Info ends");
        log.info("API-KEY Not Match in the Header");
    }
}
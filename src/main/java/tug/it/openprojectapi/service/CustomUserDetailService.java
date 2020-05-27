package tug.it.openprojectapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final HashMap<String, UserDetails> userMap = new HashMap<String, UserDetails>();

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userMap.get(userName);
    }

    public void initUsers(String username, String apiKey, String[] roles) {
        UserDetails user = User.builder().username(username)
                .password(apiKey)
                .roles(roles).build();
        userMap.put(apiKey, user);
    }

    public final Optional<UserDetails> getUser(String Key) {
        return Optional.ofNullable(userMap.get(Key)).isPresent() ?
                Optional.of(userMap.get(Key)) : Optional.empty();
    }
}

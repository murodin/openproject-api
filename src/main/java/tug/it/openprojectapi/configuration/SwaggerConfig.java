package tug.it.openprojectapi.configuration;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import springfox.documentation.builders.*;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.*;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig {

    private final TypeResolver typeResolver;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .alternateTypeRules(AlternateTypeRules.newRule(
                        typeResolver.resolve(List.class, LocalDate.class),
                        typeResolver.resolve(List.class, Date.class), Ordered.HIGHEST_PRECEDENCE))
                .select()
                .apis(RequestHandlerSelectors.basePackage("tug.it.openprojectapi"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(securityScheme()));
    }

    @Bean
    SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = new AuthorizationScopeBuilder().scope("global").description("full access").build();
        SecurityReference securityReferenceKey = SecurityReference.builder().reference("OPEN-PROJECT-API-KEY")
                .scopes(authScopes).build();
        return Lists.newArrayList(securityReferenceKey);
    }

    @Bean
    List<SecurityScheme> securityScheme() {
        ApiKey apiKey = new ApiKey("OPEN-PROJECT-API-KEY", "OPEN-PROJECT-API-KEY", "header");
        return Lists.newArrayList(apiKey);
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "tug-open-project Api",
                "TUG Proje Yönetim Sistemi-Open Project Api Dökümanı",
                "v1",
                "",
                new Contact("TUG Bilgi Sitemleri Grubu", "", "tug.bilgiislem@tubitak.gov.tr"),
                "Apache v2.0",
                "https://www.apache.org/licenses/LICENSE-2.0.txt",
                Collections.emptyList()
        );
    }
}
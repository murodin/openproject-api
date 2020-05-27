package tug.it.openprojectapi.bootstrap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tug.it.openprojectapi.service.CustomUserDetailService;

@Component
@RequiredArgsConstructor
public class Init implements CommandLineRunner {

    @Value("${keys.admin}")
    private String adminKey;

    private final CustomUserDetailService customUserDetailService;

    @Override
    public void run(String... args) throws Exception {
        this.customUserDetailService.initUsers("admin", adminKey, new String[]{"ADMIN"});
    }

}

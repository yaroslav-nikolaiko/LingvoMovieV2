package lingvo.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by yaroslav on 07.03.16.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @RestController
    @RequestMapping(path = "hello")
    public static class HelloWorld{

        @RequestMapping(path = "world", method = GET)
        public String helloWorld() {
            return "Hello World";
        }

        @PreAuthorize("hasAuthority('USER')")
        @RequestMapping(path = "user", method = GET)
        public String helloUser(Principal principal) {
            return "Hello "+principal.getName();
        }

        @PreAuthorize("hasAuthority('ADMIN')")
        @RequestMapping(path = "admin", method = GET)
        public String helloAdmin(Principal principal) {
            return "Hello "+principal.getName();
        }
    }
}

package cc.eugen.ph.customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"cc.eugen.ph.customer", "cc.eugen.ph.customer.service"})
@EntityScan("cc.eugen.ph.customer.model")
@EnableJpaRepositories("cc.eugen.ph.customer.model")
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}

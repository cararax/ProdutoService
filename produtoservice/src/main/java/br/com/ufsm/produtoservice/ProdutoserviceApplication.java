package br.com.ufsm.produtoservice;

import br.com.ufsm.produtoservice.model.Produto;
import br.com.ufsm.produtoservice.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProdutoserviceApplication {
	private static final Logger LOGGER= LoggerFactory.getLogger(ProdutoserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProdutoserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(ProdutoRepository repository) {
		return (args) -> {
			repository.save(new Produto("Computador", 2000.0, 20));
			repository.save(new Produto("Celular", 1250.0, 12));
			repository.save(new Produto("Monitor", 500.0, 5));
			repository.save(new Produto("Mouse", 45.0, 10));
			repository.save(new Produto("Teclado", 120.0, 10));

			LOGGER.info("Dados iniciais carregados no banco de dados");
		};
	}

}

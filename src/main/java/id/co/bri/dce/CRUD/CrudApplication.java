package id.co.bri.dce.CRUD;

import id.co.bri.dce.CRUD.entity.Book;
import id.co.bri.dce.CRUD.entity.Publisher;
import id.co.bri.dce.CRUD.repository.BookDao;
import id.co.bri.dce.CRUD.repository.PublisherDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {
	private BookDao bookDao;
	private PublisherDao publisherDao;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

package id.co.bri.dce.CRUD;

import id.co.bri.dce.CRUD.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Create New Data");
//		User data = new User();
//		data.setNama("Apri lia");
//		data.setEmail("achiaprilia.a@outlook.com");
//		data.setAddress("123456");
//
//		User data1 = new User();
//		data1.setNama("Aprilia Achi");
//		data1.setEmail("achiaprilia.a@outlook.com");
//		data1.setAddress("123456");
//
//		dataDao.save(data);
//		dataDao.save(data1);
//
//		System.out.println("Data Tesimpan");
	}
}

package id.co.bri.dce.CRUD.repository;

import id.co.bri.dce.CRUD.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book, Integer> {

}

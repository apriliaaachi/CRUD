package id.co.bri.dce.CRUD.repository;

import id.co.bri.dce.CRUD.entity.Book;
import id.co.bri.dce.CRUD.entity.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDao extends CrudRepository<Book, Integer> {
    //public List<Publisher> findByStatus(String status);
}

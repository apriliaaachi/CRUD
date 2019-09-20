package id.co.bri.dce.CRUD.repository;

import id.co.bri.dce.CRUD.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    List<User> findByStatus(String status);
    Page<User> findByStatus(String status, Pageable pageable);
    long countByName(String name);
}

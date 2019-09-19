package id.co.bri.dce.CRUD.repository;

import id.co.bri.dce.CRUD.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataDao extends CrudRepository<User, Integer> {

}

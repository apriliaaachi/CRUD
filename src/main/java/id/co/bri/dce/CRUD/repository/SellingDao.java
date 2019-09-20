package id.co.bri.dce.CRUD.repository;

import id.co.bri.dce.CRUD.entity.Selling;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SellingDao extends CrudRepository<Selling, Integer> {
//   @Query("select u.name, u.email, s.id, s.date, b.name, b.author from User u " +
//           "inner join Selling s ON u.id = s.iduser " +
//           "inner join Book b ON s.idbook = b.id where s.status = ACTIVE")
//           List<Selling> findByUserIdAndActive();
}

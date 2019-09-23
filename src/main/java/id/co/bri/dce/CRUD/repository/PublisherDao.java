package id.co.bri.dce.CRUD.repository;

import id.co.bri.dce.CRUD.entity.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherDao extends CrudRepository<Publisher, Integer> {
    public Page<Publisher> findByStatus(String status, Pageable pageable);
    public long countByName(String name);
    public List<Publisher> findByStatus(String status);
    public Publisher findById(long id);

    //public List<Publisher> findAllByBookName();
}

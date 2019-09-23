package id.co.bri.dce.CRUD.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode(exclude = "publishers")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String author;
    private String status;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL}
    )
    @JoinTable(
            name = "book_publisher",
            joinColumns = @JoinColumn(name = "idbook", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idpublisher", referencedColumnName = "id")
    )
    private Set<Publisher> publishers = new HashSet<>();

}

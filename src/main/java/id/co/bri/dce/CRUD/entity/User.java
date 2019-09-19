package id.co.bri.dce.CRUD.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="user")
@Setter
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String address;
    private String status;
}

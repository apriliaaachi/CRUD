package id.co.bri.dce.CRUD.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Selling {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int idbook;
    private int iduser;
    private String date;
    private long amount;
    private String status;


}

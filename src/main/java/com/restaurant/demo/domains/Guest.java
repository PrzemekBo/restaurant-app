package com.restaurant.demo.domains;



import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Guest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "bookingDate")
    private Date bookingDate;

    @OneToOne
    private Table table;


}

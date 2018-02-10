package com.restaurant.demo.domains;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Guest guest;

    @Enumerated(value = EnumType.STRING)
    private TableType tableType;



}

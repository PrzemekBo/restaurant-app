package com.restaurant.demo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "table_entity")
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="table_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", referencedColumnName = "guest_id")
    private Guest guest;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tableType")
    private TableType tableType;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    @Column(name = "reservation_start_time")
    private Date date;

    @Column(name = "reservation_expires_time")
    private Date timestamp;

    public TableEntity() {};

    public TableEntity(Guest guest, TableType tableType, boolean isAvailable, Date date, Date timestamp) {
        this.guest = guest;
        this.tableType = tableType;
        this.isAvailable = isAvailable;
        this.date = date;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public TableType getTableType() {
        return tableType;
    }

    public void setTableType(TableType tableType) {
        this.tableType = tableType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

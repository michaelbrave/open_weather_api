package com.tts.WeatherApp.model;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ZipCode {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;
    private String zipCode;

    @CreationTimestamp
    private Date createdAt;

    public ZipCode(Long id, String zipCode) {
        this.id = id;
        this.zipCode = zipCode;
    }
    public ZipCode() { }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    @Override
    public String toString() {
        return "ZipCodes [id=" + id + ", zipCode=" + zipCode + "]";
    }
}
package com.example.contacts;

import com.couchbase.client.java.repository.annotation.Field;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
public class Contact {

    @Id
    @NotNull
    private String id;

    @Field
    @NotNull
    private String name;

    @Field
    private String mobileNo;

    @Field
    private String college;

    @Field
    private String city;

    public Contact(String id, String name, String mobileNo, String college, String city) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.college = college;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

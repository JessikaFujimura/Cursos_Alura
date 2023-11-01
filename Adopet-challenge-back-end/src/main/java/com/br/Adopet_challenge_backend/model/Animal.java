package com.br.Adopet_challenge_backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_Animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidAnimal;

    private String name;

    private Integer age;

    private char port;

    private String characteristics;

    private String city;

    private String state;

    @OneToMany(mappedBy = "animal")
    private List<Message> message;

    public Long getUidAnimal() {
        return uidAnimal;
    }

    public void setUidAnimal(Long uidAnimal) {
        this.uidAnimal = uidAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getPort() {
        return port;
    }

    public void setPort(char port) {
        this.port = port;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

package com.br.Adopet_challenge_backend.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class TutorDto {

    private Long uidTutor;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotBlank
    private String email;

    private String city;

    private String description;

    private String photo;

    public Long getUidTutor() {
        return uidTutor;
    }

    public void setUidTutor(Long uidTutor) {
        this.uidTutor = uidTutor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

package ru.zyryanova.ProductService.entity.dto;


public class PersonInfoDto {
    private String username;
    private String email;
    private Integer hairType;

    public PersonInfoDto() {}

    public PersonInfoDto(String username, String email, Integer hairType) {
        this.username = username;
        this.email = email;
        this.hairType = hairType;

    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getHairType() {
        return hairType;
    }

    public void setHairType(Integer hairType) {
        this.hairType = hairType;
    }
}
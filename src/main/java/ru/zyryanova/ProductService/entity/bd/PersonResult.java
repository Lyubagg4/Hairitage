package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "person_result")
public class PersonResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_result_id")
    private Integer userResultId;

    @OneToOne
    @JoinColumn(name = "hair_type_id")
    private HairType hairType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public PersonResult() {
    }


    public Integer getUserResultId() {
        return userResultId;
    }

    public void setUserResultId(Integer userResultId) {
        this.userResultId = userResultId;
    }

    public HairType getHairType() {
        return hairType;
    }

    public void setHairType(HairType hairType) {
        this.hairType = hairType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}


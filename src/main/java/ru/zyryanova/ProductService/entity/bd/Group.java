package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;
import ru.zyryanova.ProductService.enums.Groups;

@Entity
@Table(name = "purpose_ing")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purpose_ing_id")
    private Integer groupId;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private Groups groupName;

    public Group() {
    }


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Groups getGroupName() {
        return groupName;
    }

    public void setGroupName(Groups groupName) {
        this.groupName = groupName;
    }
}
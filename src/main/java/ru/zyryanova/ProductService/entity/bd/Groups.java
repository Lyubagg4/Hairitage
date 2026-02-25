package ru.zyryanova.ProductService.entity.bd;

import jakarta.persistence.*;
import ru.zyryanova.ProductService.enums.Group;

@Entity
@Table(name = "group")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @Enumerated(EnumType.STRING)
    @Column(name = "group_name")
    private Group groupName;

    public Groups() {
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Group getGroupName() {
        return groupName;
    }

    public void setGroupName(Group groupName) {
        this.groupName = groupName;
    }
}
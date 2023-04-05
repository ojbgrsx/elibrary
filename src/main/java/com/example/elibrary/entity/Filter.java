package com.example.elibrary.entity;

import com.example.elibrary.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Filter extends BaseEntity {
    @Column(name = "user_name")
    String userName;

    //TODO: почта нужна или
    @Column(name = "email")
    String email;

}

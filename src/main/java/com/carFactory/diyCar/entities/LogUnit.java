package com.carFactory.diyCar.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class LogUnit {
    @Id
    @GeneratedValue
    private Long id;

    private String logText;

    public LogUnit(String text) {
        this.logText = text;
    }

    public LogUnit() {}
}

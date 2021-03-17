package com.carFactory.diyCar.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "CAR")
@Entity
@Getter @Setter
public class Car implements Serializable {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

//    @OneToOne
//    @JoinColumn(name = "original_make_id", referencedColumnName = "id")
//    private OriginalMake originalMake;

    private String name;
}

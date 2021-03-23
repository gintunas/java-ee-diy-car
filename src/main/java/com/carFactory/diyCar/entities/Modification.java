package com.carFactory.diyCar.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "MODIFICATION")
@Entity
@NamedQueries({
        @NamedQuery(name = "Modification.findAll", query = "select m from Modification as m")
})
@Getter
@Setter
public class Modification {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private String name;

    private String type;

    @ManyToMany(mappedBy = "modifications")
    @Access( AccessType.FIELD )
    private List<Car> cars = new ArrayList<>();
}

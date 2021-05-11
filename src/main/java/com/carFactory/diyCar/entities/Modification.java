package com.carFactory.diyCar.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Modification.findAll", query = "select m from Modification as m")
})
@Getter
@Setter
public class Modification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @ManyToMany(mappedBy = "modifications")
    private List<Car> cars = new ArrayList<>();
}

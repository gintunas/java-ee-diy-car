package com.carFactory.diyCar.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Car.findAll", query = "select c from Car as c")
})
@Getter @Setter
@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter(AccessLevel.NONE)
    @Version
    private Long version;

    private String name;

    @ManyToOne
    private OriginalMake originalMake;

    @ManyToMany
    @JoinTable(name = "CAR_MODIFICATION",
            joinColumns = @JoinColumn(name = "MODIFICATION_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_ID"))
    private List<Modification> modifications = new ArrayList<>();
}

//mapped_by - ne mano, o sitoj nurodytoj pusej yra foreign key.

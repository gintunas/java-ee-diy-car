package com.carFactory.diyCar.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "CAR")
@NamedQueries({
        @NamedQuery(name = "Car.findAll", query = "select c from Car as c")
})
@Getter @Setter
@Entity
public class Car implements Serializable {
    private Long id;

    @Column(name="OPT_LOCK_VERSION")
    private Integer version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "Nieko")
    private String name;

    @Column(name = "NENORIU")
    public int very;

    @ManyToOne
    @Access( AccessType.FIELD )
    private OriginalMake originalMake;

    @ManyToMany
    @JoinTable(name = "CAR_MODIFICATION",
            joinColumns = @JoinColumn(name = "MODIFICATION_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_ID"))
    @Access( AccessType.FIELD )
    private List<Modification> modifications = new ArrayList<>();
}

//mapped_by - ne mano, o sitoj nurodytoj pusej yra foreign key.

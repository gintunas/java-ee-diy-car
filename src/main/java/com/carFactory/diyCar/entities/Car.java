package com.carFactory.diyCar.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "CAR")
@Entity
@NamedQueries({
        @NamedQuery(name = "Car.findAll", query = "select c from Car as c")
})
@Getter @Setter
public class Car implements Serializable {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

//    @OneToOne
//    @JoinColumn(name = "original_make_id", referencedColumnName = "id")
//    private OriginalMake originalMake;

    private String name;

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

package com.carFactory.diyCar.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ORIGINAL_MAKE")
@NamedQueries({
        @NamedQuery(name = "OriginalMake.findAll", query = "select om from OriginalMake as om")
})
@Getter @Setter
public class OriginalMake {
    private Long id;

    public OriginalMake() {

    }

    public OriginalMake(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column
    private String name;

    //TODO: implement equals and hash
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Player player = (Player) o;
//        return Objects.equals(id, player.id) &&
//                Objects.equals(name, player.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }
}

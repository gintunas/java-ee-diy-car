package com.carFactory.diyCar.usecases;

import com.carFactory.diyCar.entities.OriginalMake;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
@Getter
public class OriginalMakes implements Serializable {
    private List<OriginalMake> allMakes;

    @PostConstruct
    public void init(){
        loadMakes();
    }

    public void loadMakes() {
        // TODO this is a mock implementation - later we will connect it to real data store
        List<OriginalMake> makes = new ArrayList<>();
        makes.add(new OriginalMake("Honda"));
        makes.add(new OriginalMake("Toyota"));
        this.allMakes = makes;
    }
}

package com.carFactory.diyCar.mybatis.usecases;

import com.carFactory.diyCar.mybatis.dao.ModificationMapper;
import com.carFactory.diyCar.mybatis.model.Car;
import com.carFactory.diyCar.mybatis.model.Modification;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class ModificationsB {
    @Inject
    private ModificationMapper modMapper;

    @Getter
    private List<Modification> allMods;

    @PostConstruct
    public void init() {
        this.loadAllMods();
    }

    private void loadAllMods() {
        this.allMods = modMapper.selectAll();
    }

    public List<Car> getCars(Long makeId) {
        return modMapper.selectByPrimaryKey(makeId).getCars();
    }
}

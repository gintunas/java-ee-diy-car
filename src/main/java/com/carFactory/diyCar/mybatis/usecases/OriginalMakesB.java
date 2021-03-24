package com.carFactory.diyCar.mybatis.usecases;

import com.carFactory.diyCar.mybatis.dao.OriginalMakeMapper;
import com.carFactory.diyCar.mybatis.model.Car;
import com.carFactory.diyCar.mybatis.model.OriginalMake;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class OriginalMakesB {

    @Inject
    private OriginalMakeMapper omMapper;

    @Getter
    private List<OriginalMake> allMakes;

    @Getter
    @Setter
    private OriginalMake makeToCreate = new OriginalMake();

    @PostConstruct
    public void init() {
        this.loadAllMakes();
    }

    private void loadAllMakes() {
        this.allMakes = omMapper.selectAll();
    }

    @Transactional
    public String createMake() {
        omMapper.insert(makeToCreate);
        loadAllMakes();
        return "myBatisImpl/addMakeB?faces-redirect=true";
    }

    public List<Car> getCars(Long makeId){
        return omMapper.selectByPrimaryKey(makeId).getCars();
    }
}
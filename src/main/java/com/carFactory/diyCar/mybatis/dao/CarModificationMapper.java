package com.carFactory.diyCar.mybatis.dao;

import com.carFactory.diyCar.mybatis.model.CarModification;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface CarModificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR_MODIFICATION
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    int insert(CarModification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR_MODIFICATION
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    List<CarModification> selectAll();
}
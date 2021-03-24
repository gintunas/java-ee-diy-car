package com.carFactory.diyCar.mybatis.dao;

import com.carFactory.diyCar.mybatis.model.Car;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    int insert(Car record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    Car selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    List<Car> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    int updateByPrimaryKey(Car record);
}
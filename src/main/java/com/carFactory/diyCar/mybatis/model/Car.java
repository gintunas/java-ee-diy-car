package com.carFactory.diyCar.mybatis.model;

public class Car {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CAR.ID
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CAR.NAME
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CAR.ORIGINALMAKE_ID
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    private Long originalmakeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CAR.ID
     *
     * @return the value of PUBLIC.CAR.ID
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CAR.ID
     *
     * @param id the value for PUBLIC.CAR.ID
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CAR.NAME
     *
     * @return the value of PUBLIC.CAR.NAME
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CAR.NAME
     *
     * @param name the value for PUBLIC.CAR.NAME
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CAR.ORIGINALMAKE_ID
     *
     * @return the value of PUBLIC.CAR.ORIGINALMAKE_ID
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    public Long getOriginalmakeId() {
        return originalmakeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CAR.ORIGINALMAKE_ID
     *
     * @param originalmakeId the value for PUBLIC.CAR.ORIGINALMAKE_ID
     *
     * @mbg.generated Tue Mar 23 16:57:41 EET 2021
     */
    public void setOriginalmakeId(Long originalmakeId) {
        this.originalmakeId = originalmakeId;
    }
}
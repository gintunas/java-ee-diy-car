package com.carFactory.diyCar.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CarDTO {
    private String name;
    private Map<String, String> originalMake;
    private Map<String, String> modifications;
}

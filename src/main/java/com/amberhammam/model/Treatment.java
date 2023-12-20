package com.amberhammam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Treatment {
    private String name;
    private int price;

    @Override
    public String toString() {
        return name;
    }
}

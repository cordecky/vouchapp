package com.amberhammam.service;

import com.amberhammam.model.Treatment;

import java.util.List;

public interface TreatmentService {
    List<Treatment> getTreatments();

    Treatment findByName(String source);
}

package com.amberhammam.model;

import com.amberhammam.service.TreatmentService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToTreatmentConverter implements Converter<String, Treatment> {

    private final TreatmentService treatmentService;

    public StringToTreatmentConverter(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @Override
    public Treatment convert(String source) {
        return treatmentService.findByName(source);
    }
}


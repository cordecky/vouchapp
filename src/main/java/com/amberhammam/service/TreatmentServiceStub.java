package com.amberhammam.service;

import com.amberhammam.model.Treatment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreatmentServiceStub implements TreatmentService {

    @Override
    public List<Treatment> getTreatments() {
        return new ArrayList<>() {
            {
                add(new Treatment("Masaż klasyczny", 100));
                add(new Treatment("Masaż gorącymi kamieniami", 150));
                add(new Treatment("Masaż bańką chińską", 120));
                add(new Treatment("Masaż sportowy", 110));
                add(new Treatment("Masaż relaksacyjny", 130));
            }
        };
    }

    public Treatment findByName(String name) {
        return getTreatments().stream()
                .filter(treatment -> treatment.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Treatment not found"));
    }

}

package com.team13.WaitDoc.hospital.service;

import java.util.NoSuchElementException;

import com.team13.WaitDoc.hospital.repository.HospitalRepository;
import com.team13.WaitDoc.hospital.entity.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public Hospital findByIdElseThrow(Long hospitalId) {
        return hospitalRepository.findById(hospitalId).orElseThrow();
    }
    public String getHospitalName(Long hospitalId) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid hospital Id:" + hospitalId));
        return hospital.getName();
    }

    public Hospital getHospital(Long hospitalId) {
        return hospitalRepository.findById(hospitalId)
            .orElseThrow(() -> new NoSuchElementException("No hospital found with ID: " + hospitalId));
    }
}

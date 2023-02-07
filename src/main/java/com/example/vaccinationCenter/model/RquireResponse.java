package com.example.vaccinationCenter.model;

import com.example.vaccinationCenter.Entity.VaccinationCenter;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "require")

public class RquireResponse {
    private VaccinationCenter center;
    private List<Citizen>citizens;
}

package com.example.vaccinationCenter.Repository;

import com.example.vaccinationCenter.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepositorty extends JpaRepository<VaccinationCenter,Integer> {
}

package com.example.vaccinationCenter.Controller;

import com.example.vaccinationCenter.Entity.VaccinationCenter;
import com.example.vaccinationCenter.Repository.CenterRepositorty;
import com.example.vaccinationCenter.model.Citizen;
import com.example.vaccinationCenter.model.RquireResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationController {
    @Autowired
    CenterRepositorty centerRepositorty;
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/add")
    public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter){
        VaccinationCenter vaccinationCenter1=centerRepositorty.save(vaccinationCenter);
        return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);
    }
    @GetMapping(path = "/id{id}")
    public ResponseEntity<RquireResponse>getAllDadaBasedonCenter(@PathVariable Integer id){
        RquireResponse rquireResponse=new RquireResponse();
        VaccinationCenter center= centerRepositorty.findById(id).get();
        rquireResponse.setCenter(center);
        List<Citizen>citizenList=restTemplate.getForObject("http://localhost:19292/citizen/id/"+id, List.class);
        rquireResponse.setCitizens(citizenList);
        return new ResponseEntity<RquireResponse>(rquireResponse,HttpStatus.OK);
    }
    public ResponseEntity<RquireResponse>handleCitizenDownTime(@PathVariable Integer id){
        RquireResponse rquireResponse=new RquireResponse();
        VaccinationCenter center=centerRepositorty.findById(id).get();
        rquireResponse.setCenter(center);
        return new ResponseEntity<RquireResponse>(rquireResponse,HttpStatus.OK);
    }
}

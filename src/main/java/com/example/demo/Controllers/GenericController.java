package com.example.demo.Controllers;

import com.example.demo.Models.FileOutput.FileOutput;
import com.example.demo.Models.Pessoa.Pessoa;
import com.example.demo.Models.viatura.Viatura;
import com.example.demo.Models.viatura.ViaturaOutput;
import com.example.demo.Services.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {
    @Autowired
    PublicService publicService;


@CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value= "/finance_sim/calculate_instalment",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<ViaturaOutput> calculateInstalment (@RequestBody Viatura input){
        return ResponseEntity.ok(publicService.calculateInstalment(input));
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(value ="/finance_sim/save_sim",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<FileOutput>saveSimulation(@RequestBody Pessoa input){
        return ResponseEntity.ok(publicService.saveSimulation(input));
    }

}

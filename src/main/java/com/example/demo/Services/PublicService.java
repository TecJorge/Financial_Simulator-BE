package com.example.demo.Services;

import com.example.demo.Models.FileOutput.FileOutput;
import com.example.demo.Models.Pessoa.Pessoa;
import com.example.demo.Models.viatura.Viatura;
import com.example.demo.Models.viatura.ViaturaOutput;

public interface PublicService {
    ViaturaOutput calculateInstalment(Viatura input);

    FileOutput saveSimulation(Pessoa input);
}

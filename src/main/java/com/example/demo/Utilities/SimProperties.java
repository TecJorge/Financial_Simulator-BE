package com.example.demo.Utilities;

import org.springframework.beans.factory.annotation.Value;
import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Component;

@Setter
@Getter
@Component

public class SimProperties {
    @Value("${Fator.valorInterno}")
    private Double fatorInterno;
    @Value("${Fator.valorExterno}")
    private Double fatorExterno;
}

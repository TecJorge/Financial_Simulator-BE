package com.example.demo.Models.Pessoa;

import com.example.demo.Models.viatura.Viatura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Pessoa implements Serializable {
    @Serial
    private static final long serialVersionUID = -3837081536970862363L;
    private String nome;
    private String numeroTelemovel;

    private String email;
    private String modelo;

    private Double valor;
    private Viatura.Financiamento financiamento;
    private BigDecimal prestacao;


}

package com.example.demo.Models.viatura;

import com.example.demo.Utilities.TipoFinanciamento;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Viatura  implements Serializable {
    @Serial
    private static final long serialVersionUID = 4629719641518118418L;
    private String modelo;
    private String descritivo;
    private Double valor;

    private Financiamento financiamento;

    @Getter
    @Setter
    @ToString
    public static class Financiamento implements Serializable{
        @Serial
        private static final long serialVersionUID = 5659476944168135535L;
        private int mensalidades;
        private TipoFinanciamento tipoFinanciamento;
    }
}

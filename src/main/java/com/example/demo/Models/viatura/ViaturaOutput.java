package com.example.demo.Models.viatura;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ViaturaOutput implements Serializable {
    @Serial
    private static final long serialVersionUID = -7861006310752096283L;
    private Viatura viatura;

    private BigDecimal prestacaoMensal;
    private boolean isError;
    private String resultMessage;
}

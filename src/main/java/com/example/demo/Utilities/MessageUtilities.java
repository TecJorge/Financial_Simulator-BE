package com.example.demo.Utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class MessageUtilities {
    private MessageUtilities(){}
    public static final String SIMSUCESSO = "Simulacao Realizada com Sucesso a sua prestacao sera de :";
    public static final String SIMINSUCESSO = "Houve um erro ao Realizar a sua simulacao!";

    public static final String FILECREATED = "Ira ser contactado em breve por um assistente";

    public static final String FILENOTCREATED = "Houve um erro ao guardar a sua simulacao";
}

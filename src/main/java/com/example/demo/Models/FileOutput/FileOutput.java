package com.example.demo.Models.FileOutput;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter 
public class FileOutput  implements Serializable {
    @Serial
    private static final long serialVersionUID = -6734111984871745930L;
    private String resultMessage;
    private boolean isError;
}

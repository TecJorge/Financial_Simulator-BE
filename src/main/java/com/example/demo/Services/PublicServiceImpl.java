package com.example.demo.Services;

import com.example.demo.Models.FileOutput.FileOutput;
import com.example.demo.Models.Pessoa.Pessoa;
import com.example.demo.Models.viatura.Viatura;
import com.example.demo.Models.viatura.ViaturaOutput;
import com.example.demo.Utilities.SimProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.demo.Utilities.MessageUtilities.*;


@Service
public class PublicServiceImpl implements PublicService {
    @Autowired
    SimProperties simProperties;

    @Override
    public ViaturaOutput calculateInstalment(Viatura input) {
        ViaturaOutput output = new ViaturaOutput();
        String tipoFinanciamento = input.getFinanciamento().getTipoFinanciamento().name();
        int mensalidades = input.getFinanciamento().getMensalidades();
        Double fator = getFator(tipoFinanciamento);
        Double valor = input.getValor() * fator / mensalidades;
        output.setViatura(input);
        output.setPrestacaoMensal(BigDecimal.valueOf(Math.round(valor)));
        output.setError(false);
        output.setResultMessage(SIMSUCESSO + valor + " Euros");
        return output;
    }

    @Override
    public FileOutput saveSimulation(Pessoa input) {
        FileOutput response = new FileOutput();
        try {
            validateInput(input);
            createFile(input);
        } catch (IOException e) {
            response.setResultMessage(FILENOTCREATED);
            response.setError(true);
            return response;
        } catch (Exception error) {
            response.setResultMessage(error.getMessage());
            response.setError(true);
            return response;
        }
        response.setError(false);
        response.setResultMessage(FILECREATED);
        return response;
    }

    private Double getFator(String financiamento) {
        Double result;
        result = financiamento.equalsIgnoreCase("INTERNO") ? simProperties.getFatorInterno() : simProperties.getFatorExterno();
        return result / 100 + 1;
    }

    public void createFile(Pessoa input) throws IOException {
        File f = new File("Contacts.txt");
        ObjectMapper mapper = new ObjectMapper();
        if (!f.exists()) {
            mapper.writeValue(f, input);
        } else {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
            out.println();
            mapper.writeValue(out, input);
        }
    }

    private void validateInput(Pessoa input) throws Exception {
        String name = input.getNome();
        Pattern pattern = Pattern.compile("^[A-Za-z -]+$");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new Exception("O nome apenas pode conter characteres");
        }
        String mobileNumber = input.getNumeroTelemovel();
        Pattern numberPattern = Pattern.compile("^[0-9]{9}$");
        Matcher numberMatcher = numberPattern.matcher(mobileNumber);
        if (!numberMatcher.matches()) {
            throw new Exception("O numero de Telemovel deve de conter 9 Algoritmos e apenas Digitos");
        }
        String email = input.getEmail();
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches()) {
            throw new Exception("O campo de email deve de conter um formato valido de email!");
        }
    }
}



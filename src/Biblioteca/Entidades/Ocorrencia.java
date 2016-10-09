/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Entidades;

import java.util.Date;


/**
 * Classe genérica para registrar ocorrências.
 * @author Rodrigo e Jordan
 */
public abstract class Ocorrencia {
    
    private String clienteNome;
    
    private Date dataOcorrencia;
    
    public Ocorrencia () {
        // seta a data atual ao criar a ocorrência
        dataOcorrencia = new Date(System.currentTimeMillis());
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
}

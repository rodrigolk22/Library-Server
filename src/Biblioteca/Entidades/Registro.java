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
public abstract class Registro {
    
    private String clienteNome;
    
    private Date dataRegistro;
    
    public Registro () {
        // seta a data atual ao criar a ocorrência
        dataRegistro = new Date(System.currentTimeMillis());
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
}

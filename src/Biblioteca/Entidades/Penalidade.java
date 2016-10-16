/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Entidades;

import Biblioteca.Config;
import java.util.Calendar;
import java.util.Date;

/**
 * Entidade para penalidades de um cliente.
 * @author Rodrigo e Jordan
 */
public class Penalidade extends Registro {
    
    private Date dataValidade;

    public Penalidade(String clienteNome) {
        setClienteNome(clienteNome);
        // calcula a data de validade da penalidade
        dataValidade = new Date(this.getDataRegistro().getTime());
        Calendar c = Calendar.getInstance(); 
        c.setTime(dataValidade); 
        c.add(Calendar.DATE, Config.TEMPO_DIAS_PENALIDADE);
        dataValidade = c.getTime();
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Penalidade{" 
                + "clienteNome=" + getClienteNome()
                + ", dataRegistro=" + getDataRegistro() 
                + ", dataValidade=" + dataValidade 
                + '}';
    }
}

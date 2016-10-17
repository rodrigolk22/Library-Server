/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Entidades;

import Biblioteca.Interfaces.InterfaceCli;
import java.util.Calendar;
import java.util.Date;

/**
 * Entidade para reserva de um livro contendo a interface do cliente que deverá 
 * receber a notificação.
 * @author Rodrigo e Jordan
 */
public class Reserva extends Registro {
    
    private int livroId;
    
    private InterfaceCli interfaceCli;
    
    private int tempoEspera;

    private Date dataReserva;
    
    public Reserva(int livroId, String clienteNome, InterfaceCli interfaceCli, int tempoEspera) {
        setClienteNome(clienteNome);
        this.livroId = livroId;
        this.interfaceCli = interfaceCli;
        this.tempoEspera = tempoEspera;
        setDataReserva(tempoEspera); 
    }

    public InterfaceCli getInterfaceCli() {
        return interfaceCli;
    }

    public void setInterfaceCli(InterfaceCli interfaceCli) {
        this.interfaceCli = interfaceCli;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }
    
    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }
    
    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(int tempoEspera) {
        dataReserva = new Date(this.getDataRegistro().getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(this.dataReserva);
        c.add(Calendar.DATE, +tempoEspera);
        this.dataReserva = c.getTime();
        
    }
    
    @Override
    public String toString() {
        return "Reserva{" 
                + "clienteNome=" + getClienteNome()
                + ", dataRegistro=" + getDataRegistro() 
                + ", livroId=" + livroId
                + '}';
    }
}

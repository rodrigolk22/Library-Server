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
 * Registro reserva de um livro contendo a interface do cliente que deverá 
 * receber a notificação.
 * @author Rodrigo e Jordan
 */
public class Reserva extends Registro {
    
    /**
     * ID do livro reservado.
     */
    private int livroId;
    
    /**
     * Referência da interface do cliente que irá receber a notificação.
     */
    private InterfaceCli interfaceCli;
    
    /**
     * Tempo máximo em dias que o cliente ficará esperando a notficação.
     */
    private int tempoEspera;

    /**
     * Data máxima para espera da notificação.
     */
    private Date dataReserva;
    
    /**
     * Contrutor da Reserva. 
     * @param livroId
     * @param clienteNome
     * @param interfaceCli
     * @param tempoEspera 
     */
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

    /**
     * Gera automaticamente a data de reserva a partir da
     * data de criação da reserva somado ao tempo de espera.
     * @param tempoEspera 
     */
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

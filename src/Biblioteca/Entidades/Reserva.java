/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Entidades;

import Biblioteca.Interfaces.InterfaceCli;

/**
 * Entidade para reserva de um livro contendo a interface do cliente que deverá 
 * receber a notificação.
 * @author Rodrigo e Jordan
 */
public class Reserva extends Ocorrencia {
    
    private int livroId;
    
    private InterfaceCli interfaceCli;

    public Reserva(int livroId, String clienteNome, InterfaceCli interfaceCli) {
        setClienteNome(clienteNome);
        this.livroId = livroId;
        this.interfaceCli = interfaceCli;
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
    
    @Override
    public String toString() {
        return "Reserva{" 
                + "clienteNome=" + getClienteNome()
                + ", dataOcorrencia=" + getDataOcorrencia() 
                + ", livroId=" + livroId
                + '}';
    }
}

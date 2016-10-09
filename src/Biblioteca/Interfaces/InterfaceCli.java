/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Rodrigo e Jordan
 */
public interface InterfaceCli extends Remote {
    
    /**
     * Método remoto para exibir o aviso de um livro disponível
     * @param mensagem
     * @throws RemoteException 
     */
    public void notificar(String mensagem) throws RemoteException;
    
}

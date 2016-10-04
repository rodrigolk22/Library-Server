/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Rodrigo e Jordan
 */
public interface InterfaceCli extends Remote {
    public void exibir(int livroId) throws RemoteException;
}

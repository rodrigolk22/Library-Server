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
 * @author jordan
 */
public interface InterfaceCli extends Remote {
    public void echo(String str) throws RemoteException;
}

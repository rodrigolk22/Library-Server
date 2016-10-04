/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo e Jordan
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {

    
    public ServImpl() throws RemoteException {
        
    }

    Estoque estoque = new Estoque();
    
    @Override
    public void consultarLivro(int livroId, InterfaceCli interfaceCli) throws RemoteException {
        try {
            // invocação remota
            if(estoque.contemLivro(livroId)){
                interfaceCli.exibir(33);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ServImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

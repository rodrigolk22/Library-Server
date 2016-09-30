/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloWorld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jordan
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {

    
    public ServImpl() throws RemoteException {
        
    }

    @Override
    public void chamar(String nomeCli, InterfaceCli interfaceCli) throws RemoteException {
        try {
            // inovocação remota
            interfaceCli.echo(nomeCli);
        } catch (RemoteException ex) {
            Logger.getLogger(ServImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo e Jordan
 */
public class Servidor {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // inicia o serviço de nomes
            Registry referenciaServicoNomes = LocateRegistry.createRegistry(9000);
            
            ServImpl servImpl = new ServImpl();
            
            // adiciona referencia de servImpl no serviço de nomes
            referenciaServicoNomes.rebind("Servidor_Biblioteca", servImpl);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}

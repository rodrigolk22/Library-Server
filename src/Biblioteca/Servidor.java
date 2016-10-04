/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo e Jordan
 */
public class Servidor {

    public static Livro livro_1 = new Livro();
    public static Estoque estoque = new Estoque();
  
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
            
            livro_1.setId(1);
            livro_1.setAutor("Murilo Barros Cunha");
            livro_1.setTitulo("Lendas Perdidas");
            livro_1.setCategoria("Literatura Brasileira");
            livro_1.setQuantidade(2);
            
            estoque.adicionaLivro(livro_1);
            
            //System.out.println("Livro 1 existe?"+estoque.contemLivro(1));
            
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Rodrigo e Jordan
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {
    
    public static ListaLivro listaLivro = new ListaLivro();
    
    public ServImpl() throws RemoteException {
        
        Livro livro_1 = new Livro();
        livro_1.setId(1);
        livro_1.setAutor("Murilo Barros Cunha");
        livro_1.setTitulo("Lendas Perdidas");
        livro_1.setCategoria("Literatura Brasileira");
        livro_1.setQuantidade(2);
        listaLivro.adicionaLivro(livro_1);

        Livro livro_2 = new Livro();
        livro_2.setId(2);
        livro_2.setAutor("Leandro e leonardo");
        livro_2.setTitulo("Lendas Perdidas 2");
        livro_2.setCategoria("Literatura Brasileira");
        livro_2.setQuantidade(21);
        listaLivro.adicionaLivro(livro_2);
        
    }
    
    /**
     *
     * @param livroId
     * @param interfaceCli
     * @return
     * @throws RemoteException
     */
    @Override
    public List consultarLivro(int livroId, InterfaceCli interfaceCli) throws RemoteException {
        
        // invocação remota
        return listaLivro.consultaLivroId(livroId);
    }
    
    
    
}

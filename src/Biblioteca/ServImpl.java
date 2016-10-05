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
    
    
    @Override
    public List<Livro> consultarTodosLivros() throws RemoteException {
        return listaLivro.listarTodosLivros();
    }
    
    public Livro consultarLivro(int livroId) throws RemoteException {
        return listaLivro.consultaLivro(livroId);
    }
    
    /**
     * 
     * @param livroId
     * @return
     * @throws RemoteException 
     */
    @Override
    public String emprestarLivro(int livroId) throws RemoteException {
        
        // PROCURAR LIVRO PELO ID
        // criar uma lista de livros 
        // se retornar mais de 1 livro, dar um erro
        return "";
    }

    @Override
    public String renovarLivro(int livroId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String devolverLivro(int livroId) throws RemoteException {
        // listaregistro
        // roe
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String reservarLivro(int livroId, InterfaceCli interfaceCli) throws RemoteException {
        
        
        
        // proocurar livro
        // verificar se o usuário possui multa
        // criar reserva (salvando a rferência da InterfaceCli)
        // adicionar reserva na lista
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Interfaces;

import Biblioteca.Entidades.Livro;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Rodrigo e Jordan
 */
public interface InterfaceServ extends Remote {
    
    /**
     * Método remoto para listar os livros no acervo.
     * @return
     * @throws RemoteException 
     */
    public List<Livro> consultarTodosLivros() throws RemoteException;
    
    /**
     * Método remoto para consultar um livro no acervo por id.
     * @param livroId
     * @return
     * @throws RemoteException 
     */
    public Livro consultarLivro(int livroId) throws RemoteException;
    
    /**
    * Método remoto para realizar o empréstimo de um livro do acervo.
    * @param livroId
    * @param clienteNome
    * @return
    * @throws RemoteException 
    */
    public String emprestarLivro(int livroId, String clienteNome) throws RemoteException;
    
    /**
     * Método remoto para renovar o empréstimo de um livro do acervo.
     * @param livroId
     * @return
     * @throws RemoteException 
     */
    public String renovarLivro(int livroId) throws RemoteException;
    
    /**
     * Método remoto para devolver um livro emprestado ao acervo.
     * @param livroId
     * @return
     * @throws RemoteException 
     */
    public String devolverLivro(int livroId) throws RemoteException;
    
    /**
     * Método remoto para reservar um livro que foi emprestado do acervo.
     * @param livroId
     * @param clienteNome
     * @param interfaceCli
     * @return
     * @throws RemoteException 
     */
    public String reservarLivro(int livroId, String clienteNome, InterfaceCli interfaceCli, int tempoEspera) throws RemoteException;
}

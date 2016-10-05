/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Rodrigo e Jordan
 */
public interface InterfaceServ extends Remote {
    public List<Livro> consultarTodosLivros() throws RemoteException;
    public Livro consultarLivro(int livroId) throws RemoteException;
    public String emprestarLivro(int livroId) throws RemoteException;
    public String renovarLivro(int livroId) throws RemoteException;
    public String devolverLivro(int livroId) throws RemoteException;
    public String reservarLivro(int livroId, InterfaceCli interfaceCli) throws RemoteException;
}

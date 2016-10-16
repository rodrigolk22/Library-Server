/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import Biblioteca.Entidades.*;
import Biblioteca.Interfaces.*;
import Biblioteca.Listas.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Rodrigo e Jordan
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {
    
    public ServImpl() throws RemoteException {}
    
    @Override
    public List<Livro> consultarTodosLivros() throws RemoteException {
        return Servidor.listaLivro.todos();
    }
    
    @Override
    public Livro consultarLivro(int livroId) throws RemoteException {
        return Servidor.listaLivro.consultar(livroId);
    }

    @Override
    public String emprestarLivro(int livroId, String clienteNome) throws RemoteException {
        
        Livro livro = Servidor.listaLivro.consultar(livroId);
        
        if(livro == null){
            return "Livro não encontrado! Empréstimo não efetuado!";
        }else if(livro.getQuantidade() == 0){
            return "Não há unidades disponíveis para empréstimo! Empréstimo não efetuado!";
        }else if(Servidor.listaEmprestimo.totalLivrosEmprestados(clienteNome) == Config.QUANTIDADE_MAXIMA_EMPRESTIMOS){
            return "O limite de livros para empréstimo foi atingido! Empréstimo não efetuado!";
        }
        
        livro.reduzirQuantidade();
        
        Emprestimo emprestimo = new Emprestimo(livroId, clienteNome);
        Servidor.listaEmprestimo.adicionar(emprestimo);
        
        System.out.println("Novo empréstimo:" + emprestimo);
        
        return "Empréstimo foi efetuado!";
    }

    @Override
    public String renovarLivro(int livroId) throws RemoteException {
        
        // TODO
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String devolverLivro(int livroId) throws RemoteException {
        
        // TODO
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String reservarLivro(int livroId, String clienteNome, InterfaceCli interfaceCli) throws RemoteException {
        
        Livro livro = Servidor.listaLivro.consultar(livroId);
                
        if(livro == null){
            return "Livro não encontrado! Reserva não efetuada!";
        }else if(livro.getQuantidade() > 0){
            return "Existe unidades disponíveis para empréstimo! Reserva não efetuada!";
        }
        
        //Impede que seja feito mais uma reserva para o mesmo livro
        if(Servidor.listaReserva.verificaRedundancia(clienteNome, livroId) == true){
            return "Reserva deste livro ja foi efetuada pelo usuário!";
        }
        //Efetua a reserva
        Reserva reserva = new Reserva(livroId, clienteNome, interfaceCli);
        Servidor.listaReserva.adicionar(reserva);
        
        System.out.println("Nova reserva:" + reserva);
        
        return "Reserva efetuada!";
    }
    
}

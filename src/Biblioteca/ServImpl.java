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

/**
 *
 * @author Rodrigo e Jordan
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {
    
    public ServImpl() throws RemoteException {}
    
    @Override
    public ListaLivro consultarTodosLivros() throws RemoteException {
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
        }else if(Servidor.listaEmprestimo.contem(livroId, clienteNome)){
            return "É limitado apenas um volume do mesmo livro por pessoa! Empréstimo não efetuado!";
        }
        
        livro.reduzirQuantidade();
        
        Emprestimo emprestimo = new Emprestimo(livroId, clienteNome);
        Servidor.listaEmprestimo.adicionar(emprestimo);
        
        System.out.println("Novo empréstimo:" + emprestimo);
        
        return "Empréstimo foi efetuado!";
    }

    @Override
    public String renovarLivro(int livroId, String clienteNome) throws RemoteException {
        
        if(!Servidor.listaEmprestimo.contem(livroId, clienteNome)){
            return "Renovação não disponível! Livro não consta como emprestado para o usuário!";
        }else if(Servidor.listaReserva.quantidadeInteressados(livroId) > 0){
            return "Renovação não disponível! Livro foi reservado!";
        }else if(Servidor.listaEmprestimo.quantidadePendencias(clienteNome) > 0){
            return "Renovação não disponivel! Existe livro com atraso para ser entregue!";
        }else if(Servidor.listaPenalidade.quantidadePendencias(clienteNome) > 0){
            return "Renovação não disponivel! Existe multa pendente!";
        }
        
        // extende o prazo do empréstimo
        Emprestimo emprestimo = Servidor.listaEmprestimo.consultar(livroId, clienteNome);
        emprestimo.extenderPrazo();
        
        return "Emprestimo renovado!";
    }

    @Override
    public String devolverLivro(int livroId, String clienteNome) throws RemoteException {
        
        // pega o empréstimo 
        Emprestimo emprestimo = Servidor.listaEmprestimo.consultar(livroId, clienteNome);
        
        if (emprestimo == null) {
            return "Você não havia emprestado esse livro!";
        }
        
        // aumenta a quantidade do livro
        Livro livro = Servidor.listaLivro.consultar(livroId);
        livro.aumentarQuantidade();
        
        // remove o empréstimo da lista
        Servidor.listaEmprestimo.remover(livroId, clienteNome);
        
        // se estiver vencido, registra uma penalidade
        if(emprestimo.estaVencido()){
            Penalidade penalidade = new Penalidade(clienteNome);
            Servidor.listaPenalidade.adicionar(penalidade);
            return  "Livro devolvido com atraso! Registrada uma multa!";
        }
        
        return "Livro devolvido!";
    }

    @Override
    public String reservarLivro(int livroId, String clienteNome, InterfaceCli interfaceCli, int tempoEspera) throws RemoteException {
        
        Livro livro = Servidor.listaLivro.consultar(livroId);
                
        if(livro == null){
            return "Livro não encontrado! Reserva não efetuada!";
        }else if(livro.getQuantidade() > 0){
            return "Existem unidades disponíveis para empréstimo! Reserva não efetuada!";
        }
        
        //Impede que seja feito mais uma reserva para o mesmo livro
        if(Servidor.listaReserva.contem(clienteNome, livroId)){
            return "Reserva deste livro ja foi efetuada pelo usuário!";
        }
        
        //Efetua a reserva
        Reserva reserva = new Reserva(livroId, clienteNome, interfaceCli, tempoEspera);
        Servidor.listaReserva.adicionar(reserva);
        
        System.out.println("Nova reserva:" + reserva);
        
        return "Reserva efetuada!";
    }
    
}

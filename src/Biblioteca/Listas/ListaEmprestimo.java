/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Listas;

import Biblioteca.Entidades.Emprestimo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rodrigo e Jordan
 */
public class ListaEmprestimo {
    
    private List<Emprestimo> listaEmprestimo;
    
    public ListaEmprestimo() { 
        listaEmprestimo = new ArrayList();
    }

    public List<Emprestimo> getListaEmprestimo() {
        return listaEmprestimo;
    }
    
    public void adicionar(Emprestimo emprestimo){
        listaEmprestimo.add(emprestimo);
    }
    
    public void remover(int livroId, String clienteNome) {
        for (Emprestimo e : listaEmprestimo) {
            if(e.getLivroId() == livroId && e.getClienteNome().equals(clienteNome)){
                listaEmprestimo.remove(e);
                break;
            }
        }
    }
    
    public int totalLivrosEmprestados(String clienteNome){
        int quantidadeLivro = 0;
        for (Emprestimo e : listaEmprestimo) {
            if(e.getClienteNome().equals(clienteNome)){
                quantidadeLivro++;
            }
        }
        return quantidadeLivro;
    }
    
    public boolean contem(int livroId, String clienteNome){
        for (Emprestimo e : listaEmprestimo) {
            if(clienteNome.equals(e.getClienteNome()) && e.getLivroId() == livroId){
                return true;
            }
        }
        return false;
    }
    
    public Emprestimo consultar(int livroId, String clienteNome) {
        for (Emprestimo e : listaEmprestimo) {
            if(e.getLivroId() == livroId && clienteNome.equals(e.getClienteNome())){
                return e;
            }
        }
        return null;
    }
    
    public int quantidadePendencias(String clienteNome) {
        int pendencia = 0;
        Date dataAtual = new Date(System.currentTimeMillis());
        for (Emprestimo e : listaEmprestimo) {
            if(clienteNome.equals(e.getClienteNome()) && dataAtual.after(e.getDataParaDevolucao())){
                pendencia++;
            }
        }
        return pendencia;
    }
}

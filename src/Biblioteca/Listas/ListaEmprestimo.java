/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Listas;

import Biblioteca.Entidades.Emprestimo;
import java.util.ArrayList;
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
    
    public void remover(int livroId) {
        for (Emprestimo e : listaEmprestimo) {
            if(e.getLivroId() == livroId){
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
}

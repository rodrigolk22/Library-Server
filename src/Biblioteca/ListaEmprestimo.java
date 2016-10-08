/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo e Jordan
 */
public class ListaEmprestimo {
    
    public ListaEmprestimo() { }
    
    private List<Emprestimo> listaEmprestimo = new ArrayList<Emprestimo>();
    
    public List<Emprestimo> getEmprestimo() {
	return listaEmprestimo;
    }
    
    public void adicionaEmprestimo(Emprestimo emprestimo){
        listaEmprestimo.add(emprestimo);
    }
    
    public void retiraEmprestimo(int livroId){
        for (Emprestimo e : listaEmprestimo) {
            if(e.getLivroId() == livroId){
                listaEmprestimo.remove(e);
                break;
            }
        }
        
    }
    
    public int totalLivrosEmprestados(String nome){
        int quantidadeLivro = 0;
        for (Emprestimo e : listaEmprestimo) {
            if(e.getNome() == nome){
                quantidadeLivro++;
            }
        }
        return quantidadeLivro;
    }

}

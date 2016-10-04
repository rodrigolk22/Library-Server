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
 * @author redproxy
 */
public class Estoque {
    public Estoque() { }
    
    private List<Livro> estoqueLivro = new ArrayList<Livro>();
    
    public List<Livro> getEstoque() {
		return estoqueLivro;
    }

    public void setEstoque(List<Livro> estoqueLivro) {
		this.estoqueLivro = estoqueLivro;
    }
    
    public void adicionaLivro(List<Livro> estoqueLivro, Livro livro){
        estoqueLivro.add(livro);
    }
    
    public boolean contemLivro(List<Livro> estoqueLivro, Livro livro){  
        return estoqueLivro.contains(livro);
    }
    
    public void removeLivro(List<Livro> estoqueLivro, Livro livro){
        estoqueLivro.remove(livro);
    }
    
    public void atualizaLivro(List<Livro> estoqueLivro, Livro livro){
        for(Livro l : estoqueLivro){
            if(l.getId() == livro.getId()){
                l = livro;
                break;
             }
        }
    }
}

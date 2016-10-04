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

    public void setEstoque(List<Livro> novo_estoqueLivro) {
	estoqueLivro = novo_estoqueLivro;
    }
    
    public void adicionaLivro(Livro livro){
        estoqueLivro.add(livro);
    }
    
    public boolean contemLivro(int Id){
        Livro livro = new Livro();
        for(Livro l : estoqueLivro){
            if(l.getId() == Id){
                livro = l;
                break;
             }
        }
        return estoqueLivro.contains(livro);
    }
    
    public void removeLivro(int Id){
        for(Livro l : estoqueLivro){
            if(l.getId() == Id){
                estoqueLivro.remove(l);
                break;
             }
        }
    }
    
    public void atualizaLivro(List<Livro> estoqueLivro, Livro livro){
        int i = 0;
        for(Livro l : estoqueLivro){
            i++;
            if(l.getId() == livro.getId()){
                estoqueLivro.set(i, livro);
                break;
             }
        }
    }
    
    public Livro consultaLivroId(List<Livro> estoqueLivro, int Id){
        Livro livro = new Livro();
        for(Livro l : estoqueLivro){
            if(l.getId() == Id){
                livro = l;
             }
        }
        return livro;
    }
}

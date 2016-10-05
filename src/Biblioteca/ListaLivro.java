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
public class ListaLivro {
    
    public ListaLivro() { }
    
    private List<Livro> listaLivro = new ArrayList<Livro>();
    
    public List<Livro> getLista() {
		return listaLivro;
    }

    public void setLista(List<Livro> novo_listaLivro) {
	listaLivro = novo_listaLivro;
    }
    
    public void adicionaLivro(Livro livro){
        listaLivro.add(livro);
    }
    
    public boolean contemLivro(int Id){
        Livro livro = new Livro();
        for(Livro l : listaLivro){
            if(l.getId() == Id){
                livro = l;
                break;
             }
        }
        return listaLivro.contains(livro);
    }
    
    public void removeLivro(int Id){
        for(Livro l : listaLivro){
            if(l.getId() == Id){
                listaLivro.remove(l);
                break;
             }
        }
    }
    
    public void atualizaLivro(Livro livro){
        int i = 0;
        for(Livro l : listaLivro){
            i++;
            if(l.getId() == livro.getId()){
                listaLivro.set(i, livro);
                break;
             }
        }
    }
    
    public List listarTodosLivros(){
        return listaLivro;
    } 
    
    public List listarLivrosDisponiveis(){
        List<Livro> lista = new ArrayList<>();
        for (Livro l : listaLivro) {
            if(l.getQuantidade() > 0){
                lista.add(l);
            }
        }
        return lista;
    } 
    
    public Livro consultaLivro(int Id){
        for (Livro l : listaLivro) {
            if(l.getId() == Id){
                return l;
            }
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Entidades;

import java.io.Serializable;

/**
 * Entidade de Livro
 * @author Rodrigo e Jordan
 */
public class Livro implements Serializable {
    
    /**
     * Identificador único do livro.
     */
    private int id;
    
    /**
     * Quantidade disponível para empréstimo no acervo.
     */
    private int quantidade;

    /**
     * Título do livro.
     */
    private String titulo;

    /**
     * Nome do autor do livro.
     */
    private String autor;

    /**
     * Categoria do livro.
     */
    private String categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    /**
     * Decrementa a quantidade disponível do livro no acervo.
     */
    public void reduzirQuantidade() {
        this.quantidade--;
    }
    
    /**
     * Incrementa a quantidade disponível do livro no acervo.
     */
    public void aumentarQuantidade() {
        this.quantidade++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Livro{" 
                + "id=" + id 
                + ", quantidade=" + quantidade 
                + ", titulo=" + titulo 
                + ", autor=" + autor 
                + ", categoria=" + categoria 
                + '}';
    }
}

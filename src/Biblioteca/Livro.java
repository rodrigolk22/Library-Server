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

public class Livro {
    
    private int id;
    
    private int estoque;

    private String titulo;

    private String autor;

    private String categoria;

    public Livro() { }

    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }
    
    public int getEstoque() {
            return estoque;
    }

    public void setEstoque(int estoque) {
            this.estoque = estoque;
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
}

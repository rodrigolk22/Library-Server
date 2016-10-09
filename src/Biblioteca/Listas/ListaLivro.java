/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Listas;

import Biblioteca.Entidades.Livro;
import java.util.ArrayList;
import java.util.List;

public class ListaLivro {

    private List<Livro> listaLivro;

    public ListaLivro() {
        listaLivro = new ArrayList();
    }

    public List<Livro> getListaLivro() {
        return listaLivro;
    }

    public void setListaLivro(List<Livro> listaLivro) {
        this.listaLivro = listaLivro;
    }

    /**
     * Adiciona um livro na lista
     *
     * @param livro
     */
    public void adicionar(Livro livro) {
        listaLivro.add(livro);
    }

    /**
     * Verifica se a lista contém um livro com o id especificado
     *
     * @param livroId
     * @return
     */
    public boolean contem(int livroId) {
        Livro livro = new Livro();
        for (Livro l : listaLivro) {
            if (l.getId() == livroId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove um livro da lista com o id especificado
     *
     * @param livroId
     */
    public void remover(int livroId) {
        for (Livro l : listaLivro) {
            if (l.getId() == livroId) {
                listaLivro.remove(l);
                break;
            }
        }
    }

    /**
     * Atualiza os dados de um livro
     *
     * @param livro
     */
    public void atualizar(Livro livro) {
        int i = 0;
        for (Livro l : listaLivro) {
            i++;
            if (l.getId() == livro.getId()) {
                listaLivro.set(i, livro);
                break;
            }
        }
    }

    /**
     * Retorna todos os livros da lista
     *
     * @return
     */
    public List todos() {
        return listaLivro;
    }

    /**
     * Retorna todos os livros disponíveis para empréstimo, ou seja, aqueles que
     * tem quantidade maior que 0.
     *
     * @return List
     */
    public List todosDisponiveis() {
        List<Livro> lista = new ArrayList<>();
        for (Livro l : listaLivro) {
            if (l.getQuantidade() > 0) {
                lista.add(l);
            }
        }
        return lista;
    }

    /**
     * Retorna um livro pelo seu id. Se o livro não existir, retorna nulo.
     * @param livroId
     * @return 
     */
    public Livro consultar(int livroId) {
        for (Livro l : listaLivro) {
            if (l.getId() == livroId) {
                return l;
            }
        }
        return null;
    }
}

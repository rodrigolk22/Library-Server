/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Listas;

import Biblioteca.Config;
import Biblioteca.Entidades.Emprestimo;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public String validade(int livroId) {
        Date dataAtual = new Date(System.currentTimeMillis());
        for (Emprestimo e : listaEmprestimo) {
            if(e.getLivroId() == livroId){
                if(dataAtual.after(e.getDataDevolucao())){
                    return e.getClienteNome();
                }
                break;
            }
        }
        return "";
    }
    
    public int pendencia(String clienteNome) {
        int pendencia = 0;
        Date dataAtual = new Date(System.currentTimeMillis());
        for (Emprestimo e : listaEmprestimo) {
            if(clienteNome.equals(e.getClienteNome()) && dataAtual.after(e.getDataDevolucao())){
                pendencia++;
            }
        }
        return pendencia;
    }
    
    public void extendePrazo(int livroId, String clienteNome){
        for (Emprestimo e : listaEmprestimo) {
            if(e.getLivroId() == livroId && clienteNome.equals(e.getClienteNome())){
                Calendar c = Calendar.getInstance(); 
                c.setTime(e.getDataDevolucao()); 
                c.add(Calendar.DATE, Config.TEMPO_MAXIMO_DIAS_EMPRESTIMO);
                e.setDataDevolucao(c.getTime());
            }
        }
    }
    public boolean contem(String clienteNome, int livroId){
        for (Emprestimo e : listaEmprestimo) {
            if(clienteNome.equals(e.getClienteNome()) && e.getLivroId() == livroId){
                return true;
            }
        }
        return false;
    }
}

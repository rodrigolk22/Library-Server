/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Listas;

import Biblioteca.Entidades.Penalidade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rodrigo e Jordan
 */
public class ListaPenalidade {
    
    private List<Penalidade> listaPenalidade;
    
    public ListaPenalidade() {
        listaPenalidade = new ArrayList();
    }
    
    public List<Penalidade> getListaPenalidade() {
        return listaPenalidade;
    }
    
    public void adicionar(Penalidade penalidade){
        listaPenalidade.add(penalidade);
    }
    public int quantidadePendencias(String clienteNome) {
        int pendencia = 0;
        Date dataAtual = new Date(System.currentTimeMillis());
        for (Penalidade p : listaPenalidade) {
            if(clienteNome.equals(p.getClienteNome())){
                pendencia++;
            }
        }
        return pendencia;
    }
}

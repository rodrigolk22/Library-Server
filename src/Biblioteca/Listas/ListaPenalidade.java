/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Listas;

import Biblioteca.Entidades.Penalidade;
import java.util.ArrayList;
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

}

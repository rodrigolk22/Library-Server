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
public class Emprestimo {
    
    public Emprestimo() { }
    
    private List<Registro> emprestimoItem = new ArrayList<Registro>();
    
    public List<Registro> getEmprestimoItems() {
		return emprestimoItem;
    }

    public void setEmprestimoItem(List<Registro> emprestimoItem) {
		this.emprestimoItem = emprestimoItem;
    }
}

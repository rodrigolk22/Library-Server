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
public class Penalidade {
    
    public Penalidade() { }
    
    private List<Registro> penalidadeItem = new ArrayList<Registro>();
    
    public List<Registro> getPenalidadeItems() {
		return penalidadeItem;
    }

    public void setPenalidadeItem(List<Registro> penalidadeItem) {
		this.penalidadeItem = penalidadeItem;
    }
}

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
public class Reserva {
    
    public Reserva () { }
    
    private List<Registro> reservaItem = new ArrayList<Registro>();
    
    public List<Registro> getReservaItems() {
		return reservaItem;
    }

    public void setReservaItem(List<Registro> reservaItem) {
		this.reservaItem = reservaItem;
    }
}

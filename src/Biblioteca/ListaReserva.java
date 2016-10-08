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
 * @author Rodrigo e Jordan
 */
public class ListaReserva extends Registro {
    
    public ListaReserva() { }
    
    private List<Reserva> listaReserva = new ArrayList<Reserva>();
    
    public ListaReserva(ArrayList<Reserva> listaReserva){
        this.listaReserva = listaReserva;
    }
    
    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

}

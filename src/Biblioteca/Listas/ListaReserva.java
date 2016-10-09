package Biblioteca.Listas;

import Biblioteca.Entidades.Reserva;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo e Jordan
 */
public class ListaReserva {
    
    private List<Reserva> listaReserva;
    
    public ListaReserva() {
        listaReserva = new ArrayList();
    }
    
    public List<Reserva> getListaReserva() {
        return listaReserva;
    }
}

package Biblioteca.Listas;

import Biblioteca.Entidades.Reserva;
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
    
    public void adicionar(Reserva reserva){
        listaReserva.add(reserva);
    }
    
    public void remover(String clienteNome) {
        for (Reserva e : listaReserva) {
            if(e.getClienteNome() == clienteNome){
                listaReserva.remove(e);
                break;
            }
        }
    }
    
    public boolean verificaRedundancia(String clienteNome, int livroId){
        String nome;
        for (Reserva e : listaReserva) {
            if(clienteNome.equals(e.getClienteNome()) && e.getLivroId() == livroId){
                return true;
            }
        }
        return false;
    }
}

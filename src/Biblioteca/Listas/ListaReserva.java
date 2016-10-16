package Biblioteca.Listas;

import Biblioteca.Entidades.Reserva;
import Biblioteca.Entidades.Reserva;
import java.util.ArrayList;
import java.util.Date;
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
        for (Reserva r : listaReserva) {
            if(r.getClienteNome() == clienteNome){
                listaReserva.remove(r);
                break;
            }
        }
    }
    
    public boolean verificaRedundancia(String clienteNome, int livroId){
        String nome;
        for (Reserva r : listaReserva) {
            if(clienteNome.equals(r.getClienteNome()) && r.getLivroId() == livroId){
                removeVencido();
                return true;
            }
        }
        removeVencido();
        return false;
    }
    
    public void removeVencido(){
        Date dataAtual = new Date(System.currentTimeMillis());
        for (Reserva r : listaReserva) {
            if(dataAtual.after(r.getDataReserva())){
                listaReserva.remove(r);
            }
        }
    }
}

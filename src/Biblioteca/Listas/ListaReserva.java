package Biblioteca.Listas;

import Biblioteca.Entidades.Penalidade;
import Biblioteca.Entidades.Reserva;
import Biblioteca.Interfaces.InterfaceCli;
import java.rmi.RemoteException;
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
    
    public boolean contem(int livroId,String clienteNome){
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
    
    public int quantidadeInteressados(int livroId){
        int interessados = 0;
        for (Reserva r : listaReserva) {
            if(r.getLivroId() == livroId){
                interessados++;
            }
        }
        return interessados;
    }
    
    public void notificarInteressados(int livroId, String titulo) throws RemoteException {
        Date dataAtual = new Date(System.currentTimeMillis());
        InterfaceCli interfaceCli = null;
        for (Reserva r : listaReserva) {
            if(r.getLivroId() == livroId && dataAtual.before(r.getDataReserva())){
                interfaceCli = r.getInterfaceCli();
                interfaceCli.notificar("O livro "+titulo+" esta disponivel para emprestimo!");
            }else if(dataAtual.after(r.getDataReserva())){
                listaReserva.remove(r);
            }
        }
    }
}

package Biblioteca.Listas;

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
    
    /**
     * Adiciona uma reserva na lista.
     * @param reserva 
     */
    public void adicionar(Reserva reserva){
        listaReserva.add(reserva);
    }
    
    /**
     * Remove uma reserva da lista.
     * @param clienteNome 
     */
    public void remover(int livroId, String clienteNome) {
        for (Reserva r : listaReserva) {
            if(r.getClienteNome().equals(clienteNome) && r.getLivroId() == livroId){
                listaReserva.remove(r);
                break;
            }
        }
    }
    
    /**
     * Verifica se a lista contém uma reserva com o id especificado. 
     * Enquanto percorre as reservas, já remove as vencidas.
     * @param livroId
     * @param clienteNome
     * @return 
     */
    public boolean contem(int livroId, String clienteNome){
        
        Date dataAtual = new Date(System.currentTimeMillis());
        
        for (Reserva reserva : listaReserva) {
            //System.out.println(dataAtual);
            //System.out.println(reserva.getDataReserva());
            
            
            if(clienteNome.equals(reserva.getClienteNome()) && reserva.getLivroId() == livroId){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Conta a quantidade de clientes que reservaram o livro.
     * @param livroId
     * @return 
     */
    public int quantidadeInteressados(int livroId){
        int interessados = 0;
        for (Reserva reserva : listaReserva) {
            // remove reservas vencidas
            if(reserva.getLivroId() == livroId){
                interessados++;
            }
        }
        return interessados;
    }
    
    /**
     * Notifica a lista de interessados por um livro através de chamada remota
     * usando a referência para a sua interface.
     * @param livroId
     * @param titulo
     * @throws RemoteException 
     */
    public void notificarInteressados(int livroId, String titulo) throws RemoteException {
        Date dataAtual = new Date(System.currentTimeMillis());
        List<Reserva> novaLista = new ArrayList<>();
        InterfaceCli interfaceCli = null;
        for (Reserva reserva : listaReserva) {
            if(reserva.getLivroId() == livroId && dataAtual.before(reserva.getDataReserva())){
                //System.out.println(dataAtual);
                //System.out.println(reserva.getDataReserva());
                interfaceCli = reserva.getInterfaceCli();
                interfaceCli.notificar("O livro " + titulo + " está disponível para empréstimo!");
                novaLista.add(reserva);
            }
        }
        this.listaReserva = novaLista;
    }
}

package Biblioteca;

import Biblioteca.Entidades.Livro;
import Biblioteca.Listas.*;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo e Jordan
 */
public class Servidor {
    
    public static ListaLivro listaLivro = new ListaLivro();
    public static ListaEmprestimo listaEmprestimo = new ListaEmprestimo();
    public static ListaPenalidade listaPenalidade = new ListaPenalidade();
    public static ListaReserva listaReserva = new ListaReserva();
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Livro livro_1 = new Livro();
        livro_1.setId(1);
        livro_1.setAutor("Murilo Barros Cunha");
        livro_1.setTitulo("Lendas Perdidas");
        livro_1.setCategoria("Literatura Brasileira");
        livro_1.setQuantidade(2);
        listaLivro.adicionar(livro_1);

        Livro livro_2 = new Livro();
        livro_2.setId(2);
        livro_2.setAutor("Daniel Goncalves Barbosa");
        livro_2.setTitulo("Ruínas Ancestrais");
        livro_2.setCategoria("História");
        livro_2.setQuantidade(3);
        listaLivro.adicionar(livro_2);
        
        Livro livro_3 = new Livro();
        livro_3.setId(3);
        livro_3.setAutor("Bruna Fernandes Azevedo");
        livro_3.setTitulo("Eu a patroa e as crianças");
        livro_3.setCategoria("Psicologia");
        livro_3.setQuantidade(2);
        listaLivro.adicionar(livro_3);
        
        Livro livro_4 = new Livro();
        livro_4.setId(4);
        livro_4.setAutor("André Marques");
        livro_4.setTitulo("50 receitas com mocotó");
        livro_4.setCategoria("Culinária");
        livro_4.setQuantidade(4);
        listaLivro.adicionar(livro_4);
        
        Livro livro_5 = new Livro();
        livro_5.setId(5);
        livro_5.setAutor("Lara Sousa Pereira");
        livro_5.setTitulo("Bandeirantes modernos");
        livro_5.setCategoria("Literatura Brasileira");
        livro_5.setQuantidade(0);
        listaLivro.adicionar(livro_5);
        
        try {
            // inicia o serviço de nomes
            Registry referenciaServicoNomes = LocateRegistry.createRegistry(9000);
            
            ServImpl servImpl = new ServImpl();
            
            // adiciona referencia de servImpl no serviço de nomes
            referenciaServicoNomes.rebind("Servidor_Biblioteca", servImpl);
            
            System.out.println("[iniciado] localhost:Servidor_Biblioteca:9000");
            
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

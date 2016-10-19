package Biblioteca.Listas;

import Biblioteca.Entidades.Emprestimo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rodrigo e Jordan
 */
public class ListaEmprestimo {
    
    private List<Emprestimo> listaEmprestimo;
    
    public ListaEmprestimo() { 
        listaEmprestimo = new ArrayList();
    }

    public List<Emprestimo> getListaEmprestimo() {
        return listaEmprestimo;
    }
    
    /**
     * Adiciona um empréstimo na lista
     * @param emprestimo
     */
    public void adicionar(Emprestimo emprestimo){
        listaEmprestimo.add(emprestimo);
    }
    
    /**
     * Remove um empréstimo da lista
     * @param livroId
     * @param clienteNome 
     */
    public void remover(int livroId, String clienteNome) {
        for (Emprestimo e : listaEmprestimo) {
            if(e.getLivroId() == livroId && e.getClienteNome().equals(clienteNome)){
                listaEmprestimo.remove(e);
                break;
            }
        }
    }
    
    /**
     * Conta a quantidade de livros emprestados por um cliente.
     * @param clienteNome
     * @return 
     */
    public int totalLivrosEmprestados(String clienteNome){
        int quantidadeLivro = 0;
        for (Emprestimo e : listaEmprestimo) {
            if(e.getClienteNome().equals(clienteNome)){
                quantidadeLivro++;
            }
        }
        return quantidadeLivro;
    }
    
    /**
     * Verifica se a lista contém um empréstimo do livro e cliente especificados.
     * @param livroId
     * @param clienteNome
     * @return 
     */
    public boolean contem(int livroId, String clienteNome){
        for (Emprestimo e : listaEmprestimo) {
            if(clienteNome.equals(e.getClienteNome()) && e.getLivroId() == livroId){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um empréstimo especificado. Se o empréstimo não existir, retorna nulo.
     * @param livroId
     * @param clienteNome
     * @return 
     */
    public Emprestimo consultar(int livroId, String clienteNome) {
        for (Emprestimo e : listaEmprestimo) {
            if(e.getLivroId() == livroId && clienteNome.equals(e.getClienteNome())){
                return e;
            }
        }
        return null;
    }
    
    /**
     * Conta a quantidade de empréstimo pendentes para um cliente.
     * @param clienteNome
     * @return 
     */
    public int quantidadePendencias(String clienteNome) {
        int pendencia = 0;
        Date dataAtual = new Date(System.currentTimeMillis());
        for (Emprestimo e : listaEmprestimo) {
            if(clienteNome.equals(e.getClienteNome()) && dataAtual.after(e.getDataParaDevolucao())){
                pendencia++;
            }
        }
        return pendencia;
    }
}

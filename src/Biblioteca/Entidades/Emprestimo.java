/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca.Entidades;

import Biblioteca.Config;
import java.util.Calendar;
import java.util.Date;

/**
 * Registro de empréstimo de de um livro por um cliente.
 * @author Rodrigo e Jordan
 */
public class Emprestimo extends Registro {
    
    /**
     * Id do livro emprestado
     */
    private int livroId;
    
    /**
     * Data de vencimento do empréstimo (até quando o cliente deve devolver)
     */
    private Date dataParaDevolucao;

    public Emprestimo(int livroId, String clienteNome) {
        
        // calcula a data de devolução
        dataParaDevolucao = new Date(this.getDataRegistro().getTime());
        Calendar c = Calendar.getInstance(); 
        c.setTime(dataParaDevolucao); 
        c.add(Calendar.MINUTE, Config.TEMPO_MAXIMO_DIAS_EMPRESTIMO);
        dataParaDevolucao = c.getTime();
          
        // adiciona o nome do cliente e o id do livro
        setClienteNome(clienteNome);
        this.livroId = livroId;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }
    
    public Date getDataParaDevolucao() {
        return dataParaDevolucao;
    }

    public void setDataParaDevolucao(Date dataDevolucao) {
        this.dataParaDevolucao = dataDevolucao;
    }
    
    /**
     * Verifica se a data de devolução foi ultrapassada a partir da data atual.
     * @return 
     */
    public boolean estaVencido() {
        Date dataAtual = new Date(System.currentTimeMillis());
        if(dataAtual.after(this.getDataParaDevolucao())){
            return true;
        }
        return false;
    }
    
    /**
     * Extende o prazo do empréstimo (para o caso de uma renovação)
     */
    public void extenderPrazo(){
        Calendar c = Calendar.getInstance(); 
        c.setTime(this.getDataParaDevolucao()); 
        c.add(Calendar.DATE, Config.TEMPO_MAXIMO_DIAS_EMPRESTIMO);
        this.setDataParaDevolucao(c.getTime());
    }

    @Override
    public String toString() {
        return "Emprestimo{" 
                + "clienteNome=" + getClienteNome()
                + ", dataRegistro=" + getDataRegistro() 
                + ", livroId=" + livroId 
                + ", dataDevolucao=" + dataParaDevolucao 
                + '}';
    }
}

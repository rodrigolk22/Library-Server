/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.Calendar;


/**
 *
 * @author Rodrigo e Jordan
 */
public class Registro {
    
    private String nome;
    
    private int livroId;
    
    private Date data;
    
    private Calendar c;
    
    public Registro () {}
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setData(){
        this.data = c.getTime();
    }
    
    public Date getData(){
        return data;
    }
    public void setLivroId(int livroId){
        this.livroId = livroId;
    }
    
    public int getLivroId(){
        return livroId;
    }
}

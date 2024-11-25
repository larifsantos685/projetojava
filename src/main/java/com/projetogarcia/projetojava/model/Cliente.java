package com.projetogarcia.projetojava.model;

//POJO - Plain Old Java Object classe que tem: 




//Atributo, construtor, get e set, TODA TABELA VAI TER QUE TER UM POJO ESPELHO, e ela é do model
//No jpa so precisa do pojo
//no jdbc vc precisa do DAO e do service 
public class Cliente {
   
    private int id; 
    private String nome, email, telefone, endereco; 

    //Sobrecarga
    //Para eu poder entregar campos vazios
    //Esse construtor é para a tela de cadastro ficar vazia
    public Cliente(){

    }

    // Esse daqui é feito para o update
    public Cliente(int id, String nome, String email, String telefone, String endereco){
        this.id = id; 
        this.nome = nome; 
        this.email = email;
        this.telefone = telefone; 
        this.endereco = endereco; 


    }

    //Para inserir o registro
    public Cliente(String nome, String email, String telefone, String endereco){
        this.nome = nome; 
        this.email = email;
        this.telefone = telefone; 
        this.endereco = endereco;  
    }
    
    //O framwork pede get e setters
    public int getId(){
        return id; 
    }

    public String getEmail(){
        return email; 
    }

    public String getNome(){
        return nome; 
    }

    public String getTelefone(){
        return telefone; 
    }

    public String getEndereco(){
        return endereco; 
    }


    public void setEmail(String email){
        this.email = email; 

    }

    
    public void setNome(String nome){
        this.nome = nome; 

    }

    
    public void setId(int id){
        this.id = id; 

    }

    public void setTelefone(String telefone){
        this.telefone = telefone; 

    }
    public void setEndereco(String endereco){
        this.endereco = endereco; 
    }

    
    
}

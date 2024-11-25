package com.projetogarcia.projetojava.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    //O service que vai conectar o model comm a view
    @Autowired
    ClienteDAO cdao; 

    //Espelho - ele que chama o DAO
    public void inserirCliente(Cliente cli){
        cdao.inserirCliente(cli); 
    }

    public List<Map<String,Object>> obterTodosClientes(){
        return cdao.obterTodosClientes();
        //O map é como se fosse um Json
    }


    public void atualizarCliente(int id, Cliente cli){
        cdao.atualizarCliente(id, cli);

    }


    public Cliente obterCliente(int id){
        return cdao.obterCliente(id);
    }

    public void deletarCliente(int id){
        cdao.deletarCliente(id);
    }
    
}

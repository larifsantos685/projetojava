package com.projetogarcia.projetojava.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //Marca como classe bean para o Spring
public class ClienteDAO {

    
    @Autowired
    JdbcTemplate jdbc; 



    public void inserirCliente(Cliente cli){
        String sql = "INSERT INTO cliente(nome, email, telefone, endereco) VALUES(?,?,?,?)";
        jdbc.update(sql, cli.getNome(), cli.getEmail(),cli.getTelefone(),cli.getEndereco());
    

        //A ideia das interrogações é preencher com o que ta ali escrito na ordem, com os valores na orde,
    }

    //Para fazer a listagem, mostrar os dados
    //Aqui ele vai retornar tipo (id: 1, nome: teste1, cpf:'123')
    //Aqui a gente usa ele pq ele usa o polimorfismo, ele retorna qualquer tipo de dado 
    //Ele retorna uma lista de JSON basicamente 
     //No object ele consegue adaptar tudo que vem, 
    //  uma lista de de para, de string para objeto

    public List<Map<String,Object>> obterTodosClientes(){
        String sql = "Select * from cliente;";
        return jdbc.queryForList(sql);
        //O map é como se fosse um Json
    }

    //Update
    public void atualizarCliente(int id, Cliente cli){
        String sql = "UPDATE cliente SET ";
        sql += "nome = ?, email = ?, telefone = ?, endereco = ? WHERE id = ?";
        jdbc.update(sql, cli.getNome(), cli.getEmail(), cli.getTelefone(), cli.getEndereco(), id);
    }

    public Cliente obterCliente(int id){
        String sql = "Select * from cliente where id = ?";
        return Tool.converterCliente(jdbc.queryForMap(sql,id));
        //query for map = um registro
    }

    public void deletarCliente(int id){
        String sql = "DELETE FROM cliente where id = ?";
        jdbc.update(sql,id);
    }


}

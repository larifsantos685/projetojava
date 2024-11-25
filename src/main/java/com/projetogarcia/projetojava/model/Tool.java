package com.projetogarcia.projetojava.model;

import java.util.Map;

public class Tool {
    //esse e tipo uma classe auxiliar para tranformar o cliente em objeto

    public static Cliente converterCliente(Map<String,Object> registro){
        //Como registro.get retorna object devemos usar o polimorfimos de subtipos(Downcast oara recuperar os tipos originais)
        return new Cliente((Integer) registro.get("id"),(String) registro.get("nome"),
        (String) registro.get("email"),
        (String) registro.get("telefone"),
        (String) registro.get("endereco"));
    }

    //Na listagem ele quer cliente não o MAP ele quer tudo formatado, ele nao quer o JSON, quer o objeto em si
    //o registro é a chave do valor, string object, string object, entendeu? o resgistro é tipo um json do java
    //passando um cliente para o objeto, o java nao sabe diferenciar então diferenciamos
}

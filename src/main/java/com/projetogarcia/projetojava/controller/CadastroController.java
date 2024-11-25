package com.projetogarcia.projetojava.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projetogarcia.projetojava.model.Cliente;
import com.projetogarcia.projetojava.model.ClienteService;
import com.projetogarcia.projetojava.model.Tool;

@Controller
public class CadastroController {

    @Autowired
    ApplicationContext context;
    @GetMapping("/")
    public String principal(){
        return "principal"; 
    }

    
    @GetMapping("/cadastro")
    //essa variavel vai se conectar com a nossa view(visualização) no model
    //o que ta escrito no atributo tem que estar escrito nos dois tanto la  o objeto quanto aqui la ta cliente e aqui cliente
    public String cadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastro";
    }


    @PostMapping("/cadastro")
    //model atribute é o cliente, quando eu digitar no formulario o nome e o email ele vai digitar aqui pra mim na variavel cli, eu consigo agora aplicar o service
    public String sucesso(@ModelAttribute Cliente cli){
        //puxando a classe cliente
        //E concetando com o service
        ClienteService cs = context.getBean(ClienteService.class);
        cs.inserirCliente(cli);
        return "sucesso"; 
    }

    //Vamos fazer um getmapping voamos pegar nossos registro, transformaremos em clientes e é isso

//     

//Get = mostrar na tela
//post - enviar pro banco é post
 
    @GetMapping("/listagemclientes")
    public String listagemclientes(Model model){
        ClienteService cs = context.getBean(ClienteService.class);
        List<Map<String,Object>> lista = cs.obterTodosClientes();
        List<Cliente> listaClientes = new ArrayList<>();
        for(Map<String,Object> registro : lista){
            listaClientes.add(Tool.converterCliente(registro));
        }
        model.addAttribute("clientes", listaClientes);
        return "listagemclientes";

        //List é o pai do array list, list classe abstrata, array list classe concreta, nao pode instaciar classe abstrata
    }

    
    @GetMapping("/atualizarcliente/{id}") 
    public String atualizar(Model model, @PathVariable int id){
        ClienteService cs = context.getBean(ClienteService.class);
        Cliente cli = cs.obterCliente(id);
        model.addAttribute("id", id);
        model.addAttribute("cliente", cli);
        return "atualizarcliente";
    }

    @PostMapping("/atualizarcliente/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Cliente cli){
        ClienteService cs = context.getBean(ClienteService.class);
        cs.atualizarCliente(id, cli);
        return "redirect:/listagemclientes";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id){
        ClienteService cs = context.getBean(ClienteService.class);
        cs.deletarCliente(id);
        return "redirect:/listagemclientes";
    }

    
  


}
    



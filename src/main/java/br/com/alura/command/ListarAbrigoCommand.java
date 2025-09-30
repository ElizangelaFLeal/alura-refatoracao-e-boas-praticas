package br.com.alura.command;

import br.com.alura.client.HttpClientConfiguration;
import br.com.alura.service.AbrigoService;

import java.io.IOException;

public class ListarAbrigoCommand implements Command {

    @Override
    public void execute() {
       try{
           HttpClientConfiguration client = new HttpClientConfiguration();
           AbrigoService abrigoService = new AbrigoService(client);

           abrigoService.listarAbrigo();
       }catch (IOException | InterruptedException e){
           throw new RuntimeException(e);
       }
    }
}

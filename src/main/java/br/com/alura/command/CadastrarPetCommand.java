package br.com.alura.command;

import br.com.alura.client.HttpClientConfiguration;
import br.com.alura.service.PetService;

import java.io.IOException;

public class CadastrarPetCommand implements Command {

    @Override
    public void execute() {
        try{
            HttpClientConfiguration client = new HttpClientConfiguration();
            PetService petService = new PetService(client);

            petService.importarPetsDoAbrigo();
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

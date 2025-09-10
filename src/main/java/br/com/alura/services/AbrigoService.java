package br.com.alura.services;

import br.com.alura.client.HttpClientConfiguration;
import br.com.alura.domain.AbrigoDomain;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AbrigoService {

    private HttpClientConfiguration client;

    public AbrigoService(HttpClientConfiguration client) {
        this.client = client;
    }
    public void listarAbrigo() throws IOException, InterruptedException {
        String uri = "http://localhost:8081/abrigos";
        HttpResponse<String> response = client.dispararRequisicaoGet(uri);
        String responseBody = response.body();

        AbrigoDomain[] abrigos = new ObjectMapper().readValue(responseBody, AbrigoDomain[].class);
        List<AbrigoDomain> abrigoList = Arrays.stream(abrigos).toList();
        System.out.println("Response Body: " + responseBody);

        for (AbrigoDomain abrigo : abrigoList) {
            long id = abrigo.getId();
            String nome = abrigo.getNome();
            System.out.println(id + " - " + nome);
        }
    }
    public void cadastrarAbrigo() throws IOException, InterruptedException {
        System.out.println("Digite o nome do abrigo:");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = new Scanner(System.in).nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = new Scanner(System.in).nextLine();

        AbrigoDomain abrigo = new AbrigoDomain(nome, telefone, email);

        String uri = "http://localhost:8081/abrigos";
        HttpResponse<String> response = client.dispararRequisicaoPost(uri, abrigo);

        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }
}

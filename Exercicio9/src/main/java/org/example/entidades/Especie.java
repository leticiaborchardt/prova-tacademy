package org.example.entidades;

public class Especie {
    private String nome;
    private String planetaOrigem;
    private int nivelPericulosidade;

    public Especie() {
    }

    public Especie(String nome, String planetaOrigem, int nivelPericulosidade) {
        this.nome = nome;
        this.planetaOrigem = planetaOrigem;
        this.nivelPericulosidade = nivelPericulosidade;
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Planeta de origem: " + this.getPlanetaOrigem());
        System.out.println("Nível de Periculosidade: " + this.getNivelPericulosidade());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlanetaOrigem() {
        return planetaOrigem;
    }

    public void setPlanetaOrigem(String planetaOrigem) {
        this.planetaOrigem = planetaOrigem;
    }

    public int getNivelPericulosidade() {
        return nivelPericulosidade;
    }

    public void setNivelPericulosidade(int nivelPericulosidade) {
        this.nivelPericulosidade = nivelPericulosidade;
    }
}

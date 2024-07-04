package org.example.entidades;

import org.example.gerenciadores.GerenciadorAlienigena;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Alienigena {
    private int id;
    private String nome;
    private Especie especie;
    private NivelPericulosidade periculosidade;
    private LocalDateTime dataHoraEntrada;
    private boolean estaEmQuarentena;

    public Alienigena() {
    }

    public Alienigena(Especie especie) {
        this.setEspecie(especie);
        this.setEstaEmQuarentena(false);

        if (especie.getNivelPericulosidade() <= 50) {
            this.setPericulosidade(NivelPericulosidade.BAIXO);
        } else if (especie.getNivelPericulosidade() >= 50 && especie.getNivelPericulosidade() < 100) {
            this.setPericulosidade(NivelPericulosidade.MEDIO);
        } else if (especie.getNivelPericulosidade() >= 100) {
            this.setPericulosidade(NivelPericulosidade.ALTO);
            this.setEstaEmQuarentena(true);
        }
    }

    public Alienigena(int id, String nome, Especie especie, NivelPericulosidade periculosidade, LocalDateTime dataHoraEntrada, boolean estaEmQuarentena) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.periculosidade = periculosidade;
        this.dataHoraEntrada = dataHoraEntrada;
        this.estaEmQuarentena = estaEmQuarentena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        for (Alienigena alienigena : GerenciadorAlienigena.alienigenas) {
            if (alienigena.getId() == id) {
                throw new Exception("Este código já está em uso!");
            }
        }

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public NivelPericulosidade getPericulosidade() {
        return periculosidade;
    }

    public void setPericulosidade(NivelPericulosidade periculosidade) {
        this.periculosidade = periculosidade;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public String getDataHoraEntradaFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return this.getDataHoraEntrada().format(formatter);
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public boolean estaEmQuarentena() {
        return estaEmQuarentena;
    }

    public void setEstaEmQuarentena(boolean estaEmQuarentena) {
        this.estaEmQuarentena = estaEmQuarentena;
    }

    public void mostrarInformacoes() {
        System.out.println("\nNome: " + this.getNome());
        System.out.println("Espécie: " + this.getEspecie().getNome());
        System.out.println("Planeta de origem: " + this.getEspecie().getPlanetaOrigem());
        System.out.println("Nível de Periculosidade: " + this.getPericulosidade().getDescricao());
        System.out.println("Data/Hora de entrada: " + this.getDataHoraEntradaFormatada());
    }
}

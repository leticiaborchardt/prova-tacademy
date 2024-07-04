package org.example.gerenciadores;

import org.example.entidades.Especie;
import org.example.utilitarios.ValidadorInput;

import java.util.ArrayList;

public abstract class GerenciadorEspecie {
    public static ArrayList<Especie> especies = new ArrayList<>();

    public static void adicionarEspecie(Especie especie) {
        especies.add(especie);
    }

    public static String listarEscolha() {
        System.out.println("Escolha uma espécie:");

        String opcoes = "";

        for (int i = 0; i < especies.size(); i++) {
            opcoes = opcoes + "[" + (i + 1) + "] " + especies.get(i).getNome();
        }

        return opcoes;
    }

    public static Especie cadastrarNovaEspecie() {
        Especie especie = new Especie();
        especie.setNome(ValidadorInput.obterString("Digite o nome da espécie:"));
        especie.setPlanetaOrigem(ValidadorInput.obterString("Digite o nome do planeta de origem:"));
        especie.setNivelPericulosidade(ValidadorInput.obterInteiro("Digite o nível de periculosidade desta espécie:"));

        System.out.println("Espécie cadastrada com sucesso.");
        GerenciadorEspecie.adicionarEspecie(especie);

        return especie;
    }

    public static void listarEspecies() {
        System.out.println("-----------------------");
        System.out.println("Espécies cadastradas");
        System.out.println("-----------------------");

        if (especies.isEmpty()) {
            System.out.println("Nenhuma espécie encontrada.");
        } else {
            for (Especie especie : especies) {
                especie.mostrarInformacoes();
            }
        }
    }
}

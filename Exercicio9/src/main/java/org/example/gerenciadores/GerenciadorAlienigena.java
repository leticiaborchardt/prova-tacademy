package org.example.gerenciadores;

import org.example.entidades.Alienigena;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class GerenciadorAlienigena {
    public static ArrayList<Alienigena> alienigenas = new ArrayList<>();

    public static void adicionarAlienigena(Alienigena alienigena) {
        alienigenas.add(alienigena);
    }

    public static void listarAlienigenas() {
        System.out.println("-----------------------");
        System.out.println("Alienígenas cadastrados");
        System.out.println("-----------------------");

        if (alienigenas.isEmpty()) {
            System.out.println("Nenhum alienígena encontrado.");
        } else {
            for (Alienigena alienigena : alienigenas) {
                alienigena.mostrarInformacoes();
            }
        }
    }

    public static void listarRankingPericulosidade() {
        if (alienigenas.isEmpty()) {
            System.out.println("Nenhum alienígena encontrado.");
        } else {
            alienigenas.sort(Comparator.comparingInt(
                    (Alienigena alien) -> alien.getEspecie().getNivelPericulosidade()).reversed()
            );

            for (Alienigena alienigena : alienigenas) {
                System.out.println(alienigena.getNome() + " - Nível de Periculosidade: " + alienigena.getEspecie().getNivelPericulosidade());
            }
        }
    }

    public static void listarAlienigenasEmQuarentena() {
        System.out.println("-------------------------");
        System.out.println("Alienígenas em quarentena");
        System.out.println("-------------------------");

        ArrayList<Alienigena> aliensEmQuarentena = new ArrayList<>();

        if (alienigenas.isEmpty()) {
            System.out.println("Nenhum alienígena encontrado.");
        } else {
            for (Alienigena alienigena : alienigenas) {
                if (alienigena.estaEmQuarentena()) {
                    aliensEmQuarentena.add(alienigena);
                }
            }

            if (aliensEmQuarentena.isEmpty()) {
                System.out.println("Nenhum alienígena está em quarentena.");
            } else {
                for (Alienigena alienigena : aliensEmQuarentena) {
                    alienigena.mostrarInformacoes();
                }
            }
        }
    }

    public static void listarEspecieEspecifica(String nomeEspecie) {
        ArrayList<Alienigena> resultado = new ArrayList<>();

        for (Alienigena alienigena : alienigenas) {
            if (alienigena.getEspecie().getNome().equalsIgnoreCase(nomeEspecie)) {
                resultado.add(alienigena);
            }
        }

        if (resultado.isEmpty()) {
            System.out.println("Nenhum alienígena encontrado.");
        } else {
            System.out.println("Alienígenas da espécie " + nomeEspecie);
            for (Alienigena alienigena : resultado) {
                alienigena.mostrarInformacoes();
            }
        }
    }

    public static void listarEntradasUltimosSeisMeses() {
        LocalDateTime ultimosSeisMeses = LocalDateTime.now().minusMonths(6);
        ArrayList<Alienigena> resultado = new ArrayList<>();

        for (Alienigena alienigena : alienigenas) {
            if (alienigena.getDataHoraEntrada().isAfter(ultimosSeisMeses)) {
                resultado.add(alienigena);
            }
        }

        if (resultado.isEmpty()) {
            System.out.println("Nenhum alienígena encontrado.");
        } else {
            System.out.println("Alienígenas com entrada nos últimos 6 meses");
            for (Alienigena alienigena : resultado) {
                alienigena.mostrarInformacoes();
            }
        }
    }
}

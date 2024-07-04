package org.example.relatorios;

import org.example.entidades.Alienigena;
import org.example.gerenciadores.GerenciadorAlienigena;

public class RelatorioEntradas {
    public static void imprimirRelatorio() {
        if (GerenciadorAlienigena.alienigenas.isEmpty()) {
            System.out.println("Nenhum alienígena encontrado para gerar o relatório.");
        } else {
            System.out.println("---------------------");
            System.out.println("Relatório de entradas");
            System.out.println("---------------------");

            for (Alienigena alienigena : GerenciadorAlienigena.alienigenas) {
                alienigena.mostrarInformacoes();
                System.out.println("Status de quarentena: " + (alienigena.estaEmQuarentena() ? "Em quarentena" : "Fora de quarentena"));
            }
        }
    }
}

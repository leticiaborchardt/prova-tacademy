package org.example;

import org.example.gerenciadores.GerenciadorAlienigena;
import org.example.gerenciadores.GerenciadorEspecie;
import org.example.menus.RegistroAlienigena;
import org.example.relatorios.RelatorioEntradas;
import org.example.utilitarios.ValidadorInput;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----------------------------------------------");
            System.out.println("Sistema de Controle de Entrada de Alienígenas!");
            System.out.println("----------------------------------------------\n");

            switch (ValidadorInput.obterInteiro(obterOpcoes())) {
                case 0:
                    return;
                case 1:
                    RegistroAlienigena.registrar();
                    break;
                case 2:
                    GerenciadorAlienigena.listarAlienigenas();
                    break;
                case 3:
                    GerenciadorEspecie.cadastrarNovaEspecie();
                    break;
                case 4:
                    GerenciadorEspecie.listarEspecies();
                    break;
                case 5:
                    RelatorioEntradas.imprimirRelatorio();
                    break;
                case 6:
                    GerenciadorAlienigena.listarRankingPericulosidade();
                    break;
                case 7:
                    GerenciadorAlienigena.listarAlienigenasEmQuarentena();
                    break;
                case 8:
                    GerenciadorAlienigena.listarEspecieEspecifica(ValidadorInput.obterString("Digite o nome da espécie:"));
                    break;
                case 9:
                    GerenciadorAlienigena.listarEntradasUltimosSeisMeses();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static String obterOpcoes() {
        return "Informe a opção desejada:" +
                "\n[1] Cadastrar alienígena" +
                "\n[2] Visualizar Alienígenas Cadastrados" +
                "\n[3] Cadastrar espécie" +
                "\n[4] Visualizar Espécies Cadastradas" +
                "\n[5] Imprimir Relatório de Entradas" +
                "\n[6] Ranking de Periculosidade" +
                "\n[7] Ver alienígenas em quarentena" +
                "\n[8] Procurar por espécie específica" +
                "\n[9] Listar alienígenas que entraram nos últimos 6 meses" +
                "\n[0] Sair";
    }
}
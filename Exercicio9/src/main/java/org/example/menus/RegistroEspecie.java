package org.example.menus;

import org.example.entidades.Especie;
import org.example.gerenciadores.GerenciadorEspecie;
import org.example.utilitarios.ValidadorInput;

public final class RegistroEspecie {
    public static Especie obterEspecie() {
        while (true) {
            switch (ValidadorInput.obterInteiro(obterOpcoes())) {
                case 1:
                    return GerenciadorEspecie.cadastrarNovaEspecie();
                case 2:
                    if (GerenciadorEspecie.especies.isEmpty()) {
                        System.out.println("Nenhuma espécie cadastrada ainda!");
                        break;
                    }

                    return GerenciadorEspecie.especies.get(
                            ValidadorInput.obterInteiro(GerenciadorEspecie.listarEscolha()) - 1
                    );
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static String obterOpcoes() {
        return "Escolha uma opção:" +
                "\n[1] Cadastrar nova espécie" +
                "\n[2] Escolher espécie existente";
    }
}

package org.example.menus;

import org.example.entidades.Alienigena;
import org.example.entidades.Especie;
import org.example.gerenciadores.GerenciadorAlienigena;
import org.example.utilitarios.ValidadorInput;

public final class RegistroAlienigena {
    public static void registrar() {
        System.out.println("Cadastrar novo alienígena");

        Especie especie = RegistroEspecie.obterEspecie();

        Alienigena alienigena = new Alienigena(especie);

        while (true) {
            try {
                alienigena.setId(ValidadorInput.obterInteiro("Digite o código do alienígena:"));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        alienigena.setNome(ValidadorInput.obterString("Digite o nome do alienígena:"));
        alienigena.setDataHoraEntrada(ValidadorInput.obterDataHora("Digite a data e hora de entrada no formato dd/MM/yyyy HH:mm:"));

        System.out.println("Alienígena cadastrado!");

        if (alienigena.estaEmQuarentena()) {
            System.out.println("O alienígena foi colocado em quarentena devido ao seu nível de periculosidade!");
        }

        GerenciadorAlienigena.adicionarAlienigena(alienigena);
    }
}

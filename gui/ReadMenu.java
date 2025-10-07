package gui;

import api.Gateway;
import system.Number;

import javax.management.InvalidAttributeValueException;
import javax.swing.*;

public class ReadMenu {

    public static void show() {

        String[] options = {"NOME", "NÚMERO", "CANCELAR"};

        String selection = options[JOptionPane.showOptionDialog(
                null,
                "Buscar por:",
                "SELEÇÃO",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[options.length - 1]
        )];

        if (selection.equals("NOME")){

            String name = JOptionPane.showInputDialog(
                    null,
                    "Nome do contato:",
                    "BUSCAR CONTATO",
                    JOptionPane.INFORMATION_MESSAGE
            );

            if (name == null) { return; }

            String[] queryResult = Gateway.getContact(name);

            if (queryResult == null){
                JOptionPane.showMessageDialog(
                        null,
                        "Revise seus dados.",
                        "CONTATO NÃO ENCONTRADO",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            else {
                JOptionPane.showMessageDialog(
                        null,
                        "Nome: " + queryResult[0] + "\nNúmero: " + queryResult[1],
                        "CONTATO ENCONTRADO",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }


        }

        if (selection.equals("NÚMERO")){

            String numberStr = JOptionPane.showInputDialog(
                    null,
                    "DDD + Número do contato:\n(PS: APENAS CARACTERES NUMÉRICOS)",
                    "BUSCAR CONTATO",
                    JOptionPane.INFORMATION_MESSAGE
            );

            if (numberStr == null) { return; }

            try {
                Validate.number(numberStr);
            }
            catch (InvalidAttributeValueException e){
                JOptionPane.showMessageDialog(
                        null,
                        "ENTRADA INVÁLIDA: " + e.getMessage(),
                        "ERRO",
                        JOptionPane.ERROR_MESSAGE
                ); return;
            }

            String[] queryResult = Gateway.getContact(new Number(numberStr));

            if (queryResult == null){
                JOptionPane.showMessageDialog(
                        null,
                        "Revise seus dados.",
                        "CONTATO NÃO ENCONTRADO",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            else {
                JOptionPane.showMessageDialog(
                        null,
                        "Nome: " + queryResult[0] + "\nNúmero: " + queryResult[1],
                        "CONTATO ENCONTRADO",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
}

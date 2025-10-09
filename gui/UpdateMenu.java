package gui;

import api.Gateway;

import javax.management.InvalidAttributeValueException;
import javax.swing.JOptionPane;

public class UpdateMenu {

    //TODO: PROGRAMAR JANELAS DE ERRO EM CASO DE NULOS

    public static void show(){

        if (!(Gateway.GET() > 0)){
            JOptionPane.showMessageDialog(
                    null,
                    "Agenda vazia",
                    "ATENÇÃO",
                    JOptionPane.WARNING_MESSAGE
            ); return;
        }

        String[] options = {"NOME", "NÚMERO", "CANCELAR"};

        String selection = options[JOptionPane.showOptionDialog(
                null,
                "Encontrar contato por:",
                "ATUALIZAR CONTATO",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[options.length - 1]
        )];

        String[] queryResult;

        if (selection.equals("NOME")){

            String name = JOptionPane.showInputDialog(
                    null,
                    "Nome atual do contato:",
                    "ATUALIZAR CONTATO",
                    JOptionPane.INFORMATION_MESSAGE
            );

            if (name == null) { return; }

            queryResult = Gateway.GET(name, null);

            if (queryResult == null){
                JOptionPane.showMessageDialog(
                        null,
                        "Revise seus dados.",
                        "CONTATO NÃO ENCONTRADO",
                        JOptionPane.INFORMATION_MESSAGE
                ); return;
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
        else if (selection.equals("NÚMERO")){

            String number = JOptionPane.showInputDialog(
                    null,
                    "DDD + Número do contato:\n(PS: APENAS CARACTERES NUMÉRICOS)",
                    "ATUALIZAR CONTATO",
                    JOptionPane.INFORMATION_MESSAGE
            );

            if (number == null) { return; }

            try {
                Validate.number(number);
            }
            catch (InvalidAttributeValueException e){
                JOptionPane.showMessageDialog(
                        null,
                        "ENTRADA INVÁLIDA: " + e.getMessage(),
                        "ERRO",
                        JOptionPane.ERROR_MESSAGE
                ); return;
            }

            queryResult = Gateway.GET(null, number);

            if (queryResult == null){
                JOptionPane.showMessageDialog(
                        null,
                        "Revise seus dados.",
                        "CONTATO NÃO ENCONTRADO",
                        JOptionPane.INFORMATION_MESSAGE
                ); return;
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
        else{return;}

        options = new String[] {"NOME", "NÚMERO", "NOME E NÚMERO", "CANCELAR"};

        selection = options[JOptionPane.showOptionDialog(
                null,
                "NOME: " + queryResult[0] + "\nNÚMERO: "+ queryResult[1] +"\n\nModificar:",
                "ATUALIZAR CONTATO",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[options.length - 1]
        )];

        String newName, newNumber;

        if (selection .equals ("NOME")) {
            newName = JOptionPane.showInputDialog(
                    null,
                    "Novo nome:",
                    "ATUALIZAR CONTATO",
                    JOptionPane.INFORMATION_MESSAGE
            );
            try {
                Gateway.PATCH(queryResult, newName, null);
            } catch (InvalidAttributeValueException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "ENTRADA INVÁLIDA: " + e.getMessage(),
                        "ERRO",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }
        else if (selection .equals ("NÚMERO")) {
            newNumber = JOptionPane.showInputDialog(
                    null,
                    "Novo número:",
                    "ATUALIZAR CONTATO",
                    JOptionPane.INFORMATION_MESSAGE
            );
            try {
                Gateway.PATCH(queryResult, null, newNumber);
            } catch (InvalidAttributeValueException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "ENTRADA INVÁLIDA: " + e.getMessage(),
                        "ERRO",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }
        else if (selection .equals ("NOME E NÚMERO")) {
            newName = JOptionPane.showInputDialog(
                    null,
                    "Novo nome:",
                    "ATUALIZAR CONTATO",
                    JOptionPane.INFORMATION_MESSAGE
            );
            newNumber = JOptionPane.showInputDialog(
                    null,
                    "Novo número:",
                    "ATUALIZAR CONTATO",
                    JOptionPane.INFORMATION_MESSAGE
            );
            try {
                Gateway.PUT(queryResult, newName, newNumber);
            } catch (InvalidAttributeValueException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "ENTRADA INVÁLIDA: " + e.getMessage(),
                        "ERRO",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }
        else { return; }

        JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
    }

}


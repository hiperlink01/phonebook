package gui;

import api.Gateway;

import javax.management.InvalidAttributeValueException;
import javax.swing.JOptionPane;

public class CreateMenu {

    public static void show(){

        String name = JOptionPane.showInputDialog(
                null,
                "Nome do contato:",
                "CRIAR CONTATO",
                JOptionPane.INFORMATION_MESSAGE
        );

        if (name == null) { return; }

        String numberStr = JOptionPane.showInputDialog(
                null,
                "DDD + Número do contato:\n(PS: APENAS CARACTERES NUMÉRICOS)",
                "CRIAR CONTATO",
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

        String confirmData = "Nome: " + name + "\nNumero: " + numberStr;

        String[] options = {"YES", "NO"};

        String confirm = options[JOptionPane.showOptionDialog(
                null,
                confirmData,
                "CONFIRMA?",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[options.length-1]
        )];

        if (confirm.equals("YES")){
            String[] processedContactStrings = {name, numberStr};
            Gateway.postNewContact(processedContactStrings);
        }
    }
}
package gui;

import javax.swing.JOptionPane;

public class OptionsMenu {

    public static Selection show() {

        Selection[] options = {
                Selection.CREATE,
                Selection.READ,
                Selection.UPDATE,
                Selection.DELETE,
                Selection.EXIT
        };

        Selection selectedOption = Selection.values()[JOptionPane.showOptionDialog(
                null,
                "Escolha a operação:",
                "SELEÇÃO",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[options.length - 1]
        )];

        switch (selectedOption){

            case CREATE:
                CreateMenu.show();
                break;

            case READ:
                ReadMenu.show();
                break;

            case UPDATE:
                UpdateMenu.show();
                break;

            case DELETE:
                DeleteMenu.show();
                break;
        }

        return selectedOption;
    }



}

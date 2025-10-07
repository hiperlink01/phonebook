import javax.swing.JOptionPane;

import gui.CreateMenu;
import gui.Selection;
import gui.OptionsMenu;
import api.Gateway;

public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Bem-vindo à sua Agenda!");

        while (OptionsMenu.show() != Selection.EXIT);

    }
}
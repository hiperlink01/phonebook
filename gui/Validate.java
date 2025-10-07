package gui;

import javax.management.InvalidAttributeValueException;

public class Validate {
    static void number(String numberStr) throws InvalidAttributeValueException {

        String allowed = "0123456789";

        for (int i = 0; i < numberStr.length(); i++){
            if (allowed.indexOf(numberStr.charAt(i)) == -1){ throw new InvalidAttributeValueException(
                    "Entrada deve conter somente números"
            );
            }
        }

        if (numberStr.length() != 11) { throw new InvalidAttributeValueException(
                "Tamanho do número inválido"
        );}
    }
}

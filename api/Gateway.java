package api;

import system.PhoneBook;

import javax.management.InvalidAttributeValueException;

public class Gateway {

    private static final PhoneBook generalPhoneBook = new PhoneBook();

    public static void POST(String[] newContactData){

        String name = newContactData[0];
        String number = newContactData[1];

        generalPhoneBook.addNewContact(name, number);

    }

    public static String[] GET(String name, String number) {
        return generalPhoneBook.getContactData(name, number);
    }

    public static void PUT(String[] currentContactData, String newName, String newNumber) throws InvalidAttributeValueException {
        generalPhoneBook.setContact(currentContactData, newName, newNumber);
    }

    public static void PATCH(String[] currentContactData, String newName, String newNumber) throws InvalidAttributeValueException {

        if (newName != null && newNumber != null){ throw new InvalidAttributeValueException(
                "Somente um atributo pode ser modificado."
        );}

        if (newName != null) {
            generalPhoneBook.setContact(currentContactData, newName, null);
        }
        else if (newNumber != null){
            generalPhoneBook.setContact(currentContactData, null, newNumber);
        }
    }

    public static void DELETE(String[] currentContactData) throws InvalidAttributeValueException {
        String name = currentContactData[0];
        String number = currentContactData[1];

        generalPhoneBook.deleteContact(name, number);
    }


}

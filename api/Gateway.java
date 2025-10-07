package api;

import system.Contact;
import system.Number;
import system.PhoneBook;

public class Gateway {

    private static final PhoneBook generalPhoneBook = new PhoneBook();

    public static void postNewContact(String[] processedContactStrings){

        String name = processedContactStrings[0];
        Number number = new Number(processedContactStrings[1]);

        generalPhoneBook.addNewContact(name, number);

    }

    public static String[] getContact(Number number) {
        return generalPhoneBook.getContact(number);
    }
    public static String[] getContact(String name) {
        return generalPhoneBook.getContact(name);
    }


}

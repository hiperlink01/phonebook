package system;

import system.Number;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;

public class PhoneBook {

    private ArrayList<Contact> contacts;

    public PhoneBook(){
        this.contacts = new ArrayList<Contact>();
    }

    //-----------GETTERS-----------

    public String[] getContact(Number number) {
        for (Contact contact : this.contacts) {
            if (contact.getNumber().n .equals (number.n)) {
                return new String[] {contact.getName(), contact.getNumber().n};
            }
        }
        return null;
    }
    public String[] getContact(String name) {
        for (Contact contact : this.contacts) {
            if (contact.getName() .equals (name)) {
                return new String[] {contact.getName(), contact.getNumber().n};
            }
        }
        return null;
    }

    private Contact _getContact(Number number) {
        for (Contact contact : this.contacts) {
            if (contact.getNumber().n .equals (number.n)) {
                return contact;
            }
        }
        return null;
    }
    private Contact _getContact(String name) {
        for (Contact contact : this.contacts) {
            if (contact.getName() .equals (name)) {
                return contact;
            }
        }
        return null;
    }

    public int getSize(){
        return this.contacts.size();
    }

    //-----------SETTERS-----------

    public void updateContact(Contact toUpdate, String newName) throws InvalidAttributeValueException{
        if (toUpdate == null){ throw new InvalidAttributeValueException(
                "Contato não existe."
        );}
        toUpdate.setName(newName);
    }
    public void updateContact(Contact toUpdate, Number newNumber) throws InvalidAttributeValueException{
        if (toUpdate == null){ throw new InvalidAttributeValueException(
                "Contato não existe."
        );}
        toUpdate.setNumber(newNumber);
    }
    public void updateContact(Contact toUpdate, String newName, Number newNumber) throws InvalidAttributeValueException{
        if (toUpdate == null){ throw new InvalidAttributeValueException(
                "Contato não existe."
        );}
        toUpdate.setName(newName);
        toUpdate.setNumber(newNumber);
    }

    //-----------OPERATIONS-----------

    public void addNewContact(String name, Number number) {
        this.contacts.addLast(new Contact(name, number));
    }

}

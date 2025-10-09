package system;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;

public class PhoneBook {

    private ArrayList<Contact> contacts;

    public PhoneBook(){
        this.contacts = new ArrayList<Contact>();
    }

    //-----------GETTERS-----------

    public String[] getContactData(String name, String number) {
        Contact fetchedContact = getContact(name, number);
        if (fetchedContact != null){
            return new String[] {fetchedContact.getName(), fetchedContact.getNumber()};
        }
        else { return null; }
    }

    private Contact getContact(String name, String number) {
        if (number != null){
            for (Contact contact : this.contacts) {
                if (contact.getNumber() .equals (number)) {
                    return contact;
                }
            }
        }
        else if (name != null){
            for (Contact contact : this.contacts) {
                if (contact.getName() .equals (name)) {
                    return contact;
                }
            }
        }
        return null;
    }

    public int getSize(){
        return this.contacts.size();
    }

    //-----------SETTERS-----------

    public void setContact(String[] contactData, String newName, String newNumber) throws InvalidAttributeValueException{

        if (contactData!=null) {

            Contact fetchedContact = getContact(contactData[0], contactData[1]);

            if (fetchedContact == null){ throw new InvalidAttributeValueException(
                    "Contato não existe."
            );}

            if (newName!=null) {
                fetchedContact.setName(newName);
            }
            if (newNumber!=null) {
                fetchedContact.setNumber(newNumber);
            }
        }
        else { throw new InvalidAttributeValueException(
                    "Dados inválidos: Não é possível localizar o contato."
        );}
    }

    //-----------OPERATIONS-----------

    public void addNewContact(String name, String number) {
        this.contacts.addLast(new Contact(name, number));
    }

    public void deleteContact(String name, String number) throws InvalidAttributeValueException {

        Contact fetchedContact = getContact(name, number);

        if (fetchedContact != null){
            this.contacts.remove(fetchedContact);
        }
        else { throw new InvalidAttributeValueException(
                "Contato não existe"
        );}
    }
}

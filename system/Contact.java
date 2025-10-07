package system;

import system.Number;

public class Contact {

    private String name;
    private Number number;

    public Contact(String name, Number number){
        this.name = name;
        this.number = number;
    }

    public String getName(){
        return name;
    }
    public Number getNumber() {
        return number;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setNumber(Number number) {
        this.number = number;
    }

}

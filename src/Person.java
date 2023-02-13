import java.util.Scanner;

/**
 * Abstract class Person - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Person
{
    private String name, password;
    public Person(String string1, String string2){
        this.name = string1;
        this.password = string2;
    }

    public String getName(){
        return this.name;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public boolean CompareTo(Person person){
        if (person.getName().equals(this.getName()) && person.getPassword().equals(this.getPassword())){
            return true;
        } else {
            return false;
        }
    }
}

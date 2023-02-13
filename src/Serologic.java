import java.time.LocalDate;
import java.util.Random;

/**
 * Write a description of class Serologic here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Serologic extends Test
{
    private int result;
    public Serologic(Patient patient, LocalDate date)
    {
        super(patient, date);
        this.result= 0;
    }

    public int getResult(){
        return this.result;
    }
    
    public void setResult(){
        Random rand = new Random();
        int randomNum = rand.nextInt(11);
        this.result = randomNum;
        System.out.println("El resultado fue " + randomNum);
    }
}
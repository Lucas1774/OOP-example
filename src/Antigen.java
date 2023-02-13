import java.time.LocalDate;
import java.util.Random;
import java.time.temporal.ChronoUnit;

/**
 * Write a description of class Antigen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Antigen extends Test
{
    private boolean result;
    public Antigen(Patient patient, LocalDate date)
    {
        super(patient, date);
        this.result = false;
    }
    
    public boolean isConfining (){
        boolean b = false;
        if ((int) ChronoUnit.DAYS.between(this.getDate(), clinica.CURRENTDATE) <= 10 && this.getResult()){
            b=true;
        }
        return b;
     }
     
    public boolean getResult(){
        return this.result;
    }
    
    public void setResult(){
        Random rand = new Random();
        int randomNum = rand.nextInt(2);
        if (randomNum == 1){
            this.result = true;
        }
        System.out.println("El resultado fue " + randomNum);
    }
    
  

}
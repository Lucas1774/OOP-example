import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Write a description of class Moderna here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Moderna extends Vaccine
{
    private LocalDate dateofsecond;
    public Moderna(Patient patient, LocalDate date)
    {
        super(patient, date);
        this.dateofsecond = LocalDate.of(1, 1, 1);
    }
    
    public LocalDate getDateofSecond(){
        return this.dateofsecond;
    }
    
    public void setDateofSecond(){
        Scanner inp = new Scanner(System.in);
        boolean success = false;
        int day1, month1, year1;
        LocalDate date1;
        while (!success){
            System.out.println("Inserte la fecha de la segunda dosis. En orden día mes y año");
            day1 = inp.nextInt();
            inp.nextLine();
            month1 = inp.nextInt();
            inp.nextLine();
            year1 = inp.nextInt();
            inp.nextLine();
            date1 = LocalDate.of(day1,month1,year1);
            if ((int) ChronoUnit.DAYS.between(this.getDate(), date1) <= 21){
                System.out.println("Esta fecha es demasiado temprana para la segunda dosis");
            } else {
                this.dateofsecond = date1;
                success = true;
                System.out.println("Vacunación guardada con éxito");
            }   
        }
        
    }
}

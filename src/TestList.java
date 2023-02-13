import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

/**
 * Abstract class Vaccine - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class TestList
{
    private ArrayList <Fast> antigenfastlist = new ArrayList <Fast>();
    private ArrayList <Classic> antigenclassiclist = new ArrayList <Classic>(); 
    private ArrayList <Pcr> pcrlist = new ArrayList <Pcr>();
    private ArrayList <Serologic> serologiclist = new ArrayList <Serologic>();

    public TestList(){
       
    }
    
    public ArrayList <Fast> getAntigenFastList(){
        return this.antigenfastlist;
    }
    
    public ArrayList <Classic> getAntigenClassicList(){
        return this.antigenclassiclist;
    }
    
    public ArrayList <Pcr> getPcrList(){
        return this.pcrlist;
    }
    
    public ArrayList <Serologic> getSerologicList(){
        return this.serologiclist;
    }
    
    public int size(){
        return this.getAntigenFastList().size() + this.getSerologicList().size() + this.getAntigenClassicList().size() +this.getPcrList().size();
    }
    //@ Pre no está confinado
    public void addFast (Fast fast){
        this.getAntigenFastList().add(fast);
        System.out.println("Test guardado. Se deben asignar especialistas");
    }
    
    public void addClassic (Classic classic){
        this.getAntigenClassicList().add(classic);
        System.out.println("Test guardado. Se deben asignar especialistas");
    }
    //estas funciones cogen primero la fecha del último test. De no tener asignado ninguno devuelve 1 de enero del año 1, lo que no es limitante.
    public void addPcr (Pcr pcr){
        LocalDate date = LocalDate.of(1, 1, 1);
        for (int i = 0; i< this. getPcrList().size(); i++){
            if (this.getPcrList().get(i).getPatient().CompareTo(pcr.getPatient()) && this.getPcrList().get(i).getDate().isAfter(date)){
                date = this.getPcrList().get(i).getDate();
            }
        }
        if( (int )ChronoUnit.DAYS.between(date , pcr.getDate()) <=15){
            System.out.println("Este paciente no puede realizar un test de este tipo este día");
        } else{
            this.getPcrList().add(pcr);
            System.out.println("Test guardado. Se deben asignar especialistas");
        }
    }
    
    public void addSerologic (Serologic serologic){
        LocalDate date = LocalDate.of(1, 1, 1);
        for (int i = 0; i< this. getSerologicList().size(); i++){
            if (this.getSerologicList().get(i).getPatient().CompareTo(serologic.getPatient()) && this.getPcrList().get(i).getDate().isAfter(date)){
                date = this.getSerologicList().get(i).getDate();
            }
        }
        if( (int )ChronoUnit.DAYS.between(date , serologic.getDate()) <=60){
            System.out.println("Este paciente no puede realizar un test de este tipo este día");
        } else{
            this.getSerologicList().add(serologic);
            System.out.println("Test guardado. Se deben asignar especialistas");
        }
    }
}
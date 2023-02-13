import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

/**
 * Write a description of class LabTech here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LabTech extends Person
{
    
    public LabTech(String string1, String string2){
        super(string1, string2);
    }

    public boolean isFree (TestList testlist, LocalDate date){//se colocan todos los tests del enfermero en una lista, se separan los que están a 7 días o menos de la fecha dada. Se tiene en cuenta cuántos son
        ArrayList <LocalDate> testdatelist = new ArrayList <LocalDate>();
        boolean b = true;
        for (int i=0; i < testlist.getAntigenFastList().size(); i++){
            if(testlist.getAntigenFastList().get(i).getLabTech().CompareTo(this)){
                testdatelist.add(testdatelist.size(), testlist.getAntigenFastList().get(i).getDate());
            }
        }
        
        for (int i=0; i < testlist.getAntigenClassicList().size(); i++){
            if(testlist.getAntigenClassicList().get(i).getLabTech().CompareTo(this)){
                testdatelist.add(testdatelist.size(), testlist.getAntigenClassicList().get(i).getDate());
                }
        }
        
        for (int i=0; i < testlist.getPcrList().size(); i++){
            if(testlist.getPcrList().get(i).getLabTech().CompareTo(this)){
                testdatelist.add(testdatelist.size(), testlist.getPcrList().get(i).getDate());
            }
        }
        
        if(testdatelist.size()>=4){
            if ((int) ChronoUnit.DAYS.between((testdatelist.get(testdatelist.size()-5)), date) <=7){
                b = false;
            }
        }
        return b;
    }
}

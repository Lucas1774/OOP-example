import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Write a description of class Patient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Patient extends Person
{
    private int age;
    public Patient(String string1, String string2, int a){
        super(string1, string2);
        this.age= a;
    }
    
    public int getAge(){
        return this.age;
    }

    public boolean isConfined (TestList testlist){//busca tests confining del paciente en la lista de tests, con que uno sea confining el paciente está confinado
         boolean b = false;
        for (int i=0; i < testlist.getAntigenFastList().size(); i++){
            if(testlist.getAntigenFastList().get(i).getPatient().CompareTo(this)){
                if ( testlist.getAntigenFastList().get (i).isConfining()){
                    b = true;
                }
            }
        }
        
        for (int i=0; i < testlist.getAntigenClassicList().size(); i++){
            if(testlist.getAntigenClassicList().get(i).getPatient().CompareTo(this)){
                if ( testlist.getAntigenClassicList().get (i).isConfining()){
                    b = true;
                }
            }
        }
        
        for (int i=0; i < testlist.getPcrList().size(); i++){
            if(testlist.getPcrList().get(i).getPatient().CompareTo(this)){
                if ( testlist.getPcrList().get (i).isConfining()){
                    b = true;
                }
            }
        }
        return b;
    }
    //@Pre isConfined
    public LocalDate getDateofConfinment (TestList testlist){
        //no puede haber más de un test confinante así que es la misma función que la anterior pero devolviendo la fecha
        LocalDate date= LocalDate.of(1,1,1);
        for (int i=0; i < testlist.getAntigenFastList().size(); i++){
            if(testlist.getAntigenFastList().get(i).getPatient().CompareTo(this)){
                if ( testlist.getAntigenFastList().get (i).isConfining()){
                    date = testlist.getAntigenFastList().get (i).getDate();
                }
            }
        }
        
        for (int i=0; i < testlist.getAntigenClassicList().size(); i++){
            if(testlist.getAntigenClassicList().get(i).getPatient().CompareTo(this)){
                if ( testlist.getAntigenClassicList().get (i).isConfining()){
                    date = testlist.getAntigenClassicList().get (i).getDate();
                }
            }
        }
        
        for (int i=0; i < testlist.getPcrList().size(); i++){
            if(testlist.getPcrList().get(i).getPatient().CompareTo(this)){
                if ( testlist.getPcrList().get (i).isConfining()){
                    date = testlist.getPcrList().get (i).getDate();
                }
            }
        }
        return date;
    }
     //@Pre isConfined
    public  int getDaysConfined(TestList testlist){
        return (int) ChronoUnit.DAYS.between(this.getDateofConfinment(testlist), clinica.CURRENTDATE);
        }
        
    public boolean needsTest(TestList testlist){
        boolean b = false;
        if (this.getDaysConfined(testlist) >0 && this.getDaysConfined(testlist) <20){
            b=true;
        }
        return b;
    }
    
    public boolean isVaccined(VaccineList vaccinelist){//comprueba si el paciente tiene asignada una vacuna, no compara la fecha de la cita con la fecha actual
        boolean b = false;
        for (int i=0; i < vaccinelist.getModernaList().size(); i++){
            if(vaccinelist.getModernaList().get(i).getPatient().CompareTo(this)){
                b = true;
            }
        }
        
        for (int i=0; i < vaccinelist.getPfizerList().size(); i++){
            if(vaccinelist.getPfizerList().get(i).getPatient() .CompareTo(this)){
                b = true;
            }
        }
        
        for (int i=0; i < vaccinelist.getJhonsonList().size(); i++){
            if(vaccinelist.getJhonsonList().get(i).getPatient().CompareTo(this)){
                b = true;
            }
        }
        return b;
    }
}

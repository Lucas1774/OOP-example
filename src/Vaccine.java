import java.time.LocalDate;

/**
 * Abstract class Vaccine - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Vaccine
{
    private LocalDate date;
    private Patient patient;
    private Nurse nurse;

    public Vaccine(Patient patient, LocalDate date){
        Nurse nurse = new Nurse("Unassigned", "Unassigned");
        this.nurse = nurse;
        this.patient = patient;
        this.date =date;
    }
    
    public LocalDate getDate(){
        return this.date;
    }
    
    public Patient getPatient(){
        return this.patient;
    }
    
    public Nurse getNurse(){
        return this.nurse;
    }
    
    public void setNurse(Nurse nurse){
        this.nurse=nurse;
    }
}


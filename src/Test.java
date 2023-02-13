import java.time.LocalDate;

/**
 * Abstract class Test - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Test
{
    private LocalDate date;
    private Patient patient;
    private Nurse nurse;
    private LabTech labtech;
    
    public Test(Patient patient, LocalDate date)
    {
        Nurse nurse = new Nurse("Unassigned", "Unassigned");
        this.nurse = nurse;
        LabTech labtech = new LabTech("Unassigned", "Unassigned");
        this.labtech = labtech;
        this.date = date;
        this.patient = patient;
     }

    public LocalDate getDate(){
        return this.date;
    }
    
    public Patient getPatient(){
        return this.patient;
    }
    
    public LabTech getLabTech(){
        return this.labtech;
    }
    
    public Nurse getNurse(){
        return this.nurse;
    }
    
    public void setLabTech(LabTech labtech, TestList testlist){
        if (labtech.isFree(testlist, this.getDate())){
            this.labtech=labtech;
            System.out.println("Técnico guardado");
        } else {
            System.out.println("Este técnico no está disponible para este test. El técnico no se ha guardado");
        }
    }
    
    public void setNurse(Nurse nurse, TestList testlist){
        if (labtech.isFree(testlist, this.getDate())){
            this.nurse=nurse;
            System.out.println("Enfermero guardado");
        } else {
            System.out.println("Este enfermero no está disponible para este test. El enfermero no se ha guardado");
        }
    }
}

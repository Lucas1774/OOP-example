import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Write a description of class VaccineList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VaccineList
{
    private ArrayList <Moderna> modernalist;
    private ArrayList <Pfizer> pfizerlist;
    private ArrayList <Jhonson> jhonsonlist;

    public VaccineList()
    {
        this.modernalist = new ArrayList <Moderna>();
        this.pfizerlist = new ArrayList <Pfizer>();
        this.jhonsonlist = new ArrayList <Jhonson>();
    }

    public ArrayList<Moderna> getModernaList(){
        return this.modernalist;
    }
    
    public ArrayList<Pfizer> getPfizerList(){
        return this.pfizerlist;
    }
    
    public ArrayList<Jhonson> getJhonsonList(){
        return this.jhonsonlist;
    }
    
    public int size(){
        return this.modernalist.size()+this.pfizerlist.size()+this.jhonsonlist.size();
    }
    
    public LocalDate getDateofLastElder(){ // Esta función devuelve la fecha del último anciano con vacunación asignada. De no existir, devuelve 1 de enero del año 1, lo cual no es limitante
        LocalDate date = LocalDate.of(1, 1, 1);
        for (int i=0; i<this.getModernaList().size(); i++){
            if (this.getModernaList().get(i).getPatient().getAge() >=65 && this.getModernaList().get(i).getDate().isAfter(date )){
                date= this.getModernaList().get(i).getDate();
            }
        }
        
        for (int i=0; i<this.getPfizerList().size(); i++){
            if (this.getPfizerList().get(i).getPatient().getAge() >=65 && this.getPfizerList().get(i).getDate().isAfter(date )){
                date= this.getPfizerList().get(i).getDate();
            }
        }
        
        for (int i=0; i<this.getJhonsonList().size(); i++){
            if (this.getJhonsonList().get(i).getPatient().getAge() >=65 && this.getJhonsonList().get(i).getDate().isAfter(date )){
                date= this.getJhonsonList().get(i).getDate();
            }
        }
        return date;
    }
    //estas funciones comprueban primero que todos los ancianos tengan fecha de vacunación, luego comprueban que la fecha de la vacunación sea posterior a la de todos los ancianos. Si hay éxito se modifica el stock.
    public void addModerna(Moderna moderna, VaccineStock vaccinestock, PatientList patientlist){
        boolean existunvaccinedelders = false;
        for (int i =0; i<patientlist.size(); i++){
            if (patientlist.get(i).getAge()>=65 && !patientlist.get(i).isVaccined(this)){
                existunvaccinedelders = true;
            }
        }
        if (moderna.getPatient().getAge() >= 65){
            this.getModernaList().add(moderna);
            vaccinestock.RemoveModerna();
            System.out.println("Vacuna guardada");
        } else if(existunvaccinedelders){
            System.out.println("Existen pacientes con más prioridad sin vacunación asignada");
        } else if (this.getDateofLastElder().isAfter(moderna.getDate())){
             System.out.println("Existen pacientes con más prioridad para fechas posteriores a esta");
        } else{
            this.getModernaList().add(moderna);
            vaccinestock.RemoveModerna();
            System.out.println("Vacuna guardada");
        }
    }
    
    public void addPfizer(Pfizer pfizer, VaccineStock vaccinestock, PatientList patientlist){
        boolean existunvaccinedelders = false;
        for (int i =0; i<patientlist.size(); i++){
            if (patientlist.get(i).getAge()>=65 && !patientlist.get(i).isVaccined(this)){
                existunvaccinedelders = true;
            }
        }
        if (pfizer.getPatient().getAge() >= 65){
            this.getPfizerList().add(pfizer);
            vaccinestock.RemovePfizer();
            System.out.println("Vacuna guardada");
        } else if(existunvaccinedelders){
            System.out.println("Existen pacientes con más prioridad sin vacunación asignada");
        } else if (this.getDateofLastElder().isAfter(pfizer.getDate())){
             System.out.println("Existen pacientes con más prioridad para fechas posteriores a esta");
        } else{
            this.getPfizerList().add(pfizer);
            vaccinestock.RemovePfizer();
            System.out.println("Vacuna guardada");
        }
    }
    
    public void addJhonson(Jhonson jhonson, VaccineStock vaccinestock, PatientList patientlist){
        boolean existunvaccinedelders = false;
        for (int i =0; i<patientlist.size(); i++){
            if (patientlist.get(i).getAge()>=65 && !patientlist.get(i).isVaccined(this)){
                existunvaccinedelders = true;
            }
        }
        if (jhonson.getPatient().getAge() >= 65){
            this.getJhonsonList().add(jhonson);
            vaccinestock.RemoveJhonson();
            System.out.println("Vacuna guardada");
        } else if(existunvaccinedelders){
            System.out.println("Existen pacientes con más prioridad sin vacunación asignada");
        } else if (this.getDateofLastElder().isAfter(jhonson.getDate())){
             System.out.println("Existen pacientes con más prioridad para fechas posteriores a esta");
        } else{
            this.getJhonsonList().add(jhonson);
            vaccinestock.RemoveJhonson();
            System.out.println("Vacuna guardada");
        }
    }
}

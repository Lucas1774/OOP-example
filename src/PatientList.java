import java.util.ArrayList;

/**
 * Write a description of class PatientList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PatientList
{
    private ArrayList<Patient> patientlist;
    public PatientList()
    {
        this.patientlist = new ArrayList<Patient>();
    }
    
    public Patient get(int a){
        return this.patientlist.get(a);
    }

    public void add(Patient patient)
    {
        this.patientlist.add(patient);
    }
    
    public void remove(Patient patient){
        for (int i=0; i<this.size(); i++){
            if (this.get(i).CompareTo(patient)){
                this.patientlist.remove(this.get(i));
            }
        }
    }
        
    public void set (int a, Patient b){
        this.patientlist.set(a, b);
    }
    
    public int size(){
        return this.patientlist.size();
    }
    
    public boolean contains (Patient patient){
        boolean b = false;
        for (int i=0; i<this.size(); i++){
            if (this.get(i).CompareTo(patient)){
                b=true;
            }
        }
        return b;
    }
    
    public int indexOf(Patient patient){
        int p = 0;
        for (int i=0; i<this.size(); i++){
            if (this.get(i).CompareTo(patient)){
                p=i;
            }
        }
        return p;
    }
}

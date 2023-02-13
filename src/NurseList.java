import java.util.ArrayList;

/**
 * Write a description of class NurseList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NurseList
{
    private ArrayList<Nurse> nurselist;
    public NurseList()
    {
        this.nurselist = new ArrayList<Nurse>();
    }
    
    public Nurse get(int a){
        return this.nurselist.get(a);
    }

    public void add(Nurse nurse)
    {
        this.nurselist.add(nurse);
    }
    
    public void remove(Nurse nurse){
        for (int i=0; i<this.size(); i++){
            if (this.get(i).CompareTo(nurse)){
                this.nurselist.remove(this.get(i));
            }
        }
    }
        
    public void set (int a, Nurse b){
        this.nurselist.set(a, b);
    }
    
    public int size(){
        return this.nurselist.size();
    }
    
    public boolean contains (Nurse nurse){
        boolean b = false;
        for (int i=0; i<this.size(); i++){
            if (this.get(i).CompareTo(nurse)){
                b=true;
            }
        }
        return b;
    }
    
    public int indexOf(Nurse nurse){
        int p = 0;
        for (int i=0; i<this.size(); i++){
            if (this.get(i).CompareTo(nurse)){
                p=i;
            }
        }
        return p;
    }
}

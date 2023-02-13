import java.util.ArrayList;

/**
 * Write a description of class LabTechList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LabTechList
{
    private ArrayList<LabTech> labtechlist;
    public LabTechList()
    {
        this.labtechlist = new ArrayList<LabTech>();
    }
    
    public LabTech get(int a){
        return this.labtechlist.get(a);
    }

    public void add(LabTech labtech)
    {
        this.labtechlist.add(labtech);
    }
    
    public void remove(LabTech labtech){
        for (int i=0; i<this.size(); i++){
            if (this.get(i).CompareTo(labtech)){
                this.labtechlist.remove(this.get(i));
            }
        }
    }
        
    public void set (int a, LabTech b){
        this.labtechlist.set(a, b);
    }
    
    public int size(){
        return this.labtechlist.size();
    }
    
    public boolean contains (LabTech labtech){
        boolean b = false;
        for (int i=0; i<this.size(); i++){
            if (this.get(i).CompareTo(labtech)){
                b=true;
            }
        }
        return b;
    }
    
    public int indexOf(LabTech labtech){
        int p = 0;
        for (int i=0; i<this.size(); i++){
            if (this.get(i).CompareTo(labtech)){
                p=i;
            }
        }
        return p;
    }
}

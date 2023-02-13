
/**
 * Write a description of class VaccineListStock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VaccineStock
{
    // instance variables - replace the example below with your own
    private static int MODERNA_MAX= 200;
    private static int PFIZER_MAX= 200;
    private static int JHONSON_MAX= 200;
    private int stockmoderna;
    private int stockpfizer;
    private int stockjhonson;

    public VaccineStock()
    {
        this.stockmoderna= MODERNA_MAX;
        this.stockpfizer= PFIZER_MAX;
        this.stockjhonson= JHONSON_MAX;
    }

    public void CheckStock()
    {
        System.out.println("Unidades de Moderna:");
        System.out.println(this.stockmoderna);
        System.out.println("Unidades de Pfizer:");
        System.out.println(this.stockpfizer);
        System.out.println("Unidades de Jhonson:");
        System.out.println(this.stockjhonson);
    }
    
    public void ResetStock(){
        this.stockmoderna= MODERNA_MAX;
        this.stockpfizer= PFIZER_MAX;
        this.stockjhonson= JHONSON_MAX;
    }
    
    public void RemoveModerna(){
        this.stockmoderna--;
        if (this.stockmoderna <=0){
            System.out.println("Se necesitan vacunas de este tipo");
        }
    }
    
    public void RemovePfizer(){
        this.stockpfizer--;
        if (this.stockpfizer <=0){
            System.out.println("Se necesitan vacunas de este tipo");
        }
    }
    
    public void RemoveJhonson(){
        this.stockjhonson--;
        if (this.stockjhonson <=0){
            System.out.println("Se necesitan vacunas de este tipo");
        }
    }
}

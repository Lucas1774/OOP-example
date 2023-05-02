import java.time.LocalDate;  
import java.util.Scanner;

/**
 * Write a description of class clinica here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class clinica
{
    final static LocalDate CURRENTDATE = LocalDate.now();
    final static Admin  GOD = new Admin ("admin" , "admin");
    static Scanner inp = new Scanner(System.in);
    public static void main(String[] args){
        PatientList patientlist = new PatientList();
        LabTechList labtechlist = new LabTechList();
        NurseList nurselist = new NurseList();
        TestList testlist = new TestList();
        VaccineList vaccinelist = new VaccineList();
        VaccineStock vaccinestock = new VaccineStock();
        Admin admin;
        //Se instancian objetos para compararlos con los de las listas. Los segundos son prescindibles pero aportan legibilidad al código
        Nurse nurse, nurse1, nurse2;
        LabTech labtech, labtech1, labtech2;
        Patient patient1, patient2;
        String username1, password1;
        int day1, month1, year1;
        LocalDate date1;
        Fast fast1;
        Classic classic1;
        Pcr pcr1;
        Serologic serologic1;
        Moderna moderna1;
        Pfizer pfizer1;
        Jhonson jhonson1;
        //introducir aquí los datos para pruebas
        patient1 = new Patient ("p1","p1",25);
        patientlist.add(patient1);
        patient1 = new Patient ("p2","p2",75);
        patientlist.add(patient1);
        nurse1 = new Nurse ("e1","e1");
        nurselist.add(nurse1);
        nurse1 = new Nurse ("e2","e2");
        nurselist.add(nurse1);
        labtech1 = new LabTech ("t1","t1");
        labtechlist.add(labtech1);
        labtech1 = new LabTech ("t2","t2");
        labtechlist.add(labtech1);
        
        while(true){
            System.out.println("Clínica");
            boolean exists;
            int optionmain=0;
            do{
                System.out.println("Intrduzca su nombre de usuario");
                username1 = inp.nextLine();
                System.out. println ("Introduzca su contraseña");
                password1 = inp.nextLine();
                admin = new Admin (username1, password1);
                nurse = new Nurse (username1, password1);
                labtech = new LabTech (username1, password1);
                exists = false;
                if (admin.CompareTo(GOD)){
                    optionmain = 1;
                    exists = true;
                }
                if (!exists){
                    exists = nurselist.contains(nurse);
                    optionmain = 2;
                }
                if (!exists){
                    exists = labtechlist.contains(labtech);
                    optionmain = 3;
                }
                if (!exists){
                    System.out.println("No existen usuarios con estas credenciales");
                }
            } while(!exists);
            
            switch (optionmain){
                case 1:
                    int optionadmin;
                    do{
                        do {
                            optionadmin = 0;
                            System.out.println("Para gestionar usuarios pulse 1");
                            System.out.println("Para asignar pruebas diagnósticas a técnicos y enfermeros pulse 2");
                            System.out.println("Para asignar vacunas a enfermeros pulse 3");
                            System.out.println("Para acceder a la base de datos pulse 4");
                            System.out.println("Para acceder a los pacientes de un enfermero pulse 5");
                            System.out.println("Para acceder a los pacientes de un técnico pulse 6");
                            System.out.println("Para asignar un test postconfinamiento a un paciente que lo necesite pulse 7");
                            System.out.println("Para reestablecer el inventario pulse 8");
                            System.out.println("Para acceder a la lista de vacunaciones pulse 9");
                            System.out.println("Para cerrar sesión pulsa 10");
                            optionadmin = inp.nextInt();
                            inp.nextLine();
                        } while (optionadmin < 1 || optionadmin > 10);
    
                        switch (optionadmin){
                            case 1:
                                int optiongestion;
                                do{
                                    optiongestion = 0;
                                    System.out.println("Para dar de alta a un paciente pulse 1"); 
                                    System.out.println("Para dar de baja a un paciente pulse 2");
                                    System.out.println("Para modificar los datos de un paciente pulse 3");
                                    System.out.println("Para dar de alta a un técnico pulse 4"); 
                                    System.out.println("Para dar de baja a un técnico pulse 5");
                                    System.out.println("Para modificar los datos de un técnico pulse 6");
                                    System.out.println("Para dar de alta a un enfermero pulse 7"); 
                                    System.out.println("Para dar de baja a un enfermero pulse 8");
                                    System.out.println("Para modificar los datos de un enfermero pulse 9");
                                    optiongestion = inp.nextInt();
                                    inp.nextLine();
                                }while (optiongestion <1 && optiongestion > 9);
    
                                switch (optiongestion){
                                    case 1:
                                        patientlist.add(askforPatient());
                                        System.out.println("Paciente guardado con éxito");
                                        break;
                                    case 2:
                                        do {
                                            patient1 = askforPatient();                        
                                            if (!patientlist.contains (patient1)){
                                                System.out.println("No existe paciente con ese nombre");
                                            }
                                        } while (!patientlist.contains (patient1));
                                        patientlist.remove(patient1);
                                        System.out.println("Paciente borrado con éxito");
                                        break;
                                    case 3:
                                        do {
                                            patient1 = askforPatient();  
                                            if (!patientlist.contains (patient1)){
                                                System.out.println("No existe paciente con ese nombre");
                                            }
                                        } while (!patientlist.contains (patient1));
                                        patient2 = askforPatient();
                                        patientlist.set(patientlist.indexOf(patient1), patient2);
                                        System.out.println("Paciente modificado con éxito");
                                        break;
                                    case 4:
                                        labtechlist.add(askforLabTech());
                                        System.out.println("Técnico guardado con éxito");
                                        break;
                                    case 5:
                                        do {
                                            labtech1 = askforLabTech();                        
                                            if (!labtechlist.contains (labtech1)){
                                                System.out.println("No existe técnico con ese nombre");
                                            }
                                        } while (!labtechlist.contains (labtech1));
                                        labtechlist.remove(labtech1);
                                        System.out.println("Técnico borrado con éxito");
                                        break;
                                    case 6:
                                        do {
                                            labtech2 = askforLabTech();  
                                            if (!labtechlist.contains (labtech2)){
                                                System.out.println("No existe técnico con ese nombre");
                                            }
                                        } while (!labtechlist.contains (labtech2));
                                        labtech1 = askforLabTech();
                                        labtechlist.set(labtechlist.indexOf(labtech1), labtech2);
                                        System.out.println("Técnico modificado con éxito");
                                        break;
                                    case 7:
                                        nurselist.add(askforNurse());
                                        System.out.println("Enfermero guardado con éxito");
                                        break;
                                    case 8:
                                        do {
                                            nurse1 = askforNurse();                        
                                            if (!nurselist.contains (nurse1)){
                                                System.out.println("No existe enfermero con ese nombre");
                                            }
                                        } while (!nurselist.contains (nurse1));
                                        nurselist.remove(nurse1);
                                        System.out.println("Enfermero borrado con éxito");
                                        break;
                                    case 9:
                                        do {
                                            nurse2 = askforNurse();  
                                            if (!nurselist.contains (nurse2)){
                                                System.out.println("No existe enfermero con ese nombre");
                                            }
                                        } while (!nurselist.contains (nurse2));
                                        nurse1 = askforNurse();
                                        nurselist.set(nurselist.indexOf(nurse1), nurse2);
                                        System.out.println("Enfermero modificado con éxito");
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 2: //asignar tests a enfermero y técnico
                                do{
                                    labtech1 = askforLabTech();
                                    if (!labtechlist.contains (labtech1)){
                                        System.out.println("No existe técnico con ese nombre");
                                    }
                                } while(!labtechlist.contains (labtech1));
                                do{
                                    nurse1 = askforNurse();
                                    if (!nurselist.contains (nurse1)){
                                        System.out.println("No existe enfermero con ese nombre");
                                    }
                                } while(!nurselist.contains (nurse1));
                                int optiontesttype;
                                System.out.println("Seleccione el tipo de test, 1 para antígenos rápido, 2 para antígenos clásico, 3 para Pcr, 4 para serológico");
                                optiontesttype = inp.nextInt();
                                inp.nextLine();
                                int optiontestID;
                                System.out.println("Seleccione el ID del test a modificar. Debe existir. Los tests no son borrados y sirven como registro. El primero es el 1");
                                optiontestID = inp.nextInt();
                                inp.nextLine();
                                switch (optiontesttype){
                                    case 1:
                                        testlist.getAntigenFastList().get(optiontestID-1).setLabTech (labtech1, testlist);
                                        testlist.getAntigenFastList().get(optiontestID-1).setNurse (nurse1, testlist);
                                        break;
                                    case 2:
                                        testlist.getAntigenClassicList().get(optiontestID-1).setLabTech (labtech1, testlist);
                                        testlist.getAntigenFastList().get(optiontestID-1).setNurse (nurse1, testlist);
                                        break;
                                    case 3:
                                        testlist.getPcrList().get(optiontestID-1).setLabTech (labtech1, testlist);
                                        testlist.getPcrList().get(optiontestID-1).setNurse (nurse1, testlist);
                                        break;
                                    case 4:
                                        testlist.getSerologicList().get(optiontestID-1).setLabTech (labtech1, testlist);
                                        testlist.getSerologicList().get(optiontestID-1).setNurse (nurse1, testlist);
                                        break;
                                    default:
                                        System.out.println("Opción incorrecta");
                                        break;
                                }
                                break;
                            case 3: //asignar vacuna a enfermero
                                do{
                                    nurse1 = askforNurse();
                                    if (!nurselist.contains (nurse1)){
                                        System.out.println("No existe enfermero con ese nombre");
                                    }
                                } while(!nurselist.contains (nurse1));
                                int optionvaccinetype;
                                System.out.println("Seleccione el tipo de vacuna, 1 para Moderna, 2 para Pfizer, 3 para Jhonson");
                                optionvaccinetype = inp.nextInt();
                                inp.nextLine();
                                int optionvaccineID;
                                System.out.println("Seleccione la vacunación a modificar. Debe existir. Las vacunaciones no son borradas y sirven como registro. La primera es la 1");
                                optionvaccineID = inp.nextInt();
                                inp.nextLine();
                                switch (optionvaccinetype){
                                    case 1:
                                        vaccinelist.getModernaList().get(optionvaccineID-1).setNurse(nurse1);
                                        break;
                                    case 2:
                                        vaccinelist.getPfizerList().get(optionvaccineID-1).setNurse(nurse1);
                                        break;
                                    case 3:
                                        vaccinelist.getJhonsonList().get(optionvaccineID-1).setNurse(nurse1);
                                        break;
                                   default:
                                        System.out.println("Opción incorrecta");
                                        break;
                                }
                                break;
                            case 4:  //Database
                                System.out.println(" Lista de pacientes");
                                System.out.println("En orden, nombre, contraseña, edad, estado de confinamiento, fecha que comenzó el confinamiento (de existir), días que lleva confinado (de existir), necesidad de test y estado de vacunación ");
                                for (int i=0; i<patientlist.size(); i++){
                                    System.out.println(patientlist.get(i).getName());
                                    System.out.println(patientlist.get(i).getPassword());
                                    System.out.println(patientlist.get(i).getAge());
                                    System.out.println(patientlist.get(i).isConfined(testlist));
                                    if (patientlist.get(i).isConfined(testlist)){
                                        System.out.println(patientlist.get(i).getDateofConfinment(testlist).toString());
                                        System.out.println(patientlist.get(i).getDaysConfined(testlist));
                                    }
                                    System.out.println(patientlist.get(i).needsTest(testlist));
                                    System.out.println(patientlist.get(i).isVaccined(vaccinelist));
                                }
                                System.out.println("Lista de enfermeros");
                                for (int i=0; i<nurselist.size(); i++) {  
                                    System.out.println(nurselist.get(i).getName());
                                    System.out.println(nurselist.get(i).getPassword());
                                }
                                System.out.println("Lista de técnicos");
                                for (int i=0; i<labtechlist.size(); i++){
                                    System.out.println(labtechlist.get(i).getName());
                                    System.out.println(labtechlist.get(i).getPassword());
                                }
                                break;
                            case 5://pacientes de un enfermero
                                do{
                                    nurse1 = askforNurse();
                                    if (!nurselist.contains (nurse1)){
                                        System.out.println("No existe enfermero con ese nombre");
                                    }
                                } while(!nurselist.contains (nurse1));
                                System.out.println("Tests del enfermero");
                                System.out.println("Tests rápidos de antígenos");
                                for (int i=0; i<testlist.getAntigenFastList().size(); i++){
                                    if(testlist.getAntigenFastList().get(i).getNurse().CompareTo(nurse1)){
                                        System.out.println (testlist.getAntigenFastList().get(i).getDate().toString());
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().getName());
                                    }
                                }
                                System.out.println("Tests clásicos de antígenos");
                                for (int i=0; i<testlist.getAntigenClassicList().size(); i++){
                                    if(testlist.getAntigenClassicList().get(i).getNurse().CompareTo(nurse1)){
                                        System.out.println (testlist.getAntigenClassicList().get(i).getDate().toString());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getName());
                                    }
                                }
                                System.out.println("Tests PCR");
                                for (int i=0; i<testlist.getPcrList().size(); i++){
                                    if(testlist.getPcrList().get(i).getNurse().CompareTo(nurse1)){
                                        System.out.println (testlist.getPcrList().get(i).getDate().toString());
                                        System.out.println (testlist.getPcrList().get(i).getPatient().getName());
                                    }
                                }
                                System.out.println("Tests Serológicos");
                                for (int i=0; i<testlist.getSerologicList().size(); i++){
                                    if(testlist.getSerologicList().get(i).getNurse().CompareTo(nurse1)){
                                        System.out.println (testlist.getSerologicList().get(i).getDate().toString());
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().getName());
                                    }
                                }
                                System.out. println("Vacunaciones del enfermero");
                                System.out.println("Vacunaciones con Moderna");
                                for (int i=0; i<vaccinelist.getModernaList().size(); i++){
                                    if(vaccinelist.getModernaList().get(i).getNurse().CompareTo(nurse1)){
                                        System.out.println (vaccinelist.getModernaList().get(i).getDate().toString());
                                        System.out.println (vaccinelist.getModernaList().get(i).getPatient().getName());
                                    }
                                }
                                System.out.println("Vacunaciones con Pfizer");
                                for (int i=0; i<vaccinelist.getPfizerList().size(); i++){
                                    if(vaccinelist.getPfizerList().get(i).getNurse().CompareTo(nurse1)){
                                        System.out.println (vaccinelist.getPfizerList().get(i).getDate().toString());
                                        System.out.println (vaccinelist.getPfizerList().get(i).getPatient().getName());
                                    }
                                }
                                System.out.println("Vacunaciones con Jhonson&Jhonson");
                                for (int i=0; i<vaccinelist.getJhonsonList().size(); i++){
                                    if(vaccinelist.getJhonsonList().get(i).getNurse().CompareTo(nurse1)){
                                        System.out.println (vaccinelist.getJhonsonList().get(i).getDate().toString());
                                        System.out.println (vaccinelist.getJhonsonList().get(i).getPatient().getName());
                                    }
                                }
                                break;
                            case 6://pacientes de un técnico
                                do{
                                    labtech1 = askforLabTech();
                                    if (!labtechlist.contains (labtech1)){
                                        System.out.println("No existe técnico con ese nombre");
                                    }
                                } while(!labtechlist.contains (labtech1));
                                System.out.println("Tests del técnico");
                                System.out.println("Tests rápidos de antígenos");
                                for (int i=0; i<testlist.getAntigenFastList().size(); i++){
                                    if(testlist.getAntigenFastList().get(i).getLabTech().CompareTo(labtech1)){
                                        System.out.println (testlist.getAntigenFastList().get(i).getDate().toString());
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().getName());
                                    }
                                }
                                System.out.println("Tests clásicos de antígenos");
                                for (int i=0; i<testlist.getAntigenClassicList().size(); i++){
                                    if(testlist.getAntigenClassicList().get(i).getLabTech().CompareTo(labtech1)){
                                        System.out.println (testlist.getAntigenClassicList().get(i).getDate().toString());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getName());
                                    }
                                }
                                System.out.println("Tests PCR");
                                for (int i=0; i<testlist.getPcrList().size(); i++){
                                    if(testlist.getPcrList().get(i).getLabTech().CompareTo(labtech1)){
                                        System.out.println (testlist.getPcrList().get(i).getDate().toString());
                                        System.out.println (testlist.getPcrList().get(i).getPatient().getName());
                                    }
                                }
                                System.out.println("Tests Serológicos");
                                for (int i=0; i<testlist.getSerologicList().size(); i++){
                                    if(testlist.getSerologicList().get(i).getLabTech().CompareTo(labtech1)){
                                        System.out.println (testlist.getSerologicList().get(i).getDate().toString());
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().getName());
                                    }
                                }
                                break;
                            case 7://asignar test a un paciente que lo necesita
                                do{
                                    patient1= askforPatient();
                                    if (!patientlist.contains (patient1)){
                                        System.out.println("No existe paciente con ese nombre");
                                    }
                                    if (!patient1.needsTest(testlist)){
                                        System.out.println("Este paciente no necesita un test");
                                    }
                                } while(!patientlist.contains (patient1) || !patient1.needsTest(testlist));
                                System.out.println("Introduzca en orden año, mes y día, pulsar enter después de cada valor. Debe existir.");
                                day1 = inp.nextInt();
                                inp.nextLine();
                                month1 = inp.nextInt();
                                inp.nextLine();
                                year1 = inp.nextInt();
                                inp.nextLine();
                                date1 = LocalDate.of(day1,month1,year1);
                                serologic1 = new Serologic (patient1, date1);
                                testlist.addSerologic(serologic1);
                                break;
                            case 8: //stock
                                vaccinestock.CheckStock();
                                vaccinestock.ResetStock();
                                System.out.println("Se han actualizado estos valores al máximo (200)");
                                break;
                            case 9: //vacunas
                                System.out.println("En orden se muestra la fecha, el nombre del paciente, la edad del paciente, el enfermero asignado y la fecha de la segunda dosis (no para Jhonson&Jhonson))");
                                System.out.println("Vacunaciones con Moderna");
                                for (int i=0; i<vaccinelist.getModernaList().size(); i++){
                                    System.out.println (vaccinelist.getModernaList().get(i).getDate().toString());
                                    System.out.println (vaccinelist.getModernaList().get(i).getPatient().getName());
                                    System.out.println (vaccinelist.getModernaList().get(i).getPatient().getAge());
                                    System.out.println (vaccinelist.getModernaList().get(i).getNurse().getName());
                                    System.out.println (vaccinelist.getModernaList().get(i).getDateofSecond()); 
                                }
                                System.out.println("Vacunaciones con Pfizer");
                                for (int i=0; i<vaccinelist.getPfizerList().size(); i++){
                                    System.out.println (vaccinelist.getPfizerList().get(i).getDate().toString());
                                    System.out.println (vaccinelist.getPfizerList().get(i).getPatient().getName());
                                    System.out.println (vaccinelist.getPfizerList().get(i).getPatient().getAge());
                                    System.out.println (vaccinelist.getPfizerList().get(i).getNurse().getName());
                                    System.out.println (vaccinelist.getPfizerList().get(i).getDateofSecond()); 
                                }
                                System.out.println("Vacunaciones con Jhonson&Jhonson");
                                for (int i=0; i<vaccinelist.getJhonsonList().size(); i++){
                                    System.out.println (vaccinelist.getJhonsonList().get(i).getDate().toString());
                                    System.out.println (vaccinelist.getJhonsonList().get(i).getPatient().getName());
                                    System.out.println (vaccinelist.getJhonsonList().get(i).getPatient().getAge());
                                    System.out.println (vaccinelist.getJhonsonList().get(i).getNurse().getName());
                                }
                                break;
                            default:
                                break;
                        }
                    } while (optionadmin !=10);
                    break;
                case 2: // Enfermero
                    int optiontech = 0;
                    do{
                        do {
                            System.out.println("Para ver los datos de los pacientes asignados pulse 1");
                            System.out.println("Para programar un test para un paciente pulse 2");
                            System.out.println("Para programar una vacunación para un paciente pulse 3");
                            System.out.println("Para cerrar sesión pulse 4");
                            optiontech = inp.nextInt();
                            inp.nextLine();
                        } while (optiontech < 1 || optiontech > 4);
                        switch (optiontech){
                            case 1: //visualizar datos de sus pacientes
                                System.out.println("Tests de pacientes asignados a usted. En orden se muestra ID fecha, resultado, nombre, contraseña, edad, estado de confinamiento, fecha que comenzó el confinamiento (de existir), días que lleva confinado (de existir), necesidad de test, y estado de vacunación");
                                System.out.println("Tests rápidos de antígenos");
                                for (int i=0; i<testlist.getAntigenFastList().size(); i++){
                                    if(testlist.getAntigenFastList().get(i).getNurse().CompareTo(nurse)){
                                        System.out.println (i+1);
                                        System.out.println (testlist.getAntigenFastList().get(i).getDate().toString());
                                        System.out.println (testlist.getAntigenFastList().get(i).getResult());
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().getName());
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().getPassword());
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().getAge());
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().isConfined(testlist));
                                        if (testlist.getAntigenFastList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (testlist.getAntigenFastList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (testlist.getAntigenFastList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().needsTest(testlist));
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().isVaccined(vaccinelist));
                                    }
                                }
                                System.out.println("Tests clásicos de antígenos");
                                for (int i=0; i<testlist.getAntigenClassicList().size(); i++){
                                    if(testlist.getAntigenClassicList().get(i).getNurse().CompareTo(nurse)){
                                        System.out.println (i+1);
                                        System.out.println (testlist.getAntigenClassicList().get(i).getDate().toString());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getResult());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getName());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getPassword());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getAge());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().isConfined(testlist));
                                        if (testlist.getAntigenClassicList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().needsTest(testlist));
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().isVaccined(vaccinelist));
                                    }
                                }
                                System.out.println("Tests PCR");
                                for (int i=0; i<testlist.getPcrList().size(); i++){
                                    if(testlist.getPcrList().get(i).getNurse().CompareTo(nurse)){
                                        System.out.println (i+1);
                                        System.out.println (testlist.getPcrList().get(i).getDate().toString());
                                        System.out.println (testlist.getPcrList().get(i).getResult());
                                        System.out.println (testlist.getPcrList().get(i).getPatient().getName());
                                        System.out.println (testlist.getPcrList().get(i).getPatient().getPassword());
                                        System.out.println (testlist.getPcrList().get(i).getPatient().getAge());
                                        System.out.println (testlist.getPcrList().get(i).getPatient().isConfined(testlist));
                                        if (testlist.getPcrList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (testlist.getPcrList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (testlist.getPcrList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (testlist.getPcrList().get(i).getPatient().needsTest(testlist));
                                        System.out.println (testlist.getPcrList().get(i).getPatient().isVaccined(vaccinelist));
                                    }
                                }
                                System.out.println("Tests Serológicos");
                                for (int i=0; i<testlist.getSerologicList().size(); i++){
                                    if(testlist.getSerologicList().get(i).getNurse().CompareTo(nurse)){
                                        System.out.println (i+1);
                                        System.out.println (testlist.getSerologicList().get(i).getDate().toString());
                                        System.out.println (testlist.getSerologicList().get(i).getResult());
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().getName());
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().getPassword());
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().getAge());
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().isConfined(testlist));
                                        if (testlist.getSerologicList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (testlist.getSerologicList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (testlist.getSerologicList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().needsTest(testlist));
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().isVaccined(vaccinelist));
                                    }
                                }
                                System.out.println("Vacunaciones de pacientes asignadas a usted. En orden se muestra fecha de la primrea, fecha de la segunda (si existe), nombre, edad, estado de confinamiento, fecha que comenzó el confinamiento (de existir), días que lleva confinado (de existir) y necesidad de test");
                                System.out.println("Vacunaciones con Moderna");
                                for (int i=0; i<vaccinelist.getModernaList().size(); i++){
                                    if(vaccinelist.getModernaList().get(i).getNurse().CompareTo(nurse)){
                                        System.out.println (vaccinelist.getModernaList().get(i).getDate().toString());
                                        System.out.println (vaccinelist.getModernaList().get(i).getDateofSecond());
                                        System.out.println (vaccinelist.getModernaList().get(i).getPatient().getName());
                                        System.out.println (vaccinelist.getModernaList().get(i).getPatient().getPassword());
                                        System.out.println (vaccinelist.getModernaList().get(i).getPatient().getAge());
                                        System.out.println (vaccinelist.getModernaList().get(i).getPatient().isConfined(testlist));
                                        if (vaccinelist.getModernaList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (vaccinelist.getModernaList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (vaccinelist.getModernaList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (vaccinelist.getModernaList().get(i).getPatient().needsTest(testlist));
                                    }
                                }
                                System.out.println("Vacunaciones con Pfizer");
                                for (int i=0; i<vaccinelist.getPfizerList().size(); i++){
                                    if(vaccinelist.getPfizerList().get(i).getNurse().CompareTo(nurse)){
                                        System.out.println (vaccinelist.getPfizerList().get(i).getDate().toString());
                                        System.out.println (vaccinelist.getPfizerList().get(i).getDateofSecond());
                                        System.out.println (vaccinelist.getPfizerList().get(i).getPatient().getName());
                                        System.out.println (vaccinelist.getPfizerList().get(i).getPatient().getPassword());
                                        System.out.println (vaccinelist.getPfizerList().get(i).getPatient().getAge());
                                        System.out.println (vaccinelist.getPfizerList().get(i).getPatient().isConfined(testlist));
                                        if (vaccinelist.getPfizerList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (vaccinelist.getPfizerList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (vaccinelist.getPfizerList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (vaccinelist.getPfizerList().get(i).getPatient().needsTest(testlist));
                                    }
                                }
                                System.out.println("Vacunaciones con Jhonson");
                                for (int i=0; i<vaccinelist.getJhonsonList().size(); i++){
                                    if(vaccinelist.getJhonsonList().get(i).getNurse().CompareTo(nurse)){
                                        System.out.println (vaccinelist.getJhonsonList().get(i).getDate().toString());
                                        System.out.println (vaccinelist.getJhonsonList().get(i).getPatient().getName());
                                        System.out.println (vaccinelist.getJhonsonList().get(i).getPatient().getPassword());
                                        System.out.println (vaccinelist.getJhonsonList().get(i).getPatient().getAge());
                                        System.out.println (vaccinelist.getJhonsonList().get(i).getPatient().isConfined(testlist));
                                        if (vaccinelist.getJhonsonList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (vaccinelist.getJhonsonList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (vaccinelist.getJhonsonList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (vaccinelist.getJhonsonList().get(i).getPatient().needsTest(testlist));
                                    }
                                }
                                break;
                            case 2: //programar test
                                do {
                                    patient1 = askforPatient();                       
                                    if (!patientlist.contains (patient1)){
                                        System.out.println("No existe paciente con ese nombre");
                                    }
                                } while (!patientlist.contains (patient1));
                                System.out.println("Introduzca en orden año, mes y día, pulsar enter después de cada valor. Debe existir.");
                                day1 = inp.nextInt();
                                inp.nextLine();
                                month1 = inp.nextInt();
                                inp.nextLine();
                                year1 = inp.nextInt();
                                inp.nextLine();
                                date1 = LocalDate.of(day1,month1,year1);
                                int optiontesttype;
                                System.out.println("Seleccione el tipo de test, 1 para antígenos rápido, 2 para antígenos clásico, 3 para Pcr, 4 para serológico");
                                optiontesttype = inp.nextInt();
                                inp.nextLine();
                                switch (optiontesttype){
                                    case 1:
                                        fast1 = new Fast (patient1, date1);
                                        testlist.addFast(fast1);
                                        break;
                                    case 2:
                                        classic1 = new Classic (patient1, date1);
                                        testlist.addClassic (classic1);
                                        break;
                                    case 3:
                                        pcr1 = new Pcr (patient1, date1);
                                        testlist.addPcr(pcr1);
                                        break;
                                    case 4:
                                        serologic1 = new Serologic (patient1, date1);
                                        testlist.addSerologic(serologic1);
                                        break;
                                    default:
                                        System.out.println("Opción incorrecta");
                                        break;
                                }
                                break;
                            case 3: //programar vacunación
                            do {
                                patient1 = askforPatient();                
                                    if (!patientlist.contains (patient1)){
                                        System.out.println("No existe paciente con ese nombre");
                                    }
                                    if (patient1.isVaccined(vaccinelist)){
                                        System.out.println("Este paciente ya está vacunado");
                                    }
                                } while (!patientlist.contains (patient1) || patient1.isVaccined(vaccinelist));
                                System.out.println("Introduzca en orden año, mes y día, pulsar enter después de cada valor. Debe existir.");
                                day1 = inp.nextInt();
                                inp.nextLine();
                                month1 = inp.nextInt();
                                inp.nextLine();
                                year1 = inp.nextInt();
                                inp.nextLine();
                                date1 = LocalDate.of(day1,month1,year1);
                                int optionvaccinetype;
                                System.out.println("Seleccione el tipo de vacuna, 1 para Moderna, 2 para Pfizer, 3 para Jhonson");
                                optionvaccinetype = inp.nextInt();
                                inp.nextLine();
                                switch (optionvaccinetype){
                                    case 1:
                                        moderna1 = new Moderna (patient1, date1);
                                        vaccinelist.addModerna(moderna1, vaccinestock, patientlist);
                                        moderna1.setDateofSecond();
                                        break;
                                    case 2:
                                        pfizer1 = new Pfizer (patient1, date1);
                                        vaccinelist.addPfizer(pfizer1, vaccinestock, patientlist);
                                        pfizer1.setDateofSecond();
                                        break;
                                    case 3:
                                        jhonson1 = new Jhonson (patient1, date1);
                                        vaccinelist.addJhonson(jhonson1, vaccinestock, patientlist);
                                        break;
                                    default:
                                        System.out.println("Opción incorrecta");
                                        break;
                                }
                                break;
                            default: 
                                break;
                        }
                    }while (optiontech !=4);
                    break;
                case 3: // Técnico
                    int optionnurse = 0;
                    do{
                        do {
                            System.out.println("Para ver los datos de los pacientes asignados pulse 1");
                            System.out.println("Para registrar el resultado de un test pulse 2");
                            System.out.println("Para cerrar sesión pulse 3");
                            optionnurse = inp.nextInt();
                            inp.nextLine();
                        } while (optionnurse < 1 || optionnurse > 3);
                        switch (optionnurse){
                            case 1: //visualizar datos de sus pacientes
                                System.out.println("Tests de pacientes asignados a usted. En orden se muestra fecha, resultado, nombre, contraseña, edad, estado de confinamiento, fecha que comenzó el confinamiento (de existir), días que lleva confinado (de existir), necesidad de test y estado de vacunación");
                                System.out.println("Tests rápidos de antígenos");
                                for (int i=0; i<testlist.getAntigenFastList().size(); i++){
                                    if(testlist.getAntigenFastList().get(i).getLabTech().CompareTo(labtech)){
                                        System.out.println (i+1);
                                        System.out.println (testlist.getAntigenFastList().get(i).getDate().toString());
                                        System.out.println (testlist.getAntigenFastList().get(i).getResult());
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().getName());
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().getPassword());
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().getAge());
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().isConfined(testlist));
                                        if (testlist.getAntigenFastList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (testlist.getAntigenFastList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (testlist.getAntigenFastList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().needsTest(testlist));
                                        System.out.println (testlist.getAntigenFastList().get(i).getPatient().isVaccined(vaccinelist));
                                    }
                                }
                                System.out.println("Tests clásicos de antígenos");
                                for (int i=0; i<testlist.getAntigenClassicList().size(); i++){
                                    if(testlist.getAntigenClassicList().get(i).getLabTech().CompareTo(labtech)){
                                        System.out.println (i+1);
                                        System.out.println (testlist.getAntigenClassicList().get(i).getDate().toString());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getResult());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getName());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getPassword());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getAge());
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().isConfined(testlist));
                                        if (testlist.getAntigenClassicList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (testlist.getAntigenClassicList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().needsTest(testlist));
                                        System.out.println (testlist.getAntigenClassicList().get(i).getPatient().isVaccined(vaccinelist));
                                    }
                                }
                                System.out.println("Tests PCR");
                                for (int i=0; i<testlist.getPcrList().size(); i++){
                                    if(testlist.getPcrList().get(i).getLabTech().CompareTo(labtech)){
                                        System.out.println (i+1);
                                        System.out.println (testlist.getPcrList().get(i).getDate().toString());
                                        System.out.println (testlist.getPcrList().get(i).getResult());
                                        System.out.println (testlist.getPcrList().get(i).getPatient().getName());
                                        System.out.println (testlist.getPcrList().get(i).getPatient().getPassword());
                                        System.out.println (testlist.getPcrList().get(i).getPatient().getAge());
                                        System.out.println (testlist.getPcrList().get(i).getPatient().isConfined(testlist));
                                        if (testlist.getPcrList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (testlist.getPcrList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (testlist.getPcrList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (testlist.getPcrList().get(i).getPatient().needsTest(testlist));
                                        System.out.println (testlist.getPcrList().get(i).getPatient().isVaccined(vaccinelist));
                                    }
                                }
                                System.out.println("Tests Serológicos");
                                for (int i=0; i<testlist.getSerologicList().size(); i++){
                                    if(testlist.getSerologicList().get(i).getLabTech().CompareTo(labtech)){
                                        System.out.println (i+1);
                                        System.out.println (testlist.getSerologicList().get(i).getDate().toString());
                                        System.out.println (testlist.getSerologicList().get(i).getResult());
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().getName());
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().getPassword());
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().getAge());
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().isConfined(testlist));
                                        if (testlist.getSerologicList().get(i).getPatient().isConfined(testlist)){
                                            System.out.println (testlist.getSerologicList().get(i).getPatient().getDateofConfinment(testlist).toString());
                                            System.out.println (testlist.getSerologicList().get(i).getPatient().getDaysConfined(testlist));
                                        }
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().needsTest(testlist));
                                        System.out.println (testlist.getSerologicList().get(i).getPatient().isVaccined(vaccinelist));
                                    }
                                }
                                break;
                            case 2: //registrar resultado de un test
                                int optiontesttype;
                                System.out.println("Seleccione el tipo de test, 1 para antígenos rápido, 2 para antígenos clásico, 3 para Pcr, 4 para serológico");
                                optiontesttype = inp.nextInt();
                                inp.nextLine();
                                int optiontestID;
                                System.out.println("Seleccione el ID del test a modificar. Debe existir y haber sido realizado. Los tests no son borrados y sirven como registro. El primero es el 1");
                                optiontestID = inp.nextInt();
                                inp.nextLine();
                                switch (optiontesttype){
                                    case 1:
                                        if (testlist.getAntigenFastList().get(optiontestID-1).getDate().isAfter(CURRENTDATE)){
                                            System.out.println("Este test aún no ha sido realizado");
                                        } else{
                                            testlist.getAntigenFastList().get(optiontestID-1).setResult();
                                        }
                                        break;
                                    case 2:
                                        if (testlist.getAntigenClassicList().get(optiontestID-1).getDate().isAfter(CURRENTDATE)){
                                            System.out.println("Este test aún no ha sido realizado");
                                        } else{
                                            testlist.getAntigenClassicList().get(optiontestID-1).setResult();
                                        }
                                        
                                        break;
                                    case 3:
                                        if (testlist.getPcrList().get(optiontestID-1).getDate().isAfter(CURRENTDATE)){
                                            System.out.println("Este test aún no ha sido realizado");
                                        } else{
                                            testlist.getPcrList().get(optiontestID-1).setResult();
                                        }
                                        
                                        break;
                                    case 4:
                                        if (testlist.getSerologicList().get(optiontestID-1).getDate().isAfter(CURRENTDATE)){
                                            System.out.println("Este test aún no ha sido realizado");
                                        } else{
                                            testlist.getSerologicList().get(optiontestID-1).setResult();
                                        }
                                        break;
                                    default:
                                        System.out.println("Opción incorrecta");
                                        break;
                                }
                                break;
                            default: 
                                break;
                        }
                    }while (optionnurse !=3);
                    break;
                default:
                    break;
            }
        }
    }
    
    static Patient askforPatient(){
        Patient patient1;
        String username1;
        String password1;
        int age1;
        System.out.println("Introduzca el nombre del paciente");
        username1 = inp.nextLine();
        System.out.println("Introduzca la contraseña del paciente");
        password1 = inp.nextLine();
        System.out.println("Introduzca la edad del paciente");
        age1 = inp.nextInt ();
        inp.nextLine();
        patient1 = new Patient (username1, password1, age1);
        return patient1;
    }
    
    static Nurse askforNurse(){
        Nurse nurse1;
        String username1;
        String password1;
        System.out.println("Introduzca el nombre del enfermero");
        username1 = inp.nextLine();
        System.out.println("Introduzca la conraseña del enfermero");
        password1 = inp.nextLine();
        nurse1 = new Nurse (username1, password1);
        return nurse1;
    }
    
    static LabTech askforLabTech(){
        LabTech labtech1;
        String username1;
        String password1;
        System.out.println("Introduzca el nombre del técnico");
        username1 = inp.nextLine();
        System.out.println("Introduzca la contraseña del técnico");
        password1 = inp.nextLine();
        labtech1 = new LabTech (username1, password1);
        return labtech1;
    }
}

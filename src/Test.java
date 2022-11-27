

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
         String ANSI_BLUE = "\u001B[34m";
         String ANSI_RESET = "\u001B[0m";
        //Pharmaci1-Brasov
        Pharmacy pharmacyBv1 =new Pharmacy("Pharmacy-Sahne-BV-Sud");
        pharmacyBv1.setPharmacyTown("Brasov-Nord");
        pharmacyBv1.setPhoneNumberPharmacy("0736273928");
        pharmacyBv1.setEmailPharmacy("pharmacySahneBvNord@yahoo.com");
        pharmacyBv1.setPharmacyType(1);
        pharmacyBv1.setNumberEmployees(10);
        pharmacyBv1.setProgramPharmacy(1);
        pharmacyBv1.setAcceptCardPayment(true);
        pharmacyBv1.setInsuranceCompanyContract(true);

        System.out.println();
        System.out.println();
        //Pharmaci2-Brasov
        Pharmacy pharmacyBv2 =new Pharmacy("Pharmacy-Sahne-Bv-Sud");
        pharmacyBv2.setPharmacyTown("Brasov-Sud");
        pharmacyBv2.setPhoneNumberPharmacy("0736277836");
        pharmacyBv2.setEmailPharmacy("pharmacySahneBvSud@yahoo.com");
        pharmacyBv2.setPharmacyType(2);
        pharmacyBv2.setNumberEmployees(11);
        pharmacyBv2.setProgramPharmacy(2);
        pharmacyBv2.setAcceptCardPayment(true);
        pharmacyBv2.setInsuranceCompanyContract(false);
        System.out.println();
        System.out.println();
        //Pharmaci3-Sibiu
        Pharmacy pharmacySb =new Pharmacy("Pharmacy-Sahne-Sb");
        pharmacySb.setPharmacyTown("Sibiu");
        pharmacySb.setPhoneNumberPharmacy("0732145757");
        pharmacySb.setEmailPharmacy("pharmacySahneSb@yahoo.com");
        pharmacySb.setPharmacyType(3);
        pharmacySb.setNumberEmployees(9);
        pharmacySb.setProgramPharmacy(3);
        pharmacySb.setAcceptCardPayment(false);
        pharmacySb.setInsuranceCompanyContract(false);
        System.out.println();
        System.out.println();
        //Pharmaci4-Covasna
        Pharmacy pharmacyCv =new Pharmacy("Pharmacy-Sahne-Cv");
        pharmacyCv.setPharmacyTown("Covasna");
        pharmacyCv.setPhoneNumberPharmacy("0736478928");
        pharmacyCv.setEmailPharmacy("pharmacySahneCv@yahoo.com");
        pharmacyCv.setPharmacyType(1);
        pharmacyCv.setNumberEmployees(8);
        pharmacyCv.setProgramPharmacy(3);
        pharmacyCv.setAcceptCardPayment(true);
        pharmacyCv.setInsuranceCompanyContract(true);
        System.out.println();
        System.out.println();
        //MedicineBv-Nord
        Drugs medicineBvNord1 = new Drugs("Nurofen",10,50,
                "AstraZeneca","50",false,"2023-11-25");
        Drugs medicineBvNord2  = new Drugs("Paracetamol",15.0,50,
                "Moderna","0",false,"2023-12-19");
        Drugs medicineBvNord3  = new Drugs("Algocalmin",15.0,50,
                "Pfizer","0",false,"2023-12-19");
        Set<Drugs>setStockPharmacyBvNord = new HashSet<>();
        setStockPharmacyBvNord.add(medicineBvNord1);
        setStockPharmacyBvNord.add(medicineBvNord2);
        setStockPharmacyBvNord.add(medicineBvNord3);
        pharmacyBv1.setMedicineStock(setStockPharmacyBvNord);
        System.out.println(ANSI_BLUE+"The Brasov pharmacy stock is : "+ANSI_RESET);
        System.out.println(pharmacyBv1.getMedicineStock());
        System.out.println();
//Order
        Drugs orderBvNord1 = new Drugs("Nurofen",15);
        Drugs orderBvNord2 = new Drugs("Paracetamol",25);
        List<Drugs> order1 = new ArrayList<>();
        order1.add(orderBvNord1);
        order1.add(orderBvNord2);
        System.out.println(ANSI_BLUE+ "Stock left after the order :"+ANSI_RESET);
        pharmacyBv1.placeOrder(order1,true);
        System.out.println();
        System.out.println();
        //Expiration date
        medicineBvNord1.verifyExpirationDate();
        medicineBvNord2.verifyExpirationDate();
        medicineBvNord3.verifyExpirationDate();
        System.out.println();

        List<Pharmacy> allPharmacy= new ArrayList<>();
        allPharmacy.add(pharmacyBv1);
        allPharmacy.add(pharmacyBv2);
        allPharmacy.add(pharmacySb);
        allPharmacy.add(pharmacyCv);
        System.out.println();

        Brand brand = new Brand();
        //Display of all pharmacies
        brand.showAllPharmacy(allPharmacy);
        System.out.println();
        //Display of all pharmacies where you can pay by card
        brand.acceptsCardPayment(allPharmacy);
        System.out.println();
        //Display of pharmacies with a non-stop program
        brand.displayNonStopPharmacies(allPharmacy);
        System.out.println();
        //Display of pharmacies with hybrid/online program
        brand.showEmailAndPhone(allPharmacy);
        System.out.println();
        //The total number of employees in all pharmacies
        brand.displayAllEmployees(allPharmacy);
        System.out.println();



























































    }
}

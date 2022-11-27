import java.util.List;

public class Brand {
private List<Pharmacy>allPharemacy;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public void showAllPharmacy(List<Pharmacy> allPharmacy) {
        System.out.println(ANSI_GREEN+"Display of all pharmacies : "+ANSI_RESET);
        System.out.println("Pharmacy :"+"\n"+allPharmacy);
    }
    public void displayAllEmployees(List<Pharmacy> allPharmacy) {
        this.allPharemacy=allPharmacy;
        int allEmployees = 0;
        for (Pharmacy element : this.allPharemacy) {
            allEmployees += element.getNumberEmployees();
        }
        System.out.println(ANSI_GREEN+"The total number of employees : " + ANSI_RESET);
        System.out.println(allEmployees);
    }

    public void acceptsCardPayment(List<Pharmacy> allPharmacy) {
        this.allPharemacy=allPharmacy;
        for (Pharmacy element : this.allPharemacy) {
            if (element.isAcceptCardPayment()) {
                System.out.println(ANSI_GREEN+"Pharmacies where you can pay by card : "+ANSI_RESET);
                System.out.println("Pharmacy :"+ element.getPharmacyTown());
            }

        }
    }
    public void displayNonStopPharmacies(List<Pharmacy> allPharmacy) {
        this.allPharemacy=allPharmacy;
        for (Pharmacy element : this.allPharemacy) {
            if (element.getProgramPharmacy() ==1) {
                System.out.println(ANSI_GREEN+"Pharmacies with a non-stop program : "+ANSI_RESET);
                System.out.println( "Pharmacy :"+element.getPharmacyTown());
            }

        }
    }

    public void showEmailAndPhone(List<Pharmacy> allPharmacy) {
        this.allPharemacy=allPharmacy;
        for (Pharmacy element : this.allPharemacy) {
            if (element.getPharmacyType()==2 || element.getPharmacyType()==3) {
                System.out.println(ANSI_GREEN+"Pharmacies with a hybrid/online program : "+ANSI_RESET);
                System.out.println(element.getPharmacyTown()+"\n"+"Email :"+element.getEmailPharmacy() + "\n" +
                        "Phone number"+element.getPhoneNumberPharmacy());
            }
        }
    }

}

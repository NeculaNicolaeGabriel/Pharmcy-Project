import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Pharmacy {

    private String namePharmacy;
    private int numberEmployees;
    private String PharmacyTown;
    private boolean InsuranceCompanyContract;
    private boolean acceptCardPayment;
    private int programPharmacy;
    private boolean discountWithPurchasingCard;

    private String phoneNumberPharmacy;
    private String emailPharmacy;
    private int pharmacyType;
    ////
    private Set<Drugs> medicineStock;
    private List<Pharmacy> allPharmacy;
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Pharmacy(String namePharmacy) {
        this.namePharmacy = namePharmacy;
        System.out.println(ANSI_PURPLE+"Name : " + namePharmacy+ ANSI_RESET);
    }

    public List<Pharmacy> getAllPharmacy() {
        return allPharmacy;
    }

    public void setAllPharmacy(List<Pharmacy> allPharmacy) {
        this.allPharmacy = allPharmacy;
    }

    @Override
    public String toString() {
    return String.format(getPharmacyTown()+"\n");
    }

    public int getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(int numberEmployees) {
        this.numberEmployees = numberEmployees;
        System.out.println("Number of employees : " + numberEmployees);
    }

    public boolean isDiscountWithPurchasingCard() {
        return discountWithPurchasingCard;
    }

    public void setDiscountWithPurchasingCard(boolean discountWithPurchasingCard) {
        this.discountWithPurchasingCard = discountWithPurchasingCard;
    }

    public String getPharmacyTown() {
        return PharmacyTown;
    }

    public void setPharmacyTown(String pharmacyTown) {
        PharmacyTown = pharmacyTown;
        System.out.println("Town :" + pharmacyTown);
    }

    public boolean isInsuranceCompanyContract() {
        return InsuranceCompanyContract;
    }

    public void setInsuranceCompanyContract(boolean insuranceCompanyContract) {
        InsuranceCompanyContract = insuranceCompanyContract;
        if (insuranceCompanyContract == true) {
            System.out.println("Contract with the insurance company");
        } else {
            System.out.println("Contract without an insurance company");
        }
    }



    public void setAcceptCardPayment(boolean acceptCardPayment) {
        this.acceptCardPayment = acceptCardPayment;
        if (acceptCardPayment == true) {
            System.out.println("Accepting card payment");
        } else {
            System.out.println("The pharmacy does not accept payment by card");
        }
    }

    public boolean isAcceptCardPayment() {
        return acceptCardPayment;
    }

    public int getProgramPharmacy() {

        return programPharmacy;
    }

    public void setProgramPharmacy(int programPharmacy) {
        this.programPharmacy = programPharmacy;
        if (programPharmacy == 1) {
            System.out.println("The pharmacy schedule is :"+" "+"Non-Stop");
        } else if (programPharmacy == 2) {
            System.out.println("The pharmacy schedule is : "+"Monday-Friday : 8:00-16:00"+" "+"Saturday -Sunday : 9:00-13:00");
        } else if (programPharmacy == 3) {
            System.out.println("The pharmacy schedule is : "+" "+"Monday-Saturday : 9:00-18:00");
        } else
            System.out.println("There is no chosen option, the options are from 1 to 3");
    }

    public String getPhoneNumberPharmacy() {
        return phoneNumberPharmacy;
    }

    public boolean checkHasOnlyDigits(String value) {
        boolean check = true;
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                check = false;
            }

        }
        return check;
    }

    public void setPhoneNumberPharmacy(String phoneNumberPharmacy) {
        if (checkHasOnlyDigits(phoneNumberPharmacy) && phoneNumberPharmacy.length() == 10) {
            this.phoneNumberPharmacy = phoneNumberPharmacy.substring(0, 3)
                    + "-"
                    + phoneNumberPharmacy.substring(3, 6)
                    + "-"
                    + phoneNumberPharmacy.substring(6);
            System.out.println("Phone number :" + phoneNumberPharmacy);
        } else {
            System.out.println("The number is not valid");
        }
    }

    public String getEmailPharmacy() {
        return emailPharmacy;
    }

    public void setEmailPharmacy(String emailPharmacy) {
        this.emailPharmacy = emailPharmacy;
        System.out.println("Email : " + emailPharmacy);
    }

    public int getPharmacyType() {
        return pharmacyType;
    }

    public void setPharmacyType(int pharmacyType) {
        this.pharmacyType = pharmacyType;
        if (pharmacyType == 1) {
            System.out.println("Pharmacy type : Online");
        } else if (pharmacyType == 2) {
            System.out.println("Pharmacy type : In-store");
        } else if (pharmacyType == 3) {
            System.out.println("Pharmacy type : Hibryd");
        } else
            System.out.println("There is no chosen option, the options are from 1 to 3");
    }

    public Set<Drugs> getMedicineStock() {
        return medicineStock;
    }

    public void setMedicineStock(Set<Drugs> medicineStock) {
        this.medicineStock = medicineStock;
    }

    public void placeOrder(List<Drugs> orderList, boolean discountWithPurchasingCard) {

        for (int i = 0; i < orderList.size(); i++) {
            for (Drugs element : medicineStock) {
                if (orderList.get(i).getDrugName().equals(element.getDrugName())) {
                    if (orderList.get(i).getQuantity() <= element.getQuantity() && discountWithPurchasingCard) {
                        element.setDrugPrice(element.getDrugPrice() * 0.9);
                        element.setQuantity(element.getQuantity() - orderList.get(i).getQuantity());

                        System.out.println(element);
                    } else if (orderList.get(i).getQuantity() <= element.getQuantity() && !discountWithPurchasingCard) {
                        element.setQuantity(element.getQuantity() - orderList.get(i).getQuantity());
                        System.out.println(element);
                    } else if (orderList.get(i).getQuantity() > element.getQuantity()) {
                        System.out.println(element.getDrugName() + " is out of stock ");
                    }
                }
            }

        }
    }


    public void addMedicine(List<Drugs> medicineList) {
        for (int i = 0; i < medicineList.size(); i++) {
            for (Drugs currentElement : medicineStock) {
                if (medicineList.get(i).getDrugName().equalsIgnoreCase(currentElement.getDrugName())) {
                    currentElement.setQuantity(currentElement.getQuantity() + medicineList.get(i).getQuantity());
                    medicineList.remove(medicineList.get(i));
                }
            }
        }
        medicineStock.addAll(medicineList);
    }

    public int totalStockOfMedicine() {
        int result = 0;
        for (Drugs element : medicineStock) {
            result += element.getQuantity();
        }
        return result;
    }


    public void verifyIfMedicineIsExpired() {
        List<Drugs> toRemove = new ArrayList<>();
        for (Drugs element : this.medicineStock) {
            if (!element.verifyExpirationDate()) {
                toRemove.add(element);

                System.out.println(medicineStock);
            }
        }
        System.out.println(medicineStock);
        System.out.println(toRemove);
        medicineStock.removeAll(toRemove);

    }


}


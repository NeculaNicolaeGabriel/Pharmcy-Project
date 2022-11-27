import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Drugs {
    private String drugName;
    private double drugPrice;

    private int unitOfMeasure;
    private String manufacturingCompany;
    private String settlementType;
    private double medicinePrice;
    private boolean requiresPrescription;
    private String expirationDate;
    private int quantity;

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";


    public Drugs(String drugName, double drugPrice, int quantity, String manufacturingCompany,
                 String settlementType, boolean requiresPrescription, String expirationDate) {
        this.drugName = drugName;
        this.drugPrice = drugPrice;
        this.quantity= quantity;
        this.manufacturingCompany = manufacturingCompany;
        this.settlementType = settlementType;
        this.medicinePrice = medicinePrice;
        this.requiresPrescription = requiresPrescription;
        this.expirationDate = expirationDate;

    }

    public Drugs(String drugName, int quantity) {
        this.drugName = drugName;
        this.quantity = quantity;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }

    public int getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public String setUnitOfMeasure(int unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
        if (unitOfMeasure == 1) {
            return "Tablets";
        } else if (unitOfMeasure == 2) {
            return "Syrup";
        } else if (unitOfMeasure == 3) {
            return "Vial";
        } else
            System.out.println("This option is not valid, please choose 1, 2 or 3");
        return "";
    }

    public String getManufacturingCompany() {
        return manufacturingCompany;
    }

    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany;
    }

    public void getSettlementType(String settlementType) {
        if (settlementType.equals("100")) {
            this.medicinePrice = 0.00;
            System.out.println("Total state settlement");
        } else if (settlementType.equals("50")) {
            this.medicinePrice = medicinePrice * 0.5;
            System.out.println("Partial state settlement");
        } else if (settlementType.equals("0")) {
            System.out.println("Fully paid by customer");
        } else {
            System.out.println("This option is not valid, please choose 0, 50 or 100");
        }
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    public boolean isRequiresPrescription() {
        return requiresPrescription;
    }

    public void setRequiresPrescription(boolean requiresPrescription) {
        this.requiresPrescription = requiresPrescription;
    }


    public boolean  verifyExpirationDate() {
        this.expirationDate = expirationDate;
        DateTimeFormatter dF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();

        if (dF.format(today).compareTo(String.valueOf(this.expirationDate)) < 0 &&
                dF.format(today).compareTo(String.valueOf(this.expirationDate)) != 0) {
            System.out.println(ANSI_BLUE + "The medicine "+drugName +" is within the validity period, " +
                    "the date is : "+expirationDate);
            return true;

        } else {
            System.out.println("The medicine"+ drugName+" is not within the validity period, " +
                    "expired on the date of : "+expirationDate+ANSI_RESET);
            return false;
        }

    }

    @Override
    public String toString() {
        return String.format(
                "\nName :"+drugName +"---Price : " + drugPrice + "---Quantity : " + quantity+"\nCompany " + manufacturingCompany+" " +
                        "---Requires prescription : " + requiresPrescription + "---Expiration date : " + expirationDate+"\n");

    }
}

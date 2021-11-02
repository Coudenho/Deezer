import java.util.Scanner;

public class Ad {
   private String advertiser;
    private String length;
    private double commercialPrice;

    public Ad(String advertiser, String length, double commercialPrice) {
        this.advertiser = advertiser;
        this.length = length;
        this.commercialPrice = commercialPrice;
    }

    public String getLength() {
        return length;
    }

    public double getCommercialPrice() {
        return commercialPrice;
    }

    public String getAdvertiser() {
        return advertiser;
    }

    @Override
    public String toString(){
        String temp = "";
        temp += this.advertiser + "; " + this.length + "; " + this.commercialPrice + " euros";
        return temp;
    }


    public static Ad read(Scanner scanner){
        String advertiser = "";
        String length = "";
        double commercialPrice = 0;
        while (scanner.hasNextLine()){
            Scanner temp = new Scanner(scanner.nextLine());
            temp.useDelimiter("; ");
            advertiser = temp.next();
            length = temp.next();
            commercialPrice = Double.parseDouble(temp.next().split(" ")[0]);
        }
        return new Ad(advertiser, length, commercialPrice);
    }
}

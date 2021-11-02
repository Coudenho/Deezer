import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdList{
    private List<Ad> adList;

    public AdList(List<Ad> adList) {
        this.adList = adList;
    }

    public List<Ad> getAdList() {
        return adList;
    }

    @Override
    public String toString(){
        String temp = "";
        for (Ad ad: adList){
            temp += ad.toString() + "\n";

        }
        return temp;
    }
    public void addAd(Ad ad){
        adList.add(ad);
    }
    public static AdList readAdList(Scanner scanner){
        List<Ad> e = new ArrayList<>();

        while (scanner.hasNextLine()){
            String temp = scanner.nextLine();
            if (temp.startsWith("ADS")){
                scanner.useDelimiter("AD ");

                while (scanner.hasNext()){
                    e.add(Ad.read(new Scanner(scanner.next())));
                }
            }
        }

        return new AdList(e);
    }
}

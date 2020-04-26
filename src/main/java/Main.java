import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Paweł Matyaszczyk
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        List<RealEstate> realEstates = parser.readFile();
        Map<String,List<RealEstate>> mapRealEstates;
        Map<String,Integer> numberHousesPerCity;
        mapRealEstates = parser.groupByCity(realEstates);
        numberHousesPerCity = parser.countByCity(realEstates);
    }
}

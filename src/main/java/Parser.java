import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Paweł Matyaszczyk
 */
public class Parser {
    /*
    private String street;
    private String city;
    private Integer zip;
    private String state;
    private Integer beds;
    private Integer baths;
    private Integer sq__ft;
    private String type;
    private String sale_date;
    private Integer price;
    private Double latitude;
    private Double longitude;
    */
    private Path file = Paths.get("file.csv");

    public List<RealEstate> readFile() throws IOException {
        List<RealEstate> realEstateList = new ArrayList<>();

        byte[] data = Files.readAllBytes(file);
        String convertData = new String(data);
        String[] dataArray = convertData.split("\\r");
        List<String> dataList = new ArrayList<>(Arrays.asList(dataArray));
        dataList.remove(0);
        for (String line: dataList) {
            String[] l = line.split(",");
            RealEstate realEstate = new RealEstate();
            realEstate.setStreet(l[0]);
            realEstate.setCity(l[1]);
            realEstate.setZip(Integer.parseInt(l[2]));
            realEstate.setState(l[3]);
            realEstate.setBeds(Integer.parseInt(l[4]));
            realEstate.setBaths(Integer.parseInt(l[5]));
            realEstate.setSq__ft(Integer.parseInt(l[6]));
            realEstate.setType(l[7]);
            realEstate.setSale_date(l[8]);
            realEstate.setPrice(Integer.parseInt(l[9]));
            realEstate.setLatitude(Double.parseDouble(l[10]));
            realEstate.setLongitude(Double.parseDouble(l[11]));
            realEstateList.add(realEstate);
        }

        return realEstateList;
    }

    public Map<String, List<RealEstate>> groupByCity(List<RealEstate> realEstates){
        Map<String, List<RealEstate>> map = new HashMap<>();
        for(RealEstate realEstate : realEstates){
            if( map.containsKey(realEstate.getCity())){
                List<RealEstate> list;
                list = map.get(realEstate.getCity());
                list.add(realEstate);
                map.put(realEstate.getCity(), list);
            } else {
                List<RealEstate> list = new ArrayList<>();
                list.add(realEstate);
                map.put(realEstate.getCity(), list);
            }
        }
        return map;

    }

    public Map<String,Integer> countByCity(List<RealEstate> realEstates) {
        Map<String,Integer> cityMap = new HashMap<>();
        for (RealEstate house:realEstates) {
            if (cityMap.containsKey(house.getCity())) {
                cityMap.put(house.getCity(),cityMap.get(house.getCity())+1);
            }
            else {
                cityMap.put(house.getCity(),1);
            }

        }

        return cityMap;
    }

}

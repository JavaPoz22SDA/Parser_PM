import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Paweł Matyaszczyk
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        List<RealEstate> realEstates = new ArrayList<>();
        realEstates = parser.readFile();
    }
}

import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by Siarhei Bolka on 4/25/2015.
 */
public class ReaderTest {

    @Test(enabled=true, groups="reader", dependsOnGroups="checker")
    public void readAllTest() {

        String testFile = "test_catalog.txt";

        TxtFileReader reader = new TxtFileReader(testFile);

        Assert.assertEquals(reader.readAll().get(0).getInfo(),
                        new Cruise(3, "Cruise", "Breakfast", "Azura", 30,(double) 550000,
                        Arrays.asList("Hawaii, Caribbean, Bahamas")).getInfo(),
                        "readAllTest failed: Cruises are not equals");

        Assert.assertEquals(reader.readAll().get(1).getInfo(),
                        new Shopping(1, "Shopping", "Tea", "Train", 3,(double) 700000,
                        "Ukraine", "N").getInfo(),
                        "readAllTest failed: Shoppings are not equals");

        Assert.assertEquals(reader.readAll().get(2).getInfo(),
                        new Excursion(5, "Excursion", "No_food", "Car", 3, (double) 600000,
                        "France", Arrays.asList("Eiffel Tower, Louvre")).getInfo(),
                        "readAllTest failed: Excursions are not equals");

    }
}

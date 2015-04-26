import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import com.epam.cdp.byta2015.tourist.services.Sorter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Siarhei Bolka on 4/25/2015.
 */
public class SorterTest {
/*
    @DataProvider(name = "sortData")
    public Object[][] findByData() {

        List<BaseTour> listOfTestTours = new ArrayList<>();

        listOfTestTours.add(new Cruise(3, "Cruise", "Breakfast", "Azura", 30, (double) 550000, Arrays.asList("Hawaii,Caribbean,Bahamas")));
        listOfTestTours.add(new Shopping(1, "Shopping", "Tea", "Train", 3, (double) 70000, "Ukraine", "N"));
        listOfTestTours.add(new Excursion(5, "Excursion", "No_food", "Car", 3, (double) 400000, "France", Arrays.asList("Eiffel Tower,Louvre")));

        return new Object[][]{new Object[]{listOfTestTours}};
    }*/

/*    @Test
    public static void sortByDescTypeTest() {

        String testFile = "test_catalog.txt";
        System.out.println("sortByDescTypeTest");
        Assert.assertEquals(Sorter.sort(1, testFile).get(0).getTypeDesc(), "Cruise");
        Assert.assertEquals(Sorter.sort(1, testFile).get(1).getTypeDesc(), "Excursion");
        Assert.assertEquals(Sorter.sort(1, testFile).get(2).getTypeDesc(), "Shopping");
    }

    @Test
    public static void sortByFoodTest() {

        String testFile = "test_catalog.txt";
        System.out.println("sortByFoodTest");
        Assert.assertEquals(Sorter.sort(1, testFile).get(0).getTypeDesc(), "Cruise");
        Assert.assertEquals(Sorter.sort(1, testFile).get(1).getTypeDesc(), "Excursion");
        Assert.assertEquals(Sorter.sort(1, testFile).get(2).getTypeDesc(), "Shopping");
    }

    @Test
    public static void sortByTransportTest() {

        String testFile = "test_catalog.txt";
        System.out.println("sortByTransportTest");
        Assert.assertEquals(Sorter.sort(1, testFile).get(0).getTypeDesc(), "Cruise");
        Assert.assertEquals(Sorter.sort(1, testFile).get(1).getTypeDesc(), "Excursion");
        Assert.assertEquals(Sorter.sort(1, testFile).get(2).getTypeDesc(), "Shopping");
    }

    @Test
    public static void sortByPriceTest() {

        String testFile = "test_catalog.txt";
        System.out.println("sortByPriceTest");
        Assert.assertEquals(Sorter.sort(1, testFile).get(0).getTypeDesc(), "Shopping");
        Assert.assertEquals(Sorter.sort(1, testFile).get(1).getTypeDesc(), "Excursion");
        Assert.assertEquals(Sorter.sort(1, testFile).get(2).getTypeDesc(), "Cruise");
    }*/
}

import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import com.epam.cdp.byta2015.tourist.services.Sorter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Siarhei Bolka on 4/25/2015.
 */
public class SorterTest {

    @Parameters({ "sortParam1" })
    @Test
    public static void sortByDescTypeTest(int sortParam) {

        String testFile = "test_catalog.txt";
        System.out.println("sortByDescTypeTest");
        Assert.assertEquals(Sorter.sort(sortParam).get(0).getTypeDesc(), "Cruise");
        Assert.assertEquals(Sorter.sort(sortParam).get(1).getTypeDesc(), "Excursion");
        Assert.assertEquals(Sorter.sort(sortParam).get(2).getTypeDesc(), "Shopping");
    }

    @Parameters({ "sortParam2" })
    @Test
    public static void sortByFoodTest(int sortParam) {

        String testFile = "test_catalog.txt";
        System.out.println("sortByFoodTest");
        Assert.assertEquals(Sorter.sort(sortParam).get(0).getTypeDesc(), "Cruise");
        Assert.assertEquals(Sorter.sort(sortParam).get(1).getTypeDesc(), "Excursion");
        Assert.assertEquals(Sorter.sort(sortParam).get(2).getTypeDesc(), "Shopping");
    }

    @Parameters({ "sortParam3" })
    @Test
    public static void sortByTransportTest(int sortParam) {

        String testFile = "test_catalog.txt";
        System.out.println("sortByTransportTest");
        Assert.assertEquals(Sorter.sort(sortParam).get(0).getTypeDesc(), "Cruise");
        Assert.assertEquals(Sorter.sort(sortParam).get(1).getTypeDesc(), "Excursion");
        Assert.assertEquals(Sorter.sort(sortParam).get(2).getTypeDesc(), "Shopping");
    }

    @Parameters({ "sortParam4" })
    @Test
    public static void sortByPriceTest(int sortParam) {

        String testFile = "test_catalog.txt";
        System.out.println("sortByPriceTest");
        Assert.assertEquals(Sorter.sort(sortParam).get(0).getTypeDesc(), "Shopping");
        Assert.assertEquals(Sorter.sort(sortParam).get(1).getTypeDesc(), "Excursion");
        Assert.assertEquals(Sorter.sort(sortParam).get(2).getTypeDesc(), "Cruise");
    }

}

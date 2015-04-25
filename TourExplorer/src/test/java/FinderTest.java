import com.epam.cdp.byta2015.tourist.exceptions.FindByFoodException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByPriceException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTransportException;
import com.epam.cdp.byta2015.tourist.exceptions.FindByTypeException;
import com.epam.cdp.byta2015.tourist.model.BaseTour;
import com.epam.cdp.byta2015.tourist.model.Cruise;
import com.epam.cdp.byta2015.tourist.model.Excursion;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import com.epam.cdp.byta2015.tourist.services.Finder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Siarhei Bolka on 4/25/2015.
 */

public class FinderTest {

    @DataProvider(name = "findByData")
    public Object[][] findByData() {

        List<BaseTour> listOfTestTours = new ArrayList<>();
        listOfTestTours.add(new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y"));
        listOfTestTours.add(new Shopping(1, "Shopping", "Tea", "Train", 3, (double) 70000, "Ukraine", "N"));
        listOfTestTours.add(new Cruise(2, "Cruise", "AI", "Aurora", 30, (double) 750000, Arrays.asList("Italy,Spain,Egipt")));
        listOfTestTours.add(new Cruise(3, "Cruise", "Breakfast", "Azura", 30, (double) 550000, Arrays.asList("Hawaii,Caribbean,Bahamas")));
        listOfTestTours.add(new Excursion(4, "Excursion", "Breakfast", "Bus", 2, (double) 350000, "Italy", Arrays.asList("Roma,Venice")));
        listOfTestTours.add(new Excursion(5, "Excursion", "No_food", "Car", 3, (double) 400000, "France", Arrays.asList("Eiffel Tower,Louvre")));

        return new Object[][]{new Object[]{listOfTestTours}};
    }

    @Test(enabled = true, dataProvider = "findByData")
    public void findByDescTypeTest(ArrayList<BaseTour> list) throws FindByTypeException {

        List<BaseTour> expectedResultList = new ArrayList<>();
        expectedResultList.add(new Cruise(2, "Cruise", "AI", "Aurora", 30, (double) 750000, Arrays.asList("Italy,Spain,Egipt")));
        expectedResultList.add(new Cruise(3, "Cruise", "Breakfast", "Azura", 30, (double) 550000, Arrays.asList("Hawaii,Caribbean,Bahamas")));

        System.out.println("findByDescTypeTest");
        Assert.assertEquals(Finder.findByDescType(list, "Cruise").size(), expectedResultList.size());
    }

    @Test(enabled = true, dataProvider = "findByData", dependsOnMethods = { "findByDescTypeTest" })
    public void findByFoodTest(ArrayList<BaseTour> list) throws FindByFoodException {

        List<BaseTour> expectedResultList = new ArrayList<>();
        expectedResultList.add(new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y"));
        expectedResultList.add(new Excursion(5, "Excursion", "No_food", "Car", 3, (double) 400000, "France", Arrays.asList("Eiffel Tower,Louvre")));

        System.out.println("findByFoodTest");
        Assert.assertEquals(Finder.findByFood(list, "No_food").size(), expectedResultList.size());
    }

    @Test(enabled = true, dataProvider = "findByData", dependsOnMethods = {"findByFoodTest"})
    public void findByTransportTest(ArrayList<BaseTour> list) throws FindByTransportException {

        List<BaseTour> expectedResultList = new ArrayList<>();
        expectedResultList.add(new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y"));
        expectedResultList.add(new Excursion(4, "Excursion", "Breakfast", "Bus", 2, (double) 350000, "Italy", Arrays.asList("Roma,Venice")));

        System.out.println("findByTransportTest");
        Assert.assertEquals(Finder.findByTransport(list, "Bus").size(), expectedResultList.size());
    }

    @Test(enabled = true, dataProvider = "findByData", dependsOnMethods = {"findByTransportTest"})
    public void findByPriceTest(ArrayList<BaseTour> list) throws FindByPriceException {

        List<BaseTour> expectedResultList = new ArrayList<>();
        expectedResultList.add(new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y"));

        System.out.println("findByPriceTest");
        Assert.assertEquals(Finder.findByPrice(list, "50000").size(), expectedResultList.size());
    }

    @Test(enabled = true, dataProvider = "findByData", dependsOnMethods = {"findByPriceTest"}, expectedExceptions = FindByPriceException.class)
    public void findByPriceExceptionTest(ArrayList<BaseTour> list) throws FindByPriceException {

        List<BaseTour> expectedResultList = new ArrayList<>();
        expectedResultList.add(new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y"));
        //expectedResultList.add(new Excursion(4, "Excursion", "Breakfast", "Bus", 2, (double) 350000, "Italy", Arrays.asList("Roma,Venice")));

        System.out.println("findByPriceExceptionTest");
        Assert.assertEquals(Finder.findByPrice(list, "777").size(), expectedResultList.size());
    }

}

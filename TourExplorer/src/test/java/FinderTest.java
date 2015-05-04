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
        listOfTestTours.add(new Shopping
                (0, "Shopping", "No_food", "Bus", 2, (double) 50000,"Poland", "Y"));
        listOfTestTours.add(new Shopping
                (1, "Shopping", "Tea", "Train", 3, (double) 700000,"Ukraine", "N"));
        listOfTestTours.add(new Cruise
                (2, "Cruise", "AI", "Aurora", 30, (double) 750000,Arrays.asList("Italy,Spain,Egipt")));
        listOfTestTours.add(new Cruise
                (3, "Cruise", "Breakfast", "Azura", 30, (double) 550000,Arrays.asList("Hawaii,Caribbean,Bahamas")));
        listOfTestTours.add(new Excursion
                (4, "Excursion", "Breakfast", "Bus", 2, (double) 350000,"Italy", Arrays.asList("Roma,Venice")));
        listOfTestTours.add(new Excursion
                (5, "Excursion", "No_food", "Car", 3, (double) 600000,"France", Arrays.asList("Eiffel Tower,Louvre")));

        return new Object[][]{new Object[]{listOfTestTours}};
    }

    @Test(enabled = true, dataProvider = "findByData", groups="finder", dependsOnGroups="reader")
    public void findByDescTypeTest(ArrayList<BaseTour> list) throws FindByTypeException {

        List<BaseTour> testList = Finder.findByDescType(list, "Cruise");

        List<BaseTour> expectedResultList = new ArrayList<>();

        expectedResultList.add(new Cruise
                (2, "Cruise", "AI", "Aurora", 30, (double) 750000, Arrays.asList("Italy,Spain,Egipt")));
        expectedResultList.add(new Cruise
                (3, "Cruise", "Breakfast", "Azura", 30, (double) 550000, Arrays.asList("Hawaii,Caribbean,Bahamas")));

        for (int i = 0; i < expectedResultList.size() ; i++) {
            Cruise cruise = (Cruise) testList.get(i);


            Assert.assertEquals(cruise.getId(), expectedResultList.get(i).getId(),
                                "findByDescType: IDs are not equals");
            Assert.assertEquals(cruise.getTypeDesc(), expectedResultList.get(i).getTypeDesc(),
                                "findByDescType: TypeDescs are not equals");
            Assert.assertEquals(cruise.getFood(), expectedResultList.get(i).getFood(),
                                "findByDescType: Foods are not equals");
            Assert.assertEquals(cruise.getTransport(), expectedResultList.get(i).getTransport(),
                                "findByDescType: Transports are not equals");
            Assert.assertEquals(cruise.getDuration(), expectedResultList.get(i).getDuration(),
                                "findByDescType: Durations are not equals");
            Assert.assertEquals(cruise.getPrice(), expectedResultList.get(i).getPrice(),
                                "findByDescType: Prices are not equals");
            Assert.assertEquals(cruise.getCountries(), ((Cruise) expectedResultList.get(i)).getCountries(),
                                "findByDescType: Countries lists are not equals");
        }

    }

    @Test(enabled = true, dataProvider = "findByData", groups="finder", dependsOnGroups="reader")
    public void findByFoodTest(ArrayList<BaseTour> list) throws FindByFoodException {

        List<BaseTour> testList = Finder.findByFood(list, "No_food");
        Shopping shopping = (Shopping) testList.get(0);
        Excursion excursion = (Excursion) testList.get(1);

        List<BaseTour> expectedResultList = new ArrayList<>();
        expectedResultList.add(new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000,
                                            "Poland", "Y"));
        expectedResultList.add(new Excursion(5, "Excursion", "No_food", "Car", 3, (double) 600000,
                "France", Arrays.asList("Eiffel Tower,Louvre")));


        Assert.assertEquals(shopping.getId(), expectedResultList.get(0).getId(),
                "findByDescType: IDs are not equals");
        Assert.assertEquals(shopping.getTypeDesc(), expectedResultList.get(0).getTypeDesc(),
                "findByDescType: TypeDescs are not equals");
        Assert.assertEquals(shopping.getFood(), expectedResultList.get(0).getFood(),
                "findByDescType: Foods are not equals");
        Assert.assertEquals(shopping.getTransport(), expectedResultList.get(0).getTransport(),
                "findByDescType: Transports are not equals");
        Assert.assertEquals(shopping.getDuration(), expectedResultList.get(0).getDuration(),
                "findByDescType: Durations are not equals");
        Assert.assertEquals(shopping.getPrice(), expectedResultList.get(0).getPrice(),
                "findByDescType: Prices are not equals");
        Assert.assertEquals(shopping.getCountry(), ((Shopping) expectedResultList.get(0)).getCountry(),
                "findByDescType: Countries are not equals");
        Assert.assertEquals(shopping.getNightTransfer(), ((Shopping) expectedResultList.get(0)).getNightTransfer(),
                "findByDescType: NightTransfers are not equals");


        Assert.assertEquals(excursion.getId(), expectedResultList.get(1).getId(),
                "findByDescType: IDs are not equals");
        Assert.assertEquals(excursion.getTypeDesc(), expectedResultList.get(1).getTypeDesc(),
                "findByDescType: TypeDescs are not equals");
        Assert.assertEquals(excursion.getFood(), expectedResultList.get(1).getFood(),
                "findByDescType: Foods are not equals");
        Assert.assertEquals(excursion.getTransport(), expectedResultList.get(1).getTransport(),
                "findByDescType: Transports are not equals");
        Assert.assertEquals(excursion.getDuration(), expectedResultList.get(1).getDuration(),
                "findByDescType: Durations are not equals");
        Assert.assertEquals(excursion.getPrice(), expectedResultList.get(1).getPrice(),
                "findByDescType: Prices are not equals");
        Assert.assertEquals(excursion.getCountry(), ((Excursion) expectedResultList.get(1)).getCountry(),
                "findByDescType: Countries are not equals");
        Assert.assertEquals(excursion.getDestination(), ((Excursion) expectedResultList.get(1)).getDestination(),
                "findByDescType: NightTransfers are not equals");
    }

    @Test(enabled = true, dataProvider = "findByData", groups="finder", dependsOnGroups="reader")
    public void findByTransportTest(ArrayList<BaseTour> list) throws FindByTransportException {

        List<BaseTour> testList = Finder.findByTransport(list, "Bus");
        Shopping shopping = (Shopping) testList.get(0);
        Excursion excursion = (Excursion) testList.get(1);

        List<BaseTour> expectedResultList = new ArrayList<>();
        expectedResultList.add(new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000,
                                            "Poland", "Y"));
        expectedResultList.add(new Excursion(4, "Excursion", "Breakfast", "Bus", 2, (double) 350000,
                "Italy", Arrays.asList("Roma,Venice")));


        Assert.assertEquals(shopping.getId(), expectedResultList.get(0).getId(),
                "findByDescType: IDs are not equals");
        Assert.assertEquals(shopping.getTypeDesc(), expectedResultList.get(0).getTypeDesc(),
                "findByDescType: TypeDescs are not equals");
        Assert.assertEquals(shopping.getFood(), expectedResultList.get(0).getFood(),
                "findByDescType: Foods are not equals");
        Assert.assertEquals(shopping.getTransport(), expectedResultList.get(0).getTransport(),
                "findByDescType: Transports are not equals");
        Assert.assertEquals(shopping.getDuration(), expectedResultList.get(0).getDuration(),
                "findByDescType: Durations are not equals");
        Assert.assertEquals(shopping.getPrice(), expectedResultList.get(0).getPrice(),
                "findByDescType: Prices are not equals");
        Assert.assertEquals(shopping.getCountry(), ((Shopping) expectedResultList.get(0)).getCountry(),
                "findByDescType: Countries are not equals");
        Assert.assertEquals(shopping.getNightTransfer(), ((Shopping) expectedResultList.get(0)).getNightTransfer(),
                "findByDescType: NightTransfers are not equals");


        Assert.assertEquals(excursion.getId(), expectedResultList.get(1).getId(),
                "findByDescType: IDs are not equals");
        Assert.assertEquals(excursion.getTypeDesc(), expectedResultList.get(1).getTypeDesc(),
                "findByDescType: TypeDescs are not equals");
        Assert.assertEquals(excursion.getFood(), expectedResultList.get(1).getFood(),
                "findByDescType: Foods are not equals");
        Assert.assertEquals(excursion.getTransport(), expectedResultList.get(1).getTransport(),
                "findByDescType: Transports are not equals");
        Assert.assertEquals(excursion.getDuration(), expectedResultList.get(1).getDuration(),
                "findByDescType: Durations are not equals");
        Assert.assertEquals(excursion.getPrice(), expectedResultList.get(1).getPrice(),
                "findByDescType: Prices are not equals");
        Assert.assertEquals(excursion.getCountry(), ((Excursion) expectedResultList.get(1)).getCountry(),
                "findByDescType: Countries are not equals");
        Assert.assertEquals(excursion.getDestination(), ((Excursion) expectedResultList.get(1)).getDestination(),
                "findByDescType: NightTransfers are not equals");
    }

    @Test(enabled = true, dataProvider = "findByData", groups="finder", dependsOnGroups="reader")
    public void findByPriceTest(ArrayList<BaseTour> list) throws FindByPriceException {

        List<BaseTour> testList = Finder.findByPrice(list, "50000");
        Shopping shopping = (Shopping) testList.get(0);

        List<BaseTour> expectedResultList = new ArrayList<>();
        expectedResultList.add(new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000,
                "Poland", "Y"));


        Assert.assertEquals(shopping.getId(), expectedResultList.get(0).getId(),
                "findByDescType: IDs are not equals");
        Assert.assertEquals(shopping.getTypeDesc(), expectedResultList.get(0).getTypeDesc(),
                "findByDescType: TypeDescs are not equals");
        Assert.assertEquals(shopping.getFood(), expectedResultList.get(0).getFood(),
                "findByDescType: Foods are not equals");
        Assert.assertEquals(shopping.getTransport(), expectedResultList.get(0).getTransport(),
                "findByDescType: Transports are not equals");
        Assert.assertEquals(shopping.getDuration(), expectedResultList.get(0).getDuration(),
                "findByDescType: Durations are not equals");
        Assert.assertEquals(shopping.getPrice(), expectedResultList.get(0).getPrice(),
                "findByDescType: Prices are not equals");
        Assert.assertEquals(shopping.getCountry(), ((Shopping) expectedResultList.get(0)).getCountry(),
                "findByDescType: Countries are not equals");
        Assert.assertEquals(shopping.getNightTransfer(), ((Shopping) expectedResultList.get(0)).getNightTransfer(),
                "findByDescType: NightTransfers are not equals");
    }

    @Test(enabled = true, dataProvider = "findByData", expectedExceptions = FindByPriceException.class,
            groups="finder", dependsOnGroups="reader")
    public void findByPriceExceptionTest(ArrayList<BaseTour> list) throws FindByPriceException {

        List<BaseTour> testList = Finder.findByPrice(list, "777");

        Assert.assertEquals(testList.size(),0, "Exception doesn't appear");
    }

    @Test(enabled = true, dataProvider = "findByData", groups="finder", dependsOnGroups="reader")
    public void findTours(ArrayList<BaseTour> list) {

        String[] paramaters = new String[4];
        paramaters[0] = "Shopping";
        paramaters[1] = "Tea";
        paramaters[2] = "Train";
        paramaters[3] = "700000";

        List<BaseTour> testList = Finder.findTours(paramaters);
        Shopping shopping = (Shopping) testList.get(0);

        List<BaseTour> expectedResultList = new ArrayList<>();
        expectedResultList.add(new Shopping(1, "Shopping", "Tea", "Train", 3, (double) 700000, "Ukraine", "N"));

        Assert.assertEquals(shopping.getId(), expectedResultList.get(0).getId(),
                "findByDescType: IDs are not equals");
        Assert.assertEquals(shopping.getTypeDesc(), expectedResultList.get(0).getTypeDesc(),
                "findByDescType: TypeDescs are not equals");
        Assert.assertEquals(shopping.getFood(), expectedResultList.get(0).getFood(),
                "findByDescType: Foods are not equals");
        Assert.assertEquals(shopping.getTransport(), expectedResultList.get(0).getTransport(),
                "findByDescType: Transports are not equals");
        Assert.assertEquals(shopping.getDuration(), expectedResultList.get(0).getDuration(),
                "findByDescType: Durations are not equals");
        Assert.assertEquals(shopping.getPrice(), expectedResultList.get(0).getPrice(),
                "findByDescType: Prices are not equals");
        Assert.assertEquals(shopping.getCountry(), ((Shopping) expectedResultList.get(0)).getCountry(),
                "findByDescType: Countries are not equals");
        Assert.assertEquals(shopping.getNightTransfer(), ((Shopping) expectedResultList.get(0)).getNightTransfer(),
                "findByDescType: NightTransfers are not equals");

    }
}

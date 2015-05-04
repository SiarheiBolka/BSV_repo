import com.epam.cdp.byta2015.tourist.datareaders.Reader;
import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
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

    @Test
    @Parameters({ "sortParam" })
    public static void sortByTest(int sortParam) {

        String testFile = "test_catalog.txt";
        Reader reader = new TxtFileReader(testFile);

        String[] toursDescList = {"Cruise", "Excursion", "Shopping"};

        List<BaseTour> baseTours = reader.readAll();

        List<BaseTour> sortedBaseTours = Sorter.sort(baseTours, sortParam);

        for (int i = 0; i < baseTours.size(); i++) {

            Assert.assertEquals(sortedBaseTours.get(i).getTypeDesc(), toursDescList[i],
                    "Incorrect first item in list after sorting by " + sortParam + "sortedBaseTours param");
        }

    }

}


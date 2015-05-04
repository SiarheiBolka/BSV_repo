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

    @Parameters({ "sortParam" })
    @Test (enabled = true, groups="sorter", dependsOnGroups="reader")
    public static void sortByTest(int sortParam) {

        String testFile = "test_catalog.txt";

        Assert.assertEquals(Sorter.sort(sortParam).get(0).getTypeDesc(), "Cruise",
                "Incorrect first item in list after sorting by " + sortParam + "sort param");

        Assert.assertEquals(Sorter.sort(sortParam).get(1).getTypeDesc(), "Excursion",
                "Incorrect second item in list after sorting by " + sortParam + "sort param");

        Assert.assertEquals(Sorter.sort(sortParam).get(2).getTypeDesc(), "Shopping",
                "Incorrect third item in list after sorting by " + sortParam + "sort param");
    }

}

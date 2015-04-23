import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import com.epam.cdp.byta2015.tourist.services.Sorter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

/**
 * Created by Siarhei_Bolka on 4/23/2015.
 */
public class ServicesTest {

    @Test(enabled=true)
    public void readAllTest() {
        TxtFileReader reader = new TxtFileReader();
        Assert.assertEquals(reader.readAll().get(0).getInfo(), new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y").getInfo(), "readAllTest");
    }

    @Test
    public void COMPARE_BY_DESC_TYPE_Test() {
        Assert.assertEquals(Sorter.COMPARE_BY_DESC_TYPE.compare(
                new Shopping(0, "1Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y"),
                new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y")), 0, "COMPARE_BY_DESC_TYPE_Test");
        /*Assert.assertEquals(1, Sorter.COMPARE_BY_DESC_TYPE.compare(
                        new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y"),
                        new Shopping(1, "Shopping", "Tea", "Train", 3, (double) 70000, "Ukraine", "N")));*/
    }

}

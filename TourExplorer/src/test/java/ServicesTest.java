import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import com.epam.cdp.byta2015.tourist.services.FileChecker;
import com.epam.cdp.byta2015.tourist.services.Sorter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Comparator;

import static com.epam.cdp.byta2015.tourist.services.FileChecker.*;

/**
 * Created by Siarhei_Bolka on 4/23/2015.
 */
public class ServicesTest {

    @Test(enabled=true)
    public void readAllTest() {
        TxtFileReader reader = new TxtFileReader();
        Assert.assertEquals(reader.readAll().get(0).getInfo(), new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y").getInfo(), "readAllTest");
    }

    @Test (enabled=true)
    public void COMPARE_BY_DESC_TYPE_Test() {
        Assert.assertEquals(Sorter.COMPARE_BY_DESC_TYPE.compare(
                new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y"),
                new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y")), 0, "COMPARE_BY_DESC_TYPE_Test");
    }


    @Test (enabled=true, expectedExceptions = IndexOutOfBoundsException.class)
    public void readAllExceptionTest() {

        TxtFileReader reader = new TxtFileReader();
        reader.readAll();

    }


}

import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import com.epam.cdp.byta2015.tourist.services.FileChecker;
import com.epam.cdp.byta2015.tourist.services.Sorter;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by Siarhei_Bolka on 4/23/2015.
 */
public class FileCheckerTest {

    @Test(enabled=false)
    public void readAllTest() {
        System.out.println("readAllTest");
        TxtFileReader reader = new TxtFileReader();
        Assert.assertEquals(reader.readAll().get(0).getInfo(), new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y").getInfo(), "readAllTest");
    }

    @Test (enabled=false)
    public void COMPARE_BY_DESC_TYPE_Test() {
        System.out.println("COMPARE_BY_DESC_TYPE_Test");
        Assert.assertEquals(Sorter.COMPARE_BY_DESC_TYPE.compare(
                new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y"),
                new Shopping(0, "Shopping", "No_food", "Bus", 2, (double) 50000, "Poland", "Y")), 0, "COMPARE_BY_DESC_TYPE_Test");
    }

    @Test (enabled=false, expectedExceptions = IndexOutOfBoundsException.class)
    public void readAllExceptionTest() {
        System.out.println("readAllExceptionTest");
        TxtFileReader reader = new TxtFileReader();
        reader.readAll();

    }


}

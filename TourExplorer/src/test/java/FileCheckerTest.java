import com.epam.cdp.byta2015.tourist.datareaders.TxtFileReader;
import com.epam.cdp.byta2015.tourist.model.Shopping;
import com.epam.cdp.byta2015.tourist.services.FileChecker;
import com.epam.cdp.byta2015.tourist.services.Sorter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


/**
 * Created by Siarhei_Bolka on 4/23/2015.
 */
public class FileCheckerTest {

    @Test(enabled = true)
    public static void checkFileTest(){

        System.out.println("checkFileTest");
        String fileName = "new_test_catalog.txt";

        FileChecker.checkFile("new_test_catalog.txt");

        File myDir = new File (".");
        File txtFile = new File (myDir, fileName);

        Assert.assertEquals(true, txtFile.exists());

        try {
            txtFile.delete();
        } catch (Exception e){
            System.out.println("Warning: File is not deleted!");
        }

    }

/*

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

    }*/


}

import com.epam.cdp.byta2015.tourist.services.FileChecker;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;


/**
 * Created by Siarhei_Bolka on 4/23/2015.
 */
public class FileCheckerTest {

    @Test
    @BeforeSuite
    public static void prepareFileTest(){



        String notExistingTxtFileName = "new_test_catalog.txt";
        String existingTxtFileName = "test_catalog.txt";

        FileChecker.prepareFile("new_test_catalog.txt");

        File myDir = new File (".");
        File notExistingTxtFile = new File (myDir, notExistingTxtFileName);

        //Check that new file is created if original file doesn't exist
        Assert.assertEquals(true, notExistingTxtFile.exists(), "Txt file is not created");

        try {
            notExistingTxtFile.delete();
        } catch (Exception e){
            System.out.println("Warning: File is not deleted!");
        }

        File existingTxtFile = new File (myDir, existingTxtFileName);
        String checkSumOfOriginalFile = null;

        try {
            checkSumOfOriginalFile = getMD5Checksum(existingTxtFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        FileChecker.prepareFile(existingTxtFileName);

        String checkSumOfFileAfterCheck = null;
        try {
            checkSumOfFileAfterCheck = getMD5Checksum(existingTxtFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Check that original file is not deleted
        Assert.assertEquals(true, existingTxtFile.exists(), "Original txt file doesn't exist");

        //Check that original file has correct checksum
        Assert.assertEquals(checkSumOfFileAfterCheck, checkSumOfOriginalFile, "Txt file is changed");
    }

    public static byte[] createChecksum(String filename) throws Exception {
        InputStream fis =  new FileInputStream(filename);

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");
        int numRead;

        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);

        fis.close();
        return complete.digest();
    }

    public static String getMD5Checksum(String filename) throws Exception {
        byte[] b = createChecksum(filename);
        String result = "";

        for (int i=0; i < b.length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }
}


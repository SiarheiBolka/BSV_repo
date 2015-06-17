import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;
import utils.Config;
import utils.PropertyFileReader;
import utils.Config;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Siarhei Bolka on 5/6/2015.
 */

public class TestRunner {

    public static void main(String[] args) {

        TestNG testng = new TestNG();
        try {
            for (XmlSuite suite: new Parser("./" + args[0] + "").parseToList()) {
                testng.setCommandLineSuite(suite);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        testng.run();
    }
}

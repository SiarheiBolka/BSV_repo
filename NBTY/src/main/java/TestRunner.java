import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Siarhei Bolka on 5/6/2015.
 */

public class TestRunner {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        TestNG testng = new TestNG();
        for (XmlSuite suite: new Parser("./" + args[0] + "").parseToList()) {
            testng.setCommandLineSuite(suite);
        }

        testng.run();
    }
}

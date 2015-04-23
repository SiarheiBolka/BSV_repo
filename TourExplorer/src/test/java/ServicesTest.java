import org.testng.annotations.Test;

/**
 * Created by Siarhei_Bolka on 4/23/2015.
 */
public class ServicesTest {

    @Test(threadPoolSize = 5, invocationCount = 22, invocationTimeOut = 10000, enabled=true )
    public void firstTest() {
        System.out.println("Thread: " +Thread.currentThread().getId() );
    }

    @Test(enabled=true)
    public void secondtTest() {
    }

    @Test(enabled=true)
    public void thirdTest() {
    }

    @Test(enabled=true)
    public void fourthTest() {
    }

    @Test(enabled=true)
    public void fifthTest() {
    }
}

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestOne {

    @Test(enabled=false)
    public void metOne(){
        Assert.assertTrue(false);
    }
}

import org.junit.Assert;
import org.junit.Test;

public class ZooTest {
    @Test
    public void petTest() {
        Pet p = new Pet();
        p.setAge(2);
        p.setHeight(10);

        complexAssert(p);
    }

    @Test
    public void complexAssert(Pet p) {
        Assert.assertEquals(p.getAge(), 2);
        Assert.assertEquals(p.getHeight(), 10);
    }
}

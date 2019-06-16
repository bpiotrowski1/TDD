import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

public class PetTest {
    private static Pet mockedPet;

    @BeforeClass
    public static void setUp() {
        mockedPet = mock(Pet.class);
    }

    @AfterClass
    public static void cleanUp() {
        mockedPet = null;
    }

    @Test
    public void getName_mockedPet_callVerification() {
        mockedPet.getName();
        verify(mockedPet).getName();
    }

    @Test
    public void setName_mockedPet_callVerification() {
        mockedPet.setName("Fafik");
        verify(mockedPet).setName("Fafik");
    }

    @Test
    public void getHeight_mockedPet_callVerification() {
        mockedPet.getHeight();
        verify(mockedPet).getHeight();
    }
}

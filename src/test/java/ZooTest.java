import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ZooTest {
    @Test
    public void getPetNames_mockedPetWhichReturnTofikName_Tofik() {
        String expected = "Tofik";
        Pet mockedPet = mock(Pet.class);
        when(mockedPet.getName()).thenReturn("Tofik");
        Zoo zoo = new Zoo();

        zoo.giveHomelessPet(mockedPet);
        String actual = zoo.getPetNames();

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void getPetNames_mockedPetsWhichReturnsTafikAndTofik_FafikTofik() {
        String expected = "Fafik, Tofik";
        Pet mockedPet = mock(Pet.class);
        when(mockedPet.getName()).thenReturn("Fafik").thenReturn("Tofik");
        Zoo zoo = new Zoo();

        zoo.giveHomelessPet(mockedPet);
        zoo.giveHomelessPet(mockedPet);
        String actual = zoo.getPetNames();

        assertThat(expected).isEqualTo(actual);
    }
}

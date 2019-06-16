import lombok.Getter;
import lombok.Setter;

/**
 * Zwierzątko
 */
public class Pet {
    /**
     * Imię
     */
    @Getter @Setter private String name;

    /**
     * Waga
     */
    @Getter @Setter private double weight;

    /**
     * Wysokość
     */
    @Getter @Setter private double height;

    /**
     * Wiek
     */
    @Getter @Setter private int age;
}

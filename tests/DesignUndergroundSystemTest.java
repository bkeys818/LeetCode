import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Design Underground System")
class DesignUndergroundSystemTest {
    @Test
    @DisplayName("case 1")
    void case1() {
        UndergroundSystem system = new UndergroundSystem();
        system.checkIn(45,"Leyton",3);
        system.checkIn(32,"Paradise",8);
        system.checkIn(27,"Leyton",10);
        system.checkOut(45,"Waterloo",15);
        system.checkOut(27,"Waterloo",20);
        system.checkOut(32,"Cambridge",22);
        assertEquals(14.00000, system.getAverageTime("Paradise","Cambridge"));
        assertEquals(11.00000, system.getAverageTime("Leyton","Waterloo"));
        system.checkIn(10,"Leyton",24);
        assertEquals(11.00000, system.getAverageTime("Leyton","Waterloo"));
        system.checkOut(10,"Waterloo",38);
        assertEquals(12.00000, system.getAverageTime("Leyton","Waterloo"));
    }
}
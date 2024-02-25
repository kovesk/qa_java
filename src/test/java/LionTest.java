import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    private String sex;
    private boolean expectedHasMane;
    private int expectedKittens;

    public LionTest(String sex, boolean expectedHasMane, int expectedKittens) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedKittens = expectedKittens;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true,  1 },
                { "Самка", false,  1 }
        });
    }

    @Test
    public void testLionConstructor() throws Exception {
        Lion lion = new Lion(sex) {
            @Override
            public Feline getFeline() {
                return new Feline();
            }
        };
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(sex) {
            @Override
            public Feline getFeline() {
                return new Feline();
            }
        };
        assertEquals(expectedKittens, lion.getKittens());
    }

    @Test(expected = Exception.class)
    public void testExceptionOnInvalidSex() throws Exception {
        Lion lion = new Lion("Неизвестный") {
            @Override
            public Feline getFeline() {
                return new Feline();
            }
        };
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец") {
            @Override
            public Feline getFeline() {
                return new Feline();
            }
        };
        List<String> food = lion.getFood();
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }
}

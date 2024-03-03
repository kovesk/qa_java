import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {

    private Feline mockFeline;
    private Cat cat;

    @Before
    public void setUp() {
        // Создаем мок-объект Feline
        mockFeline = Mockito.mock(Feline.class);
        // Создаем экземпляр Cat с мок-объектом Feline
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        // Проверяем, что метод getSound возвращает "Мяу"
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        // Определяем поведение мок-объекта Feline
        List<String> expectedFood = Arrays.asList("Мясо", "Корм");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        // Проверяем, что метод getFood возвращает ожидаемый список еды
        assertEquals(expectedFood, cat.getFood());
    }
}


import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FelineTest {

    private Feline feline;
    private Animal animal;

    @Before
    public void setUp() {
        // Создаем мок объекта Animal
        animal = Mockito.mock(Animal.class);
        // Создаем экземпляр Feline, передавая мок в конструктор
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        // Определяем ожидаемый результат
        List<String> expectedMeatList = List.of("Животные", "Птицы", "Рыба");
        // Подменяем поведение метода getFood
        when(animal.getFood("Хищник")).thenReturn(expectedMeatList);
        // Вызываем метод eatMeat и проверяем результат
        List<String> meatList = feline.eatMeat();
        assertEquals(expectedMeatList, meatList);
    }

    @Test
    public void testGetKittens() {
        // Проверяем, что метод getKittens возвращает правильное количество котят
        assertEquals(1, feline.getKittens());
        assertEquals(5, feline.getKittens(5));
    }
    @Test
    public void testGetFamily() {
        // Создаем экземпляр класса Feline
        Feline feline = new Feline();

        // Вызываем метод getFamily
        String family = feline.getFamily();

        // Проверяем, что возвращаемое значение соответствует ожидаемому
        assertEquals("Кошачьи", family);
    }
}


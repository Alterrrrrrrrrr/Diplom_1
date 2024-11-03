import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

@Before
public void setUp() {
    bun = new Bun("orange bun", 2.55F);
}

//Проверяем получение названия булки
@Test
public void getNameTestCorrectValue() {
    assertEquals(bun.name, bun.getName());
}

//Проверяем получение цены булки
@Test
public void getPriceTestCorrectValue() {
    assertEquals(bun.price, bun.getPrice(), 0.0F);
}
}

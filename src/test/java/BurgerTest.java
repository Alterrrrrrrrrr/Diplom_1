import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientSauce;

    @Mock
    Ingredient ingredientFilling;

    @Before
    public void setUp() {

        when(bun.getName()).thenReturn("Bun from rice fleur");
        when(bun.getPrice()).thenReturn(2.25f);

        when(ingredientFilling.getPrice()).thenReturn(0.45F);
        when(ingredientFilling.getName()).thenReturn("sausage");
        when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);


        when(ingredientSauce.getPrice()).thenReturn(0.3f);
        when(ingredientSauce.getName()).thenReturn("sour cream");
        when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);

        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
    }

//Проверяем установку булки
    @Test
    public void verifySetBuns() {
        assertEquals(bun, burger.bun);
    }

//Проверяем добавление ингредиента
    @Test
    public void verifyAddIngredient() {
        int expectedIndex = 2;
        assertEquals(expectedIndex, burger.ingredients.size());
    }

//Проверяем удаление ингредиента
    @Test
    public void verifyRemoveIngredient() {
        burger.removeIngredient(1);
        int expectedIndex = 1;
        assertEquals(expectedIndex, burger.ingredients.size());
    }

//Проверяем перемещение ингредиента
    @Test
    public void verifyMoveIngredient() {
        burger.moveIngredient(0, 1);
        int expectedIndex = 1;
        assertEquals(expectedIndex, burger.ingredients.indexOf(ingredientFilling));
    }

//Проверяем получение цены
    @Test
    public void verifyGetPrice() {
        burger.getPrice();
        verify(bun).getPrice();
        verify(ingredientSauce).getPrice();
        verify(ingredientFilling).getPrice();
    }

//Проверяем корректность цены
    @Test
    public void verifyGetPriceIsCorrect() {
        float expectedPrice = (bun.getPrice() * 2) + ingredientFilling.getPrice() + ingredientSauce.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

//Проверяем чек
    @Test
    public void verifyGetReceipt() {
        String receipt = burger.getReceipt();
        String expectedReceipt = "(==== Bun from rice fleur ====)\n= filling sausage =\n= sauce sour cream =\n(==== Bun from rice fleur ====)\n\nPrice: 5,250000\n";
        assertEquals(expectedReceipt, receipt);
    }
}

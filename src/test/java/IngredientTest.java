package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    private final String name = "Бомбический";
    private final float price = 2.15F;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, name, price);
    }

    //Проверяем получение цены ингредиента
    @Test
    public void getPriceTest() {
        Assert.assertEquals("Неправильная цена, ожидается " + price, price, ingredient.getPrice(), 0);
    }

//Проверяем получение названия ингредиента
    @Test
    public void getNameTest() {
        Assert.assertEquals("Неправильное название, ожидается " + name, name, ingredient.getName());
    }

//Проверяем получение типа ингредиента
    @Test
    public void getTypeTest() {
        Assert.assertEquals("Неправильный тип, ожидается " + IngredientType.FILLING, IngredientType.FILLING, ingredient.getType());
    }
}
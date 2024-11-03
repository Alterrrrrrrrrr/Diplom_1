import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType actualType;
    private final IngredientType expectedType;

    public IngredientTypeTest(IngredientType actualType, IngredientType expectedType){
        this.actualType = actualType;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "Тест {index}. Тип ингредиента: {0}}")
    public static Object[][] getIngredientType() {
        return new Object[][] {
                {SAUCE, SAUCE},
                {FILLING, FILLING},
        };
    }

    @Test
    public void checkGettingIngredientType(){
        assertEquals(expectedType, actualType);
    }

}
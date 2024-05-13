import org.testng.annotations.Factory;

public class TestFactory {
    @Factory
    public Object[] factoryMethod(){
        return new Object[]{new SearchProductTest("A"),
                new SearchProductTest("B"),
                new SearchProductTest("C")};
    }
}

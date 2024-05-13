import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
    @Test(dataProvider = "test1")
    public void sampleTest(String username , String password){
        System.out.println("Username : "+username);
        System.out.println("Password : "+password);
    }

    @DataProvider(name = "test1")
    public Object[][] setData(){
        return new Object[][]{
                {"ayush","123"},
                {"kamal","456"},
                {"Ishita","789"}
        };
    }
}

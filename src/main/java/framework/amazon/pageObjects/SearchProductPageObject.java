package framework.amazon.pageObjects;

import intializers.WebPageInit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPageObject extends WebPageInit {

    public SearchProductPageObject(){
        super();
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement search;

    public SearchProductPageObject setSearchBox(String item){
        setText(search,item,"Search Text Box");
        return this;
    }

    public SearchProductPageObject setClear(){
        search.clear();
        return this;
    }
}

package framework.amazon.feature;

import framework.amazon.pageObjects.SearchProductPageObject;

public class SearchFeature {

    SearchProductPageObject searchProductPageObject = new SearchProductPageObject();

    public void searchItem1(String str){
        searchProductPageObject.setSearchBox(str);
    }

    public void searchItem2(String str){
        searchProductPageObject.setClear().setSearchBox(str);
    }
}

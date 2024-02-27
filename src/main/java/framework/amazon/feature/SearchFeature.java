package framework.amazon.feature;

import framework.amazon.pageObjects.SearchProductPageObject;

public class SearchFeature {

    SearchProductPageObject searchProductPageObject = new SearchProductPageObject();

    public void searchItem(String str){
        searchProductPageObject.setSearchBox(str);
    }
}

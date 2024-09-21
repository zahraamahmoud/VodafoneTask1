package pages;

import actions.UIActions;

class PageHeader {
    UIActions uiactions;
    String logoID="nav-logo-sprites";

    String searchTextboxID="twotabsearchtextbox";
    String searchBtnID= "nav-search-submit-button";
    String cartLinkCss=".nav-cart-icon.nav-sprite";


    //String todaysDealsLinkXpath = "//a[contains(@href, 'deals')]";

    String todayDealsCss="a[href*='deals']";
     PageHeader(){
      uiactions=new UIActions();
     }
    public SearchResultPage SearchForItem(String itemName){
        uiactions.setText(searchTextboxID, UIActions.byenum.id,false,itemName);
        uiactions.clickon(searchBtnID, UIActions.byenum.id);
        return new SearchResultPage();
    }
    public CartPage goToCart(){
        uiactions.clickon(cartLinkCss, UIActions.byenum.css);
        return new CartPage();
    }
    public TodayDealsPage goToTodayDeals(){
        uiactions.clickon(todayDealsCss, UIActions.byenum.css);
        return new TodayDealsPage();
    }
}

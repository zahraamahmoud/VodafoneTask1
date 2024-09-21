package pages;

import actions.UIActions;

public class HomePage extends PageHeader {
    String amazonURL="https://www.amazon.eg/";


    public HomePage(){
        super();
    }

    public void navigateToAmazonHomePage(){
        uiactions.navigatetopage(amazonURL,logoID, UIActions.byenum.id);
    }


}

package pages;

import actions.UIActions;

public class AddedToCartPage extends PageHeader{
    String successMessageXpath="(//h1)[2]";
    public  AddedToCartPage(){
        super();

    }
    public String getSuccessMessage(){
        return uiactions.getText(successMessageXpath, UIActions.byenum.xpath);
    }


}


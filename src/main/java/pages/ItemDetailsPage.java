package pages;

import actions.UIActions;

public class ItemDetailsPage extends PageHeader{

   String addToCartBtnID ="add-to-cart-button";
   String itemTitleID="productTitle";

    public  ItemDetailsPage(){
        super();
    }
    public String getItemTitle(){
        return uiactions.getText(itemTitleID, UIActions.byenum.id);
    }
    public AddedToCartPage addItemToCart(){
        uiactions.clickon(addToCartBtnID, UIActions.byenum.id);
        return new AddedToCartPage();
    }




  }

package pages;

import actions.UIActions;

import java.util.List;

public class CartPage extends PageHeader{


    String pageTitlexpath="(//h2)[1]";
    String itemsNamesCss="span.a-truncate-full.a-offscreen";
    public CartPage(){
        super();
    }
    public String getPageTitle(){
        return uiactions.getText(pageTitlexpath, UIActions.byenum.xpath);
    }

    public boolean isCartContainsItem(String itemname){
      List<String> itemsName=uiactions.getTextOfElements(itemsNamesCss, UIActions.byenum.css);
      for(String item:itemsName){

          if (itemname.contains(item) || item.contains(itemname)) {
              System.out.println(item);

              return true;
          }

      }
      return false;
    }


}

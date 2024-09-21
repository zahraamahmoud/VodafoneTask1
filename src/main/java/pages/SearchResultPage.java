package pages;

import actions.UIActions;

public class SearchResultPage extends PageHeader {

    public SearchResultPage(){
      super();
    }

    public ItemDetailsPage SelectItem(int index){
        uiactions.clickon("(//h2/a)[" + index + "]", UIActions.byenum.xpath);
        return new ItemDetailsPage();
    }
    public String getItemName(int  index){
      return uiactions.getText("(//h2/a/span)["+index+"]", UIActions.byenum.xpath);
    }


}

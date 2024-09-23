package pages;

import actions.UIActions;

public class TodayDealsPage extends PageHeader {
    String seeMoreBtnCss = "button[class*='SeeMoreButton']";

    public TodayDealsPage() {
        super();
    }

    public void selectDepartmentFilter(String department) {
        uiactions.clickon(seeMoreBtnCss, UIActions.byenum.css);

        uiactions.clickon("//div[@data-csa-c-element-id='filter-departments-" + department + "']//input", UIActions.byenum.xpath);
    }

    public void selectDiscountFilter(String discount) {
        //uiactions.clickon(seeMoreBtnCss, UIActions.byenum.css);

        uiactions.clickon("//div[@data-csa-c-element-id='filter-percentOff-" + discount + "']//input", UIActions.byenum.xpath);
    }
}
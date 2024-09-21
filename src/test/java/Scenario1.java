import actions.BrowserActions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class Scenario1 {

    HomePage homepage;
    SearchResultPage searchResultPage;
    ItemDetailsPage itemDetailsPage;
    AddedToCartPage addedToCartPage;
    CartPage cartPage;
    String successMessage="تمت الإضافة إلى عربة التسوق";
    String cartPageTitle="عربة التسوق";
    String itemName="";


    @BeforeClass
    public void setup(){
        BrowserActions.setWebDriver(BrowserActions.browsers.chrome);

        BrowserActions.setthewindowSize(1024, 768);

    }
      @Test(dataProvider = "TestData")
       public void addItemToTheCart(String searchKeyword,int itemindex ){
        homepage=new HomePage();
        homepage.navigateToAmazonHomePage();
        searchResultPage=homepage.SearchForItem(searchKeyword);
        itemName=searchResultPage.getItemName(itemindex);
        itemDetailsPage=searchResultPage.SelectItem(itemindex);
        Assert.assertEquals(itemDetailsPage.getItemTitle(),itemName);
        addedToCartPage=itemDetailsPage.addItemToCart();
        Assert.assertEquals(addedToCartPage.getSuccessMessage(),successMessage);
        cartPage=addedToCartPage.goToCart();
        Assert.assertEquals(cartPage.getPageTitle(),cartPageTitle);
        Assert.assertTrue(cartPage.isCartContainsItem(itemName),"item was not added to the cart");


      }

       @AfterClass
       public void teardown(){
        BrowserActions.quitDriver();
        }
       @DataProvider(name = "TestData")
       public  Object[][] testData() {
          return new Object[][]{
                 {"car accessories" ,1},


          };
    }
}

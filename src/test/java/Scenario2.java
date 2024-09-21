import actions.BrowserActions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TodayDealsPage;

public class Scenario2 {

    HomePage homepage;
    TodayDealsPage todayDealsPage;

    @BeforeClass
    public void setup(){
        BrowserActions.setWebDriver(BrowserActions.browsers.chrome);
        BrowserActions.setthewindowSize(1024, 768);
    }
    @Test(dataProvider = "filterOptions")

    public void addItemToCart2 (String departmentfilter,String discountFilter){
        homepage=new HomePage();
        homepage.navigateToAmazonHomePage();
        todayDealsPage=homepage.goToTodayDeals();
        todayDealsPage.selectDepartmentFilter(departmentfilter);
        todayDealsPage.selectDiscountFilter(discountFilter);
    }
    @AfterClass
    public void teardown(){
        BrowserActions.quitDriver();
    }

    @DataProvider(name = "filterOptions")
   public Object[][] filterOptions() {
        return new Object[][]{
                {"السوبر ماركت", "خصم 10% أو أكثر"},
                {"السوبر ماركت", "خصم 25% أو أكثر"}

        };
    }
}

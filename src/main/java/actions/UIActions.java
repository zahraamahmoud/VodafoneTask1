package actions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class UIActions {

    WebDriver driver;
    Actions actions;
    public UIActions(){
        this.driver=BrowserActions.getDriver();
    }
    public UIActions navigatetopage(String url,String selector,byenum locateBy){
        driver.get(url);
        WebElement element = waitUntil( expectedcoditionsenum.presenceOfElement,selector,locateBy);
        assertNotNull(element);
        return this;
      }

    public void hoverOver(String selector1,byenum locateBy1){
         WebElement element1=getElement(selector1,locateBy1);
         actions =new Actions(driver);
         actions.moveToElement(element1).perform();
    }

      private Select findDropDwonElement(String selector,byenum locateBy){
        return new Select(getElement(selector,locateBy));
      }

     public void selectFromDropDown(String selector, byenum locateBy,selectbyenum selectingMethod, String option){
        Select dropDown=findDropDwonElement(selector,locateBy);
        switch(selectingMethod){
            case value :
                dropDown.selectByValue(option);
                break;
            case name :
                dropDown.selectByVisibleText(option);
                break;
            case index:
                dropDown.selectByIndex(Integer.valueOf(option));
                break;

        }

     }

     public String getSelectedOption(String selector,byenum locateBy){
        return findDropDwonElement( selector,locateBy).getFirstSelectedOption().getText();
     }
    public void clickon(String selector,byenum locateBy){
        WebElement element=null;

        try{
           // element=waitUntil(expectedcoditionsenum.elementToBeClickable, selector, locateBy);
            element=getElement(selector,locateBy);
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.click().build().perform();
         }
         catch(Exception e){

                 Assert.fail("couldn't click on the element because of" + e.getMessage());

             }



    }
    public String getText(String selector,byenum locateBy){
          waitUntil(expectedcoditionsenum.visibilityofElement, selector, locateBy);
          WebElement element=getElement( selector, locateBy);
         return element.getText();
     }
    public List<String> getTextOfElements(String selector,byenum locateBy){
        List<WebElement>webelements=waitUntilElements(expectedcoditionsenum.presenceOfElement, selector, locateBy);
        List<String>webelementsText= new ArrayList<>();

        for (WebElement e:webelements){
            webelementsText.add(e.getText());
        }
        return webelementsText;
    }

    public void setText(String selector,byenum locateBy ,Boolean clear,String textvalue){
        WebElement element=getElement( selector, locateBy);
        waitUntil(expectedcoditionsenum.presenceOfElement, selector, locateBy);
        try{
            if(clear){
                 element.clear();
                 element.sendKeys(textvalue);
                  }
        else{
                 element.sendKeys(textvalue);
                  }
            //assertEquals(element.getText(),textvalue );

        }catch(Exception e){

            Assert.fail("couldn't settext because of " + e.getMessage());

        }
    }

    public WebElement waitUntil(expectedcoditionsenum ex,String selector,byenum locateBy){
     By by=setby( selector,locateBy);
     WebElement element=null;
     try{
               switch(ex){
                   case presenceOfElement:
                      element= (new WebDriverWait(driver, Duration.ofSeconds(15)))
                               .until(ExpectedConditions.presenceOfElementLocated(by));
                       break;
                   case elementToBeClickable:
                      element= (new WebDriverWait(driver, Duration.ofSeconds(15)))
                               .until(ExpectedConditions.elementToBeClickable(by));
                       break;
                   case visibilityofElement:
                       element= (new WebDriverWait(driver, Duration.ofSeconds(15)))
                               .until(ExpectedConditions.visibilityOfElementLocated(by));
                       break;
               }

           }catch(Exception e){
            //Assert.fail("Couldn't click because of" + e.getMessage());

           }
        goTotheElement(element);
        return element;
 }
    public List<WebElement> waitUntilElements(expectedcoditionsenum ex, String selector, byenum locateBy){
        By by=setby( selector,locateBy);
        List<WebElement> elements = null;
        try{
            switch(ex){
                case presenceOfElement:
                    elements= (new WebDriverWait(driver, Duration.ofSeconds(15)))
                            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
                    break;
                case visibilityofElement:
                    elements= (new WebDriverWait(driver, Duration.ofSeconds(15)))
                            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
                    break;
            }

        }catch(Exception e){
            //Assert.fail("Couldn't click because of" + e.getMessage());

        }
        return elements;
    }

    public  By setby(String selector,byenum locateBy){
     By by = null;
     switch(locateBy){
         case xpath :
             by= new By.ByXPath(selector);
             break;
         case id:
             by =new By.ById(selector);
             break;
         case name:
             by =new By.ByName(selector);
             break;
         case classname:
             by =new By.ByClassName(selector);
             break;
         case css:
             by =new By.ByCssSelector(selector);
             break;
         case tagname:
             by =new By.ByTagName(selector);
             break;
         case linktext:
             by =new By.ByLinkText(selector);
             break;
         case partialLinkText:
             by =new By.ByPartialLinkText(selector);
             break;


     }
     return by;

}

    public WebElement getElement(String selector,byenum locateBy){
        By by=setby( selector,locateBy);
        WebElement element = null;
        try{
           element= waitUntil( expectedcoditionsenum.presenceOfElement,selector,locateBy);
        }catch(Exception e){

            Assert.fail("Couldn't find element because of" + e.getMessage());

        }
       return element;
    }

    public void goTotheElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
        js.executeScript("arguments[0].style.border='2px solid red'", element);

    }
    enum expectedcoditionsenum{
        presenceOfElement,
        elementToBeClickable,
        visibilityofElement
    }
    public enum byenum{
        xpath,
        id,
        classname,
        name,
        css,
        tagname,
        linktext,
        partialLinkText

    }
    public enum selectbyenum{

        value,
        name,
        index

    }
}

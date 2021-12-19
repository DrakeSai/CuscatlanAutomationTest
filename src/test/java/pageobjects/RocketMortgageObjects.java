package pageobjects;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RocketMortgageObjects {

    public WebElement mortgageTitle() {
        return Driver.webDriver.findElement(By.cssSelector(".sprk-b-TypeDisplayTwo"));
    }

}
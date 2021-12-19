package pageobjects;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RocketMortgageObjects {

    public WebElement mortgageTitle() {
        return Driver.webDriver.findElement(By.cssSelector(".sprk-b-TypeDisplayTwo"));
    }

    public WebElement homePrice() {
        return Driver.webDriver.findElement(By.cssSelector("input#purchasePrice"));
    }

    public WebElement downPayment() {
        return Driver.webDriver.findElement(By.cssSelector("input#downPayment"));
    }

    public WebElement loanTerm() {
        return Driver.webDriver.findElement(By.cssSelector("select#term"));
    }

    public WebElement loanTermValue() {
        return Driver.webDriver.findElement(By.cssSelector("select#term > option"));
    }

    public WebElement interestRate() {
        return Driver.webDriver.findElement(By.cssSelector("input#rate"));
    }

    public WebElement calculateButton() {
        return Driver.webDriver.findElement(By.cssSelector("button#calculateButton"));
    }

    public WebElement totalPayment() {
        return Driver.webDriver.findElement(By.cssSelector(".phfc-b-TypeDisplayFive.phfc-u-FontWeight--bold > span"));
    }

}
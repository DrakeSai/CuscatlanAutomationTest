package pageobjects;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RocketMortgageObjects {

    private Double homeValue;
    private Double downPayment;
    private Double interestRate;

    // Getter
    public Double getHomeValue() {
        return this.homeValue;
    }
    public Double getDownPayment() {
        return this.downPayment;
    }
    public Double getInterestRate() {
        return this.interestRate;
    }

    // Setter
    public void setHomeValue(Double newHomeValue) {
        this.homeValue = newHomeValue;
    }
    public void setDownPayment(Double newDownPayment) {
        this.downPayment = newDownPayment;
    }
    public void setInterestRate(Double newInterestRate) {
        this.interestRate = newInterestRate;
    }

    // Page objects

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
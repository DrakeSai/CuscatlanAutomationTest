package implementations;

import com.thoughtworks.gauge.Step;
import pageobjects.RocketMortgageObjects;
import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;

public class InputMortgageValues extends RocketMortgageObjects{
    @Step("Input <homePrice> within the 'home price' field")
    public void inputHomePriceValue(String homePrice) {
        homePrice().click();
        homePrice().clear();
        homePrice().sendKeys(homePrice);
    }

    @Step("Input <downPayment> within the 'down payment' field")
    public void inputDownPaymentValue(String downPayment) {

        downPayment().clear();
        downPayment().sendKeys(downPayment);
    }

    @Step("Input <interestRate> within the 'interest rate' field")
    public void inputInterestRateValue(String interestRate) {
       
        interestRate().clear();
        interestRate().sendKeys(interestRate);
    }

    @Step("Submit the 'Calculate' button")
    public void submitTheCalculateButton() throws InterruptedException {
        ((JavascriptExecutor)Driver.webDriver).executeScript("arguments[0].scrollIntoView();", interestRate());
        Thread.sleep(1000);
        calculateButton().submit();
    }

}

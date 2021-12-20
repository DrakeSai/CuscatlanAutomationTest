package implementations;

import com.thoughtworks.gauge.Step;
import pageobjects.RocketMortgageObjects;
import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;

public class InputMortgageValues{
   

    private RocketMortgageObjects rocketMortgage;
    private ValidateThatTotalPaymentIsCorrect validation;

    public InputMortgageValues(){
        this.rocketMortgage = new RocketMortgageObjects();
        this.validation = new ValidateThatTotalPaymentIsCorrect();
    }

    @Step("Input <homePrice> within the 'home price' field")
    public void inputHomePriceValue(String homePrice) {
        this.rocketMortgage.homePrice().clear();
        this.rocketMortgage.homePrice().sendKeys(homePrice);
        this.rocketMortgage.setHomeValue(Double.valueOf(homePrice));
    }

    @Step("Input <downPayment> within the 'down payment' field")
    public void inputDownPaymentValue(String downPayment) {
        this.rocketMortgage.downPayment().clear();
        this.rocketMortgage.downPayment().sendKeys(downPayment);
        this.rocketMortgage.setDownPayment(Double.valueOf(downPayment));
    }

    @Step("Input <interestRate> within the 'interest rate' field")
    public void inputInterestRateValue(String interestRate) {
        this.rocketMortgage.interestRate().clear();
        this.rocketMortgage.interestRate().sendKeys(interestRate);
        this.rocketMortgage.setInterestRate(Double.valueOf(interestRate));
    }

    @Step("Submit the 'Calculate' button")
    public void submitTheCalculateButton() throws InterruptedException {
        ((JavascriptExecutor)Driver.webDriver).executeScript("arguments[0].scrollIntoView();", this.rocketMortgage.interestRate());
        Thread.sleep(1000);
        this.rocketMortgage.calculateButton().submit();
    }

    @Step("Validate that 'Total payment' value is correct")
    public void validateThatTotalPaymentValueIsCorrect() throws InterruptedException{
        this.validation.validateThatTotalPaymentValueIsCorrect(this.rocketMortgage);
    }

}

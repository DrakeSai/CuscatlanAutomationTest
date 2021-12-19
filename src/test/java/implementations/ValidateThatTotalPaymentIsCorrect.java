package implementations;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import pageobjects.RocketMortgageObjects;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateThatTotalPaymentIsCorrect extends RocketMortgageObjects {

    @Step("Validate that 'Total payment' value is correct")
    public void validateThatTotalPaymentValueIsCorrect() throws InterruptedException {
        ((JavascriptExecutor) Driver.webDriver).executeScript("arguments[0].scrollIntoView();", mortgageTitle());
        Thread.sleep(4000);
        assertThat(totalPayment().getText())
                .containsIgnoringCase("684.03")
                .withFailMessage("Unexpected Title");
    }
}
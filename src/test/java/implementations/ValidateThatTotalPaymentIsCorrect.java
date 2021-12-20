package implementations;

import com.thoughtworks.gauge.Gauge;
import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import pageobjects.RocketMortgageObjects;
import java.text.DecimalFormat;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateThatTotalPaymentIsCorrect {


    public void validateThatTotalPaymentValueIsCorrect(RocketMortgageObjects rocket) throws InterruptedException {

        DecimalFormat decim = new DecimalFormat("0.00");
        Double M = rocket.getHomeValue() - rocket.getDownPayment();
        Double r = (rocket.getInterestRate()/100)/12;
        Double headDiv = r*(Math.pow((1+r), 360));
        Double footDiv = (Math.pow((1+r), 360)) - 1;
        Double C = M * (headDiv/footDiv);
        Double totalPaymentTwoDecimals = Double.parseDouble(decim.format(C));
        Gauge.writeMessage("Formula: C = M ( r(1 + r)^n ) / ( (1 + r)^n â€“ 1 )");
        Gauge.writeMessage("Total payment value is: " + totalPaymentTwoDecimals);

        ((JavascriptExecutor) Driver.webDriver).executeScript("arguments[0].scrollIntoView();", rocket.mortgageTitle());
        Thread.sleep(4000);
        assertThat(rocket.totalPayment().getText())
                .containsIgnoringCase(String.valueOf(totalPaymentTwoDecimals))
                .withFailMessage("Unexpected Title");
    }

}
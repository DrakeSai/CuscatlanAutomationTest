package implementations;
import static org.assertj.core.api.Assertions.assertThat;
import com.thoughtworks.gauge.Step;
import pageobjects.RocketMortgageObjects;
import driver.Driver;

public class OpenRocketMortgagePage extends RocketMortgageObjects {
    
    @Step("When the 'Rocket mortgage' homepage is opened")
    public void whenTheRocketMortgagePageIsOpened() {
        String app_url = System.getenv("RocketMortgageURL");
        Driver.webDriver.get(app_url + "/");
        Driver.webDriver.manage().window().maximize();
    }

    @Step("Then the page title contains <title>")
    public void thenTheMortgageTitleIsDisplayed(String title) {
        assertThat(mortgageTitle().getText())
                .containsIgnoringCase(title)
        .withFailMessage("Unexpected Title");
    }

}

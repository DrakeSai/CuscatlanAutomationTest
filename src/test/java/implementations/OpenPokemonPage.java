package implementations;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import pageobjects.PokemonShowdownObjects;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenPokemonPage extends PokemonShowdownObjects{
    @Step("When the 'Pokemon showdown' homepage is opened")
    public void whenThePokemonPageIsOpened() {
        String app_url = System.getenv("pokemonShowdownURL");
        Driver.webDriver.get(app_url + "/");
        Driver.webDriver.manage().window().maximize();
    }

    @Step("Then the pokemon page title contains <title>")
    public void thenThePokemonTitleIsDisplayed(String title) {
        assertThat(pokemonShowdownTitle().getText())
                .containsIgnoringCase(title)
        .withFailMessage("Unexpected Title");
    }
}

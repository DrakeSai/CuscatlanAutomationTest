package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import driver.Driver;

public class PokemonShowdownObjects {
        // Page objects

        public WebElement pokemonShowdownTitle() {
            return Driver.webDriver.findElement(By.cssSelector("body > div.pfx-panel > div > form > h1 > a"));
        }

        public WebElement pokemonFilter() {
            return Driver.webDriver.findElement(By.xpath("//?/button[@innertext='Pokémon']"));
        }

        public WebElement moveFilter() {
            return Driver.webDriver.findElement(By.xpath("//?/button[@innertext='Moves']"));
        }

        public WebElement searchBarPokemon() {
            return Driver.webDriver.findElement(By.cssSelector("body > div.pfx-panel > div > form > div > input"));
        }

        public WebElement searchResult() {
            return Driver.webDriver.findElement(By.cssSelector("span.col.pokemonnamecol"));
        }

        public WebElement searchResultMove() {
            return Driver.webDriver.findElement(By.cssSelector("span.col.movenamecol > b"));
        }

        public WebElement totalStats() {
            return Driver.webDriver.findElement(By.cssSelector(".stats tr:nth-of-type(8) .bst:nth-child(2)"));
        }
}

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

        public WebElement HP() {
            return Driver.webDriver.findElement(By.cssSelector("tr:nth-of-type(2) > .stat"));
        }

        public WebElement Attack() {
            return Driver.webDriver.findElement(By.cssSelector("tr:nth-of-type(3) > .stat"));
        }

        public WebElement Defense() {
            return Driver.webDriver.findElement(By.cssSelector("tr:nth-of-type(4) > .stat"));
        }

        public WebElement SpeAttack() {
            return Driver.webDriver.findElement(By.cssSelector("tr:nth-of-type(5) > .stat"));
        }

        public WebElement SpeDefense() {
            return Driver.webDriver.findElement(By.cssSelector("tr:nth-of-type(6) > .stat"));
        }

        public WebElement Speed() {
            return Driver.webDriver.findElement(By.cssSelector("tr:nth-of-type(7) > .stat"));
        }

        public WebElement Ability() {
            return Driver.webDriver.findElement(By.cssSelector(".imgentry > a:nth-of-type(1)"));
        }

        public WebElement HiddenAbility() {
            return Driver.webDriver.findElement(By.cssSelector(".imgentry > a:nth-of-type(2)"));
        }
}

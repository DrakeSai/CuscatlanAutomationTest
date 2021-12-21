package implementations;

import com.thoughtworks.gauge.Step;
import pageobjects.PokemonShowdownObjects;
import static org.assertj.core.api.Assertions.assertThat;

public class PokemonShowdownInteraction {

    private PokemonShowdownObjects pokemonObjects;

    public PokemonShowdownInteraction(){
        this.pokemonObjects = new PokemonShowdownObjects();
    }

    @Step("Select 'Pokemon' filter within 'Pokedex' section")
    public void selectPokemonFilter() {
        this.pokemonObjects.pokemonShowdownTitle().click();
    }

    @Step("Select 'Moves' filter within 'Pokedex' section")
    public void selectMoveFilter() {
        this.pokemonObjects.moveFilter().click();
    }

    @Step("Input <pokemonName> within the searchbar")
    public void inputPokemonName(String pokemonName) {
        this.pokemonObjects.searchBarPokemon().sendKeys(pokemonName);
    }

    @Step("Validate that <pokemonName> is displayed in the search result")
    public void validatePokemonNameDisplayed(String pokemonName) {
        assertThat(this.pokemonObjects.searchResult().getText())
                .containsIgnoringCase(pokemonName)
        .withFailMessage("Unexpected Pokemon");
    }

    @Step("Validate that <pokemonMove> move is displayed in the search result")
    public void validatePokemonMoveDisplayed(String pokemonMove) {
        assertThat(this.pokemonObjects.searchResultMove().getText())
                .containsIgnoringCase(pokemonMove)
        .withFailMessage("Unexpected Pokemon move");
    }

    @Step("Open the pokemon details")
    public void openPokemonDetails() throws InterruptedException {
        this.pokemonObjects.searchResult().click();
        Thread.sleep(3000);
    }

    @Step("Open the pokemon move details")
    public void openPokemonMoveDetails() throws InterruptedException {
        this.pokemonObjects.searchResultMove().click();
        Thread.sleep(3000);
    }

    @Step("Validate the pokemon 'Total stats' value")
    public void validatepokemonTotalStats() {
        assertThat(this.pokemonObjects.totalStats().getText())
                .containsIgnoringCase("309")
        .withFailMessage("Unexpected Pokemon stats value");
    }
}

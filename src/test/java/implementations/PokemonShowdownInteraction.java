package implementations;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import pageobjects.PokemonShowdownObjects;
import static org.assertj.core.api.Assertions.assertThat;

public class PokemonShowdownInteraction {

    private PokemonShowdownObjects pokemonObjects;
    private Long[] stats;
    private String[] ability;

    public PokemonShowdownInteraction(){
        this.pokemonObjects = new PokemonShowdownObjects();
        this.stats = stats;
        this.ability = ability;
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
      this.stats = APIValidations.validatePokemonStats("https://pokeapi.co/api/v2/pokemon/charmander");
    }

    @Step("Validate the <pokemonName> pokemon 'HP' stats value")
    public void validatepokemonHPStat(String pokemonName) {
        try
        {
        this.stats = APIValidations.validatePokemonStats("https://pokeapi.co/api/v2/pokemon/"+ pokemonName);
        assertThat(this.pokemonObjects.HP().getText())
                .containsIgnoringCase(String.valueOf(this.stats[0]))
        .withFailMessage("Unexpected value");
        Gauge.writeMessage("Pokemon name: " + pokemonName + " - HP: " + String.valueOf(this.stats[0]));
        }
        catch (Exception e)
        {
            System.out.println(e + "...........");
        }
    }

    @Step("Validate the <pokemonName> pokemon 'Attack' stats value")
    public void validatepokemonAttackStat(String pokemonName) {
        this.stats = APIValidations.validatePokemonStats("https://pokeapi.co/api/v2/pokemon/"+ pokemonName);
        assertThat(this.pokemonObjects.Attack().getText())
                .containsIgnoringCase(String.valueOf(this.stats[1]))
        .withFailMessage("Unexpected value");
        Gauge.writeMessage("Pokemon name: " + pokemonName + " - Attack: " + String.valueOf(this.stats[1]));
    }

    @Step("Validate the <pokemonName> pokemon 'Defense' stats value")
    public void validatepokemonDefenseStat(String pokemonName) {
        this.stats = APIValidations.validatePokemonStats("https://pokeapi.co/api/v2/pokemon/"+ pokemonName);
        assertThat(this.pokemonObjects.Defense().getText())
                .containsIgnoringCase(String.valueOf(this.stats[2]))
        .withFailMessage("Unexpected value");
        Gauge.writeMessage("Pokemon name: " + pokemonName + " - Defense: " + String.valueOf(this.stats[2]));
    }
    
    @Step("Validate the <pokemonName> pokemon 'SpeAttack' stats value")
    public void validatepokemonSpeAttackStat(String pokemonName) {
        this.stats = APIValidations.validatePokemonStats("https://pokeapi.co/api/v2/pokemon/"+ pokemonName);
        assertThat(this.pokemonObjects.SpeAttack().getText())
                .containsIgnoringCase(String.valueOf(this.stats[3]))
        .withFailMessage("Unexpected value");
        Gauge.writeMessage("Pokemon name: " + pokemonName + " - SpeAttack: " + String.valueOf(this.stats[3]));
    }

    @Step("Validate the <pokemonName> pokemon 'SpeDefense' stats value")
    public void validatepokemonSpeDefenseStat(String pokemonName) {
        this.stats = APIValidations.validatePokemonStats("https://pokeapi.co/api/v2/pokemon/"+ pokemonName);
        assertThat(this.pokemonObjects.SpeDefense().getText())
                .containsIgnoringCase(String.valueOf(this.stats[4]))
        .withFailMessage("Unexpected value");
        Gauge.writeMessage("Pokemon name: " + pokemonName + " - SpeDefense: " + String.valueOf(this.stats[4]));
    }

    @Step("Validate the <pokemonName> pokemon 'Speed' stats value")
    public void validatepokemonSpeedStat(String pokemonName) {
        this.stats = APIValidations.validatePokemonStats("https://pokeapi.co/api/v2/pokemon/"+ pokemonName);
        assertThat(this.pokemonObjects.Speed().getText())
                .containsIgnoringCase(String.valueOf(this.stats[5]))
        .withFailMessage("Unexpected value");
        Gauge.writeMessage("Pokemon name: " + pokemonName + " - Speed: " + String.valueOf(this.stats[5]));
    }

    @Step("Validate the <pokemonName> ability value")
    public void validateThePokemonAbility(String pokemonName) {
        this.ability = APIValidations.validatePokemonAbilities("https://pokeapi.co/api/v2/pokemon/"+ pokemonName);
        assertThat(this.pokemonObjects.Ability().getText())
                .containsIgnoringCase(String.valueOf(this.ability[0]))
        .withFailMessage("Unexpected value");
        Gauge.writeMessage("Ability: " + String.valueOf(this.ability[0]));
    }
}

package implementations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APOD {
    //public final String abilities;
    public final Integer base_experience;
/*    public final String forms;
    public final String game_indices;
    public final String height;*/
    //public final String held_items;
    public final Integer id;
/*    public final String is_default;
    public final String location_area_encounters;
    public final String moves;*/
    public final String name;
    public final Integer order;
/*    public final String past_types;
    public final String species;
    public final String sprites;
    public final String stats;
    public final String types;*/
    public final Integer weight;


    public APOD(/*@JsonProperty("abilities") String abilities,*/
                @JsonProperty("base_experience") Integer base_experience,
                /*@JsonProperty("forms") String forms,
                @JsonProperty("game_indices") String game_indices,
                @JsonProperty("height") String height,
                @JsonProperty("held_items") String held_items,*/
                @JsonProperty("id") Integer id,
                /*@JsonProperty("is_default") String is_default,
                @JsonProperty("location_area_encounters") String location_area_encounters,
                @JsonProperty("moves") String moves,*/
                @JsonProperty("name") String name,
                @JsonProperty("order") Integer order,
                /*@JsonProperty("past_types") String past_types,
                @JsonProperty("species") String species,
                @JsonProperty("sprites") String sprites,
                @JsonProperty("stats") String stats,
                @JsonProperty("types") String types,*/
                @JsonProperty("weight") Integer weight) {
        /*this.abilities =  abilities;*/
        this.base_experience =  base_experience;
       /* this.forms =  forms;
        this.game_indices =  game_indices;
        this.height =  height;
        this.held_items =  held_items;*/
        this.id =  id;
        /*this.is_default =  is_default;
        this.location_area_encounters =  location_area_encounters;
        this.moves =  moves;*/
        this.name =  name;
        this.order =  order;
       /* this.past_types =  past_types;
        this.species =  species;
        this.sprites =  sprites;
        this.stats =  stats;
        this.types =  types;*/
        this.weight =  weight;

    }
}

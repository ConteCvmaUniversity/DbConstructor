package it.thewalkingthread.dbconstructor;

import androidx.appcompat.app.AppCompatActivity;
import it.thewalkingthread.dbconstructor.database.VolleyPokemon;
import it.thewalkingthread.dbconstructor.model.Pokemon;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    //DatabaseReference reference;
    //public static final int NUMPOKE = 807;
    public static final int NUMPOKE = 2;
    VolleyPokemon volleyPokemon;
    //Pokemon pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volleyPokemon = new VolleyPokemon(MainActivity.this);
        getSimplePokemon();


    }


    private synchronized  void setDb(){
        //Pokemon poke;
        volleyPokemon = new VolleyPokemon(MainActivity.this);
        /*
        for (int i = 1 ; i < NUMPOKE;i++){
            //poke = getPokemon(i);
           getPokemon(i);
           //wait
           //setLocalDb(poke);
            //setFirebaseDb(poke);
        }

         */


    }
    private void getSimplePokemon(){
        volleyPokemon.searchAllPokemon();
    }



    private  void getPokemon(int pokeID){

        Pokemon actualPoke = new Pokemon(pokeID);
        //chiamata a json passo il pokemon da riempire
        volleyPokemon.searchPokemonByID(pokeID,actualPoke);
        //return actualPoke;//da moificare
    }



}

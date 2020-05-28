package it.thewalkingthread.dbconstructor;

import androidx.appcompat.app.AppCompatActivity;
import it.thewalkingthread.dbconstructor.database.VolleyPokemon;
import it.thewalkingthread.dbconstructor.model.Pokemon;

import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    //DatabaseReference reference;
    public static final int NUMPOKE = 807;
    VolleyPokemon catcher;
    Pokemon pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDb();



    }


    private void setDb(){
        Pokemon poke;
        catcher = new VolleyPokemon(MainActivity.this);
        for (int i = 1 ; i < NUMPOKE;i++){
            poke = getPokemon(i);
            setLocalDb(poke);
            setFirebaseDb(poke);
        }

    }

    private void setFirebaseDb(Pokemon poke) {
        //TODO funzione che setta il pokemon in Firebase
    }

    private void setLocalDb(Pokemon poke) {
        //TODO funzione che setta il pokemon locale
    }

    private Pokemon getPokemon(int poke){

        Pokemon actualPoke = new Pokemon(poke);
        //chiamata a json passo il pokemon da riempire
        catcher.searchPokemonByID(poke,actualPoke);
        return actualPoke;//da moificare
    }

}

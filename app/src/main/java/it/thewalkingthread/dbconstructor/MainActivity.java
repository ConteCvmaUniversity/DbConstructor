package it.thewalkingthread.dbconstructor;

import androidx.appcompat.app.AppCompatActivity;
import it.thewalkingthread.dbconstructor.model.Pokemon;

import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    //DatabaseReference reference;
    public static final int NUMPOKE = 807;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDb();

        // prova Ale 09:03

    }

    private void setDb(){
        Pokemon poke;
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
        //TODO funzione che chiama pokeApi

        //chiamata a json
        return null;//da moificare
    }

}

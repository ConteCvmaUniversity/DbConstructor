package it.thewalkingthread.dbconstructor.json;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import it.thewalkingthread.dbconstructor.model.PokeType;
import it.thewalkingthread.dbconstructor.model.Pokemon;

public class PokemonJson implements JsonCatcher {
    private String name;
    private Pokemon pokemon;

    //corrisponde al pokemon da riempire (dati)
    public PokemonJson(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    @Override
    public synchronized void parseJson(String response) {
        Gson gson = new Gson();
        String types;
        try{
            JSONObject jsonObject = new JSONObject(response);
            //TODO all parse
            name = jsonObject.getString("name");
            Log.w("CATCH", "PokeName:" + name);
            pokemon.setName(name);
            types = jsonObject.getJSONArray("types").toString();
            Type listType = new TypeToken<List<PokeType>>() {
            }.getType();
            List<PokeType> lt = gson.fromJson(types,listType);

            if (lt != null && lt.size() > 0){
                Log.w("CATCH", "PokeType num:" + lt.size());
                pokemon.setTypes(lt);
            }


            saveOnDb();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void saveOnDb(){
        setLocalDb(pokemon);
        setFirebaseDb(pokemon);
    }

    private void setFirebaseDb(Pokemon poke) {
        //TODO funzione che setta il pokemon in Firebase

    }

    private void setLocalDb(Pokemon poke) {
        //TODO funzione che setta il pokemon locale


    }
}

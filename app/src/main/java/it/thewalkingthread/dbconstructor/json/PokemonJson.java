package it.thewalkingthread.dbconstructor.json;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.Room;
import it.thewalkingthread.dbconstructor.database.PokemonDb;
import it.thewalkingthread.dbconstructor.database.PokemonEntity;
import it.thewalkingthread.dbconstructor.model.PokeType;
import it.thewalkingthread.dbconstructor.model.Pokemon;
import it.thewalkingthread.dbconstructor.model.TypeReturned;

public class PokemonJson implements JsonCatcher {
    private String name;
    private Pokemon pokemon;
    private PokemonDb db;
    private Context context;

    //corrisponde al pokemon da riempire (dati)
    public PokemonJson(Pokemon pokemon,Context context){
        this.pokemon = pokemon;
        this.context = context;
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
            Type listType = new TypeToken<List<TypeReturned>>() {
            }.getType();
            //non funziona non recupera type
            List<TypeReturned> lt = gson.fromJson(types,listType);


            if (lt != null && lt.size() > 0){
                Log.w("CATCH", "PokeType num:" + lt.size());
                //pokemon.setTypes(lt);
                for(int i=0;i < lt.size();i++){
                    //try {
                        String app = "da vedere ora non funziona from";
                        PokeType tp = gson.fromJson(app,PokeType.class);
                        if (tp != null){
                            pokemon.setType(tp,lt.get(i).getSlot());
                        }

                    /*
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                     */
                }

                saveOnDb();

            }



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
        createDB();
        //creo l'entità pokemon
        PokemonEntity pokeEntity = new PokemonEntity();
        pokeEntity.setIdPoke(pokemon.getId());
        pokeEntity.setName(pokemon.getName());
        for (int i=0 ; i < pokemon.getTypes().size();i++){
            pokeEntity.setType(pokemon.getTypes().get(i).getName(),i);
        }

        db.pokemonDao().insert(pokeEntity);


    }

    private void createDB() {
        db = Room.databaseBuilder(context.getApplicationContext(),
                PokemonDb.class,
                "cocktail.db")
                .allowMainThreadQueries()
                .build();
    }
}

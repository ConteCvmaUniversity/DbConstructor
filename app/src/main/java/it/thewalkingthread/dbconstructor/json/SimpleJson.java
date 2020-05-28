package it.thewalkingthread.dbconstructor.json;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.Room;
import it.thewalkingthread.dbconstructor.database.PokemonDb;
import it.thewalkingthread.dbconstructor.model.SimplePokemon;


public class SimpleJson implements JsonCatcher {

    private Context context;

    public SimpleJson(Context context){
        this.context=context;

    }
    @Override
    public void parseJson(String response) {
        Gson gson = new Gson();

        String results;
        PokemonDb db;
        try {
            JSONObject jsonObject = new JSONObject(response);
            results = jsonObject.getJSONArray("results").toString();
            Type listType = new TypeToken<List<SimplePokemon>>() {
            }.getType();
            List<SimplePokemon> lp = gson.fromJson(results,listType);
            if (lp != null && lp.size() > 0) {

                db = Room.databaseBuilder(context.getApplicationContext(),
                        PokemonDb.class,
                        "PokemonDb.db")
                        .allowMainThreadQueries()

                        .build();
                db.simplePokemonDao().insertAll(lp);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

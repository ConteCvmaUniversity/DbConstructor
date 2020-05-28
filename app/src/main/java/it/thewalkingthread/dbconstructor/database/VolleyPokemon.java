package it.thewalkingthread.dbconstructor.database;


import android.annotation.SuppressLint;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import it.thewalkingthread.dbconstructor.json.JsonCatcher;
import it.thewalkingthread.dbconstructor.json.PokemonJson;
import it.thewalkingthread.dbconstructor.json.SimpleJson;
import it.thewalkingthread.dbconstructor.model.Pokemon;

public class VolleyPokemon implements Response.ErrorListener, Response.Listener<String>{

    private static final int NUMPOKE = 807;
    //abstract void setPokemon();
    Context context;
    JsonCatcher catcher;

    public VolleyPokemon(Context context){
        this.context = context;
    }


    /* poke is the object to fill*/
    @SuppressLint("DefaultLocale")
    public void searchPokemonByID(int id, Pokemon poke) {
        catcher = new PokemonJson(poke,context);
        String url = "https://pokeapi.co/api/v2/pokemon/%d/";
        url = String.format(url,id);
        apiCall(url);
    }

    @SuppressLint("DefaultLocale")
    public void searchAllPokemon(){
        catcher = new SimpleJson(context);
        String url = "https://pokeapi.co/api/v2/pokemon?limit=%d";
        url = String.format(url,NUMPOKE);
        apiCall(url);
    }

    private void apiCall(String url) {
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                this,
                this);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(String response) {
        catcher.parseJson(response);

    }
}

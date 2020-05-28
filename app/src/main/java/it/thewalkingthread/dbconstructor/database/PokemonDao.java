package it.thewalkingthread.dbconstructor.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import it.thewalkingthread.dbconstructor.model.Pokemon;

@Dao
public interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PokemonEntity pokemon);
}

package it.thewalkingthread.dbconstructor.database;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import it.thewalkingthread.dbconstructor.model.Pokemon;

public interface PokeTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Pokemon pokemon);
}

package es.joseluisgs.jetpacktutorial.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * The DAO for the film database.
 * Es donde indicamos las operaciones que se pueden realizar en la base de datos.
 * Funciones suspend para hacerlo asincrono con corrutinas.
 */
@Dao
interface FilmDao {

    @Query("SELECT * FROM FAVORITES")
    suspend fun getAll(): List<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Si ya existe un registro con el mismo id, lo reemplaza
    suspend fun insert(film: FilmEntity)

    @Query("SELECT * FROM FAVORITES WHERE id = :filmId")
    suspend fun getById(filmId: Int): FilmEntity?

    @Query("DELETE FROM FAVORITES WHERE id = :filmId")
    suspend fun removeById(filmId: Int)

    // Podriamos hacer el update ...

}
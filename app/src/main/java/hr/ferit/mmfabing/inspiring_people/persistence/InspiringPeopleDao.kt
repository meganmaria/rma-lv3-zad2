package hr.ferit.mmfabing.inspiring_people.persistence

import androidx.room.*
import hr.ferit.mmfabing.inspiring_people.InspiringPeople
import hr.ferit.mmfabing.inspiring_people.model.People

@Dao
interface InspiringPeopleDao {

    @Query("SELECT * FROM human")
    fun getHuman(): List<People>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people: People)

    @Delete
    fun delete(people: People)

    @Query("SELECT * FROM human WHERE id=:id")
    fun getPeople(id: Long): People

}
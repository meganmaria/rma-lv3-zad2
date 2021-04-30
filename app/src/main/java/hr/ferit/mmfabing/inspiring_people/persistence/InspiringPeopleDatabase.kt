package hr.ferit.mmfabing.inspiring_people.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import hr.ferit.mmfabing.inspiring_people.model.People

@Database(entities = [People::class], version = 1)
abstract class InspiringPeopleDatabase : RoomDatabase() {
    abstract fun peopleDao(): InspiringPeopleDao

    companion object{
        const val NAME = "humanDb"
    }
}
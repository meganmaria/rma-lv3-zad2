package hr.ferit.mmfabing.inspiring_people.persistence

import androidx.room.Room
import hr.ferit.mmfabing.inspiring_people.InspiringPeople

object InspiringPeopleDatabaseBuilder {

    private var instance: InspiringPeopleDatabase? = null

    fun getInstance(): InspiringPeopleDatabase{
        synchronized(InspiringPeopleDatabase::class){
            if (instance == null){
                instance == buildDatabase()
            }
        }
        return instance!!
    }

    private  fun buildDatabase(): InspiringPeopleDatabase{
        return Room.databaseBuilder(
                InspiringPeople.application, InspiringPeopleDatabase::class.java, InspiringPeopleDatabase.NAME
        )
                .allowMainThreadQueries()
                .build()
    }
}
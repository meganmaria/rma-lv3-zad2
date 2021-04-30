package hr.ferit.mmfabing.inspiring_people.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "human")
data class People(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name= "title") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "date") val date: String
) : Serializable

package hr.ferit.mmfabing.inspiring_people.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import hr.ferit.mmfabing.inspiring_people.R
import hr.ferit.mmfabing.inspiring_people.R.layout.activity_new_person
import hr.ferit.mmfabing.inspiring_people.databinding.ActivityNewPersonBinding
import hr.ferit.mmfabing.inspiring_people.model.People
import hr.ferit.mmfabing.inspiring_people.persistence.InspiringPeopleDao
import hr.ferit.mmfabing.inspiring_people.persistence.InspiringPeopleDatabaseBuilder

class NewPersonActivity: AppCompatActivity() {

    private lateinit var newPersonBinding: ActivityNewPersonBinding
    private val peopleRepository: InspiringPeopleDao by lazy {
        InspiringPeopleDatabaseBuilder.getInstance().peopleDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newPersonBinding = ActivityNewPersonBinding.inflate(layoutInflater)
        newPersonBinding.btnSpremiProizvod.setOnClickListener { savePeople() }
        setContentView(newPersonBinding.root)

        pickImage();

    }

    private fun savePeople(){
        val title = newPersonBinding.personName.text.toString()
        val description = newPersonBinding.textdescr.text.toString()
        val date = newPersonBinding.dateb.text.toString()
        val people = People(0,title,description,date)
        peopleRepository.insert(people)
        finish()
    }

    private fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object{
        private val IMAGE_PICK_CODE = 1000;
        private val PERMISION_CODE = 1001;
    }
}
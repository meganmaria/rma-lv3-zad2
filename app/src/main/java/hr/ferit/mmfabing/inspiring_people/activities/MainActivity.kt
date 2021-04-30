package hr.ferit.mmfabing.inspiring_people.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.ferit.mmfabing.inspiring_people.R
import hr.ferit.mmfabing.inspiring_people.databinding.ActivityMainBinding
import hr.ferit.mmfabing.inspiring_people.fragments.PeopleDetailsFragment
import hr.ferit.mmfabing.inspiring_people.fragments.PeopleListFragment
import hr.ferit.mmfabing.inspiring_people.listeners.OnPeopleSelectedListener
import hr.ferit.mmfabing.inspiring_people.model.People

class MainActivity
    : AppCompatActivity(), OnPeopleSelectedListener {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       mainBinding = ActivityMainBinding.inflate(layoutInflater)
       mainBinding.addPerson.setOnClickListener{addNewPerson()}
       setContentView(mainBinding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.toolbar, PeopleListFragment.create(), PeopleListFragment.TAG)
                .commit()
        }
    }

    private fun addNewPerson() {
        val newPeopleIntent = Intent(this, NewPersonActivity::class.java)
        startActivity(newPeopleIntent)
    }

    override fun onPeopleSelected(people: People) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.toolbar,
                PeopleDetailsFragment.create(people),
                PeopleDetailsFragment.TAG)
            .addToBackStack(null)
            .commit()
    }
}
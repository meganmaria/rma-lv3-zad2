package hr.ferit.mmfabing.inspiring_people.listeners

import android.provider.ContactsContract
import hr.ferit.mmfabing.inspiring_people.model.People

interface OnPeopleSelectedListener {

    fun onPeopleSelected(people: People)

}
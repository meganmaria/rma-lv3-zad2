package hr.ferit.mmfabing.inspiring_people.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.ferit.mmfabing.inspiring_people.databinding.FragmentPeopleDetailsBinding
import hr.ferit.mmfabing.inspiring_people.model.People

class PeopleDetailsFragment: Fragment() {

    lateinit var peopleDetailsBinding: FragmentPeopleDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        peopleDetailsBinding = FragmentPeopleDetailsBinding.inflate(
            inflater,
            container,
            false
        )

        arguments?.let {
            val people = it.getSerializable(KEY_PEOPLE) as People
            peopleDetailsBinding.tvPeopleTitle.text = people.name
            peopleDetailsBinding.tvPeopleDetails.text = people.description
            peopleDetailsBinding.tvPeopleDate.text = people.date
        }
        return peopleDetailsBinding.root
    }

    companion object{

        const val TAG = "Details"
        private const val KEY_PEOPLE = "People"

        fun create(people: People): PeopleDetailsFragment{
            val args = Bundle()
            args.putSerializable(KEY_PEOPLE, people)
            val fragment = PeopleDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
package hr.ferit.mmfabing.inspiring_people.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.mmfabing.inspiring_people.adapters.PersonAdapter
import hr.ferit.mmfabing.inspiring_people.databinding.FragmentPeopleDetailsBinding
import hr.ferit.mmfabing.inspiring_people.databinding.FragmentPeopleListBinding
import hr.ferit.mmfabing.inspiring_people.listeners.OnPeopleSelectedListener
import hr.ferit.mmfabing.inspiring_people.persistence.InspiringPeopleDao
import hr.ferit.mmfabing.inspiring_people.persistence.InspiringPeopleDatabaseBuilder

class PeopleListFragment: Fragment() {

    private lateinit var onPeopleSelectedListener: OnPeopleSelectedListener
    private lateinit var peopleListBinding: FragmentPeopleListBinding
    private val peopleRepository: InspiringPeopleDao by lazy {
        InspiringPeopleDatabaseBuilder.getInstance().peopleDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        peopleListBinding = FragmentPeopleListBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return peopleListBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnPeopleSelectedListener){
            onPeopleSelectedListener = context
        }
    }

    override fun onResume() {
        super.onResume()
        (peopleListBinding.rvPeople.adapter as PersonAdapter).refreshData(peopleRepository.getHuman())
    }

    private fun setupRecyclerView(){
        peopleListBinding.rvPeople.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        peopleListBinding.rvPeople.adapter = PersonAdapter(peopleRepository.getHuman(), onPeopleSelectedListener)
    }

    companion object{
        const val TAG = "Human list"
        fun create(): PeopleListFragment{
            return create()
        }
    }
}
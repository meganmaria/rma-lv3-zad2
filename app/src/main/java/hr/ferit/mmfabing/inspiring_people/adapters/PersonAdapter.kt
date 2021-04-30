package hr.ferit.mmfabing.inspiring_people.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.mmfabing.inspiring_people.R
import hr.ferit.mmfabing.inspiring_people.listeners.OnPeopleSelectedListener
import hr.ferit.mmfabing.inspiring_people.model.People

class PersonAdapter (human: List<People>,
    private val listener: OnPeopleSelectedListener
):
    RecyclerView.Adapter<PersonViewHolder>(){

    private val human: MutableList<People> = mutableListOf()
    init {
        refreshData(human)
    }

    fun refreshData(people: List<People>) {
        this.human.clear()
        this.human.addAll(people)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent,false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val people = human[position]
        holder.bind(people)
        holder.itemView.setOnClickListener{listener.onPeopleSelected(people)}
    }

    override fun getItemCount(): Int {
        return human.size
    }
}

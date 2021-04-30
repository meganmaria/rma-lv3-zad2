package hr.ferit.mmfabing.inspiring_people.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.mmfabing.inspiring_people.R
import hr.ferit.mmfabing.inspiring_people.databinding.ItemPersonBinding
import hr.ferit.mmfabing.inspiring_people.model.People

class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(people: People){
        val itemBinding = ItemPersonBinding.bind(itemView)
        itemBinding.name.text = people.name
        itemBinding.description.text = people.description
        itemBinding.year.text = people.date
    }
}

package hr.ferit.mmfabing.inspiring_people.persistence

import hr.ferit.mmfabing.inspiring_people.model.People

object InspiringPeopleRepository {

    private val human = mutableListOf<People>(
            People(0,"Nikola Tesla","Born and raised in the Austrian Empire, Tesla studied engineering and physics in the 1870s without receiving a degree, gaining practical experience in the early 1880s working in telephony and at Continental Edison in the new electric power industry. In 1884 he emigrated to the United States, where he became a naturalized citizen.", "1856.-1943."),
            People(0,"Bill Gates", "Gates was born and raised in Seattle, Washington. In 1975, he co-founded Microsoft with childhood friend Paul Allen in Albuquerque, New Mexico. It went on to become the world's largest personal computer software company.", "1955.-present")

    )

    fun getHuman(): List<People> = human
    fun getPeople(title: String): People = human.first { it-> it.name == title }
    fun insert(people: People) = human.add(people)
    fun delete(people: People) = human.remove(people)

}

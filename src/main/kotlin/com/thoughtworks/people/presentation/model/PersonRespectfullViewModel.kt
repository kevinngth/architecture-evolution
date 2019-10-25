package com.thoughtworks.people.presentation.model

import com.thoughtworks.people.business.Person
import com.thoughtworks.people.persistence.model.PersonEntity
import java.time.LocalDate
import java.time.Period

class PersonRespectfullViewModel(
        private val person: Person
) {

    fun title() =
            "${prefixIfNeeded()} ${person.firstName} ${person.secondName}"

    private fun prefixIfNeeded() =
            if (person.age() > 40)
                when (person.sex) {
                    Person.Sex.MAN -> "Mr"
                    Person.Sex.WOMAN -> "Mrs"
                }
            else ""


    fun avatarUrl() = person.avatartUrl

    fun birthDate() = "${person.birthDate.dayOfMonth} ${person.birthDate.month} ${person.birthDate.year}"

    fun favoriteQuote() = person.favoriteQuote
}
package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline: Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )
    constructor(id: String) : this(id, "John", "Doe")
    init {
        println("It's Alive!!! \n${if (lastName === "Doe") "His name $firstName $lastName" else "And his name $firstName $lastName"} \n ")
    }

    companion object Factory {
        var id = -1
        fun makeUser(fullName: String?) : User {
            id++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User("$id", firstName, lastName)
        }
    }

//    private fun getIntro() = """
//        tu tu ru tuuuu !!!
//        tu tu ru tuuuuuuuuuuu ...
//
//        tu tu ru tuuuu !!!
//        tu tu ru tuuuuuuuuuuu ...
//    """.trimIndent()
//
//    fun printMe() = println("""
//            id: $id
//            firstName: $firstName
//            lastName: $lastName
//            avatar: $avatar
//            rating: $rating
//            respect: $respect
//            lastVisit: $lastVisit
//            isOnline: $isOnline
//        """.trimIndent())
}
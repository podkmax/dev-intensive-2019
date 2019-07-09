package ru.skillbranch.devintensive.utils

import android.support.v7.widget.LinearLayoutCompat

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        return when(fullName) {
            "" -> null to null
            " " -> null to null
            else -> {
                val names: List<String>? = fullName?.split(" ")
                when(names?.size) {
                    0 -> null to null
                    1 -> {
                        println(names)
                        val firstName = names[0]
                        firstName to null
                    }
                    else -> {
                        val firstName = names?.get(0)
                        val lastName = names?.get(1)
                        firstName to lastName
                    }
                }
            }
        }
    }
    fun toInitials(firstName: String?, lastName: String?): String? {
        return when {
            (firstName == "" || firstName == " " || firstName == null) && ( lastName == "" || lastName == " " || lastName == null) -> null
            (firstName == "" || firstName == " " || firstName == null) -> lastName?.get(0).toString().toUpperCase()
            (lastName == "" || lastName == " " || lastName == null) -> firstName[0].toString().toUpperCase()
            else -> firstName[0].toString().toUpperCase() + lastName[0].toString().toUpperCase()
        }
    }

    fun transliteration(fullName: String, divider: String = " "): String  {
        var newName = ""
        val alphabet: Map<String, String> = mutableMapOf("а" to "a","б" to "b","в" to "v","г" to "g",
            "д" to "d","е" to "e","ё" to "e","ж" to "zh","з" to "z","и" to "i","й" to "i","к" to "k",
            "л" to "l","м" to "m","н" to "n","о" to "o","п" to "p","р" to "r","с" to "s","т" to "t",
            "у" to "u","ф" to "f","х" to "h","ц" to "c","ч" to "ch","ш" to "sh","щ" to "sh'","ъ" to "",
            "ы" to "i","ь" to "","э" to "e","ю" to "yu","я" to "ya")
        for (letter: Char in fullName.toCharArray()) {
            newName += when {
                alphabet[letter.toString()] == null -> when {
                    letter.toString().toUpperCase() == letter.toString() && letter.toString() != " " ->
                        alphabet[letter.toString().toLowerCase()]?.capitalize() ?: letter.toString()
                    letter.toString() == " " -> divider
                    else -> letter.toString()
                }
                else -> alphabet[letter.toString()]
            }
        }
        return newName
    }
}
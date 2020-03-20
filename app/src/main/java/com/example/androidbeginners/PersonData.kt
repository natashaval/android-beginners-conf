package com.example.androidbeginners

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Person(val id: Int, val name: String): Parcelable

val personArray = arrayListOf(
    Person(1, "Spongebob"),
    Person(2, "Squidward"),
    Person(3, "Patrick"),
    Person(4, "Mr. Krab"),
    Person(5, "Plankton"),
    Person(6, "Larry"),
    Person(7, "Sandy"),
    Person(8, "Ms. Puff"),
    Person(9, "Squilliam"),
    Person(10, "Pearl"),
    Person(11, "A"),
    Person(12, "B"),
    Person(13, "C"),
    Person(14, "D"),
    Person(15, "E"),
    Person(16, "F"))
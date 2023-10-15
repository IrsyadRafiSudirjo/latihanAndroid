package com.example.latihanandroid
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize //plugin untuk membuat parcelable
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable
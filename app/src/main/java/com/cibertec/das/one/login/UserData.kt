package com.cibertec.das.one.login

object UserData {
    private val usuarios = mutableListOf(
        User("venturakoky12@gmail.com",  "Kokyventura25!"),

    )

    fun getUserData(): Collection<User> {
        return usuarios
    }

}
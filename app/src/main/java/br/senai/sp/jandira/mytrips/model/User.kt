package br.senai.sp.jandira.mytrips.model

data class User(
    var id: Int = 0,
    var username: String = "",
    var phone: String = "",
    var email: String = "",
    var password: String = "",
    var image : Int? = null
)

package br.senai.sp.jandira.mytrips.repository

import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.User

class UserRepository {


    fun listAllUsers () : List<User>{

        var user1 = User()
        user1.id = 1
        user1.username = "Usuário"
        user1.phone = "987654321"
        user1.email = "user@email.com"
        user1.password = "senha"
        user1.image = R.drawable.susanna

        var user2 = User()
        user2.id = 2
        user2.username = "Susanna Hoffs"
        user2.phone = "987654321"
        user2.email = "susanna@email.com"
        user2.password = "senha123"
        user2.image = R.drawable.susanna

        val users = listOf(user1, user2)
        return users
    }

}
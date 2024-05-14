package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.dao.UserDb
import br.senai.sp.jandira.mytrips.model.User

class UserRepository (context: Context) {

    private val db = UserDb.getBancoDeDados(context).userDao()

    fun salvar(user: User): Long{
        return db.salvar(user)
    }

    fun buscarTodosOsUsuarios(): List<User>{
        return db.listarTodosOsUsuarios()
    }

    fun buscarUsuarioPeloId(id:Long): User{
        return db.buscarUsuarioPeloId(id)
    }

}
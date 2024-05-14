package br.senai.sp.jandira.mytrips.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.mytrips.model.User

@Dao
interface UserDao {

    @Insert fun salvar(contato: User): Long

    @Query("SELECT * FROM tbl_usuario")
    fun listarTodosOsUsuarios(): List<User>

    @Query("SELECT * FROM tbl_usuario WHERE id = :id")
    fun buscarUsuarioPeloId(id:Long):User

    @Query("SELECT * FROM tbl_usuario WHERE email = :email AND password = :password")
    fun buscarUsuarioPeloLogin(email:String, password:String):User

}
package br.senai.sp.jandira.mytrips.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_usuario")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var username: String = "",
    var phone: String = "",
    var email: String = "",
    var password: String = "",
    var image : Int? = null,
    @ColumnInfo(name = "over_18") var over18: Boolean = false
)


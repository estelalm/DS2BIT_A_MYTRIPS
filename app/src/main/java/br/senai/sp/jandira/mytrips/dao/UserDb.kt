package br.senai.sp.jandira.mytrips.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.mytrips.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDb : RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object {

        private lateinit var instancia: UserDb

        fun getBancoDeDados(context: Context): UserDb {
        instancia = Room
            .databaseBuilder(
                context,
                UserDb::class.java,
                "db_mytrips"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

            return instancia
        }
    }
}
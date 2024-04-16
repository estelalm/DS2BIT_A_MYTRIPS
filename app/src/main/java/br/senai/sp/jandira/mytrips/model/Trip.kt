package br.senai.sp.jandira.mytrips.model

import android.graphics.drawable.Drawable
import java.time.LocalDate

data class Trip(
    var id: Int = 0,
    var destino: String = "",
    var data_chegada: LocalDate = LocalDate.now(),
    var data_partida: LocalDate = LocalDate.now(),
    var descricao: String = "",
    var imagem: Int? = null
)

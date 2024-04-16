package br.senai.sp.jandira.mytrips.utility

import java.time.LocalDate

fun simplificarData (dataExtenso: LocalDate): String {
    val dia = "${dataExtenso.dayOfMonth}"
    val mes = "${dataExtenso.month}".take(3)
    return "$dia $mes"
}
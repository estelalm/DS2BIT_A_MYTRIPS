package br.senai.sp.jandira.mytrips.repository

import br.senai.sp.jandira.mytrips.R
import java.time.LocalDate
import br.senai.sp.jandira.mytrips.model.Trip

class TripRepository {
    
    fun listAllTrips () : List<Trip>{

        val tripLondres = Trip()
        tripLondres.id = 1
        tripLondres.destino = "London"
        tripLondres.descricao = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million."
        tripLondres.data_chegada = LocalDate.of(2019, 2, 18)
        tripLondres.data_partida = LocalDate.of(2019, 2, 25)
        tripLondres.imagem = R.drawable.london //conseguir o drawable pelo contexto

        val tripPorto = Trip()
        tripPorto.id = 3
        tripPorto.destino = "Porto"
        tripPorto.descricao = "Porto is the second largest city in Portugal, the capital of the Porto District and one of the Iberian Peninsula's major urban areas."
        tripPorto.data_chegada = LocalDate.of(2022, 7, 17)
        tripPorto.data_partida = LocalDate.of(2022, 7, 20)
        tripPorto.imagem = R.drawable.porto

        val tripParis = Trip()
        tripParis.id = 2
        tripParis.destino = "Paris"
        tripParis.descricao = "Paris, a capital da França, é uma importante cidade europeia e um centro mundial de arte, moda, gastronomia e cultura."
        tripParis.data_chegada = LocalDate.of(2023, 7, 1)
        tripParis.data_partida = LocalDate.of(2023, 7, 16)
        tripParis.imagem = R.drawable.paris



        val trips = listOf(
            tripLondres,
            tripPorto,
            tripParis
        )
        
        return trips
    }
    
}
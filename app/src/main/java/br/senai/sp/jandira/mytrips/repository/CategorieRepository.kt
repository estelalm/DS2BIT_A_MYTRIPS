package br.senai.sp.jandira.mytrips.repository

import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Categorie
class CategorieRepository {

    fun listAllCategories () : List<Categorie>{

        var mountain = Categorie()
        mountain.id = 1
        mountain.local = R.string.mountain
        mountain.image = R.drawable.mountain

        var snow = Categorie()
        snow.id = 2
        snow.local = R.string.snow
        snow.image = R.drawable.snow

        var beach = Categorie()
        beach.id = 1
        beach.local = R.string.beach
        beach.image = R.drawable.beach

        val categories = listOf(mountain, snow, beach)
        return categories
    }

}
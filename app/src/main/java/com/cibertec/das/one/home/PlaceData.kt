package com.cibertec.das.one.home

import com.cibertec.das.one.R
import com.cibertec.das.one.login.User

object PlaceData {
    //    val title:String, val place:String,val nameFood:String, val price:String,
    //    val statusFood:Boolean
    private val foods = mutableListOf(
        Place(1,"Mercado San Pedro","Cuzco",
            "Cuy al Horno","25.00",true,R.drawable.cuy),
        Place(2,"La Mar","Lima",
            "Ceviche","45.00",true,R.drawable.ceviche),

        Place(3,"Picante Solimar","Arequipa",
            "Rocoto Relleno","18.00",false,R.drawable.rocoto),

        Place(4,"La Lucha Sangucheria","Lima",
            "Sanguche de Chancho","15.00",true,R.drawable.sanguche),
        )

     fun getFoods(): Collection<Place> {
        return foods
    }
}
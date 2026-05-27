package com.cibertec.das.one.routes

object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val HOME = "home"
    const val DETAIL = "detail/{placeId}"

    fun detailRoute(placeId: Int): String = "detail/$placeId"
}

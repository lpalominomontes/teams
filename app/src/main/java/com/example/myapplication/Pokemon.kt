package com.example.myapplication

data class Pokemon(val id: Long, val name: String, val hp: Int, val attack: Int, val defense: Int, val speed: Int, val type: PokemonType, val imageURL: String) {
    enum class PokemonType {
        GRASS, FIRE, WATER, FIGHTER, ELECTRIC
    }
}
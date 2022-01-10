package com.example.pokemon

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class PokemonApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(PokemonApplication::class.java.getResource("poke-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 1000.0, 700.0)
        stage.title = "Pokémon"
        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
}

fun main() {
    Application.launch(PokemonApplication::class.java)
}
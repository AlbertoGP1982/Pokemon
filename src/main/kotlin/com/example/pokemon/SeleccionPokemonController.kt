package com.example.pokemon

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ProgressBar
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.HBox
import java.io.File


class SeleccionPokemonController {
    private var listaPoke = CargarPokemon.creaListaPokemon()

    @FXML private lateinit var name1 : Label
    @FXML private lateinit var name2 : Label
    @FXML private lateinit var name3 : Label
    @FXML private lateinit var name4 : Label
    @FXML private lateinit var name5 : Label
    @FXML private lateinit var name6 : Label

    @FXML private lateinit var level1 : Label
    @FXML private lateinit var level2 : Label
    @FXML private lateinit var level3 : Label
    @FXML private lateinit var level4 : Label
    @FXML private lateinit var level5 : Label
    @FXML private lateinit var level6 : Label

    @FXML private lateinit var cuadro1 : HBox
    @FXML private lateinit var cuadro2 : HBox
    @FXML private lateinit var cuadro3 : HBox
    @FXML private lateinit var cuadro4 : HBox
    @FXML private lateinit var cuadro5 : HBox
    @FXML private lateinit var cuadro6 : HBox

    @FXML private lateinit var imagen1 : ImageView
    @FXML private lateinit var imagen2 : ImageView
    @FXML private lateinit var imagen3 : ImageView
    @FXML private lateinit var imagen4 : ImageView
    @FXML private lateinit var imagen5 : ImageView
    @FXML private lateinit var imagen6 : ImageView

    @FXML private lateinit var sex1 : ImageView
    @FXML private lateinit var sex2 : ImageView
    @FXML private lateinit var sex3 : ImageView
    @FXML private lateinit var sex4 : ImageView
    @FXML private lateinit var sex5 : ImageView
    @FXML private lateinit var sex6 : ImageView

    @FXML private lateinit var health_bar_1 : ProgressBar
    @FXML private lateinit var health_bar_2 : ProgressBar
    @FXML private lateinit var health_bar_3 : ProgressBar
    @FXML private lateinit var health_bar_4 : ProgressBar
    @FXML private lateinit var health_bar_5 : ProgressBar
    @FXML private lateinit var health_bar_6 : ProgressBar

    @FXML private lateinit var health1 : Label
    @FXML private lateinit var health2 : Label
    @FXML private lateinit var health3 : Label
    @FXML private lateinit var health4 : Label
    @FXML private lateinit var health5 : Label
    @FXML private lateinit var health6 : Label

    @FXML private lateinit var b_close : Button

    private fun calcularProgressBar(poke : Pokemon) : Double{
        return poke.vidaActual.toDouble()/poke.vidaMax
    }

    fun configurarPokemon(name:Label, level:Label,imagen:ImageView,sexo:ImageView,health_bar:ProgressBar,health:Label, poke: Pokemon){
        var file : File
        name.text=poke.nombre
        level.text="Nv "+poke.nivel
        imagen.image = Image(poke.rutaImagen.toURI().toString())
        if (poke.sexo=='M') {
            sexo.image = Image(File("src\\main\\kotlin\\com\\example\\poke\\imagenes\\masculino.png").toURI().toString())
        }
        else if (poke.sexo=='F'){
            sexo.image = Image(File("src\\main\\kotlin\\com\\example\\poke\\imagenes\\femenino.png").toURI().toString())
        }
        health_bar.progress = calcularProgressBar(poke)
        health.text = poke.vidaActual.toString()+"/"+poke.vidaMax
    }

    fun initialize() {
        b_close.disableProperty().set(true)

        configurarPokemon(name1,level1,imagen1,sex1,health_bar_1,health1,listaPoke[0])
        configurarPokemon(name2,level2,imagen2,sex2,health_bar_2,health2,listaPoke[1])
        configurarPokemon(name3,level3,imagen3,sex3,health_bar_3,health3,listaPoke[2])
        configurarPokemon(name4,level4,imagen4,sex4,health_bar_4,health4,listaPoke[3])
        configurarPokemon(name5,level5,imagen5,sex5,health_bar_5,health5,listaPoke[4])
        configurarPokemon(name6,level6,imagen6,sex6,health_bar_6,health6,listaPoke[5])
    }

    fun estiloPokemonSelec(name:Label, level:Label,health:Label,cuadro:HBox){
        name.style = name.style+"-fx-text-fill: #70D3F4;"
        level.style = level.style+"-fx-text-fill: #70D3F4;"
        health.style = health.style+"-fx-text-fill: #70D3F4;"
        cuadro.style = cuadro.style+"-fx-border-color: white; -fx-background-color: #A99DB0;"
    }

    fun estiloPokemonNoSelec(name:Label, level:Label,health:Label,cuadro:HBox){
        name.style = name.style+"-fx-text-fill: white;"
        level.style = level.style+"-fx-text-fill: white;"
        health.style = health.style+"-fx-text-fill: white;"
        cuadro.style = cuadro.style+"-fx-border-color: black; -fx-background-color: #524659;"
    }

    @FXML private fun onPane1Click() {
        b_close.disableProperty().set(false)
        estiloPokemonSelec(name1, level1,health1,cuadro1)

        estiloPokemonNoSelec(name2, level2,health2,cuadro2)
        estiloPokemonNoSelec(name3, level3,health3,cuadro3)
        estiloPokemonNoSelec(name4, level4,health4,cuadro4)
        estiloPokemonNoSelec(name5, level5,health5,cuadro5)
        estiloPokemonNoSelec(name6, level6,health6,cuadro6)
    }

    @FXML private fun onPane2Click() {
        b_close.disableProperty().set(false)
        estiloPokemonSelec(name2, level2,health2,cuadro2)

        estiloPokemonNoSelec(name1, level1,health1,cuadro1)
        estiloPokemonNoSelec(name3, level3,health3,cuadro3)
        estiloPokemonNoSelec(name4, level4,health4,cuadro4)
        estiloPokemonNoSelec(name5, level5,health5,cuadro5)
        estiloPokemonNoSelec(name6, level6,health6,cuadro6)
    }

    @FXML private fun onPane3Click() {
        b_close.disableProperty().set(false)
        estiloPokemonSelec(name3, level3,health3,cuadro3)

        estiloPokemonNoSelec(name1, level1,health1,cuadro1)
        estiloPokemonNoSelec(name2, level2,health2,cuadro2)
        estiloPokemonNoSelec(name4, level4,health4,cuadro4)
        estiloPokemonNoSelec(name5, level5,health5,cuadro5)
        estiloPokemonNoSelec(name6, level6,health6,cuadro6)
    }

    @FXML private fun onPane4Click() {
        b_close.disableProperty().set(false)
        estiloPokemonSelec(name4, level4,health4,cuadro4)

        estiloPokemonNoSelec(name1, level1,health1,cuadro1)
        estiloPokemonNoSelec(name2, level2,health2,cuadro2)
        estiloPokemonNoSelec(name3, level3,health3,cuadro3)
        estiloPokemonNoSelec(name5, level5,health5,cuadro5)
        estiloPokemonNoSelec(name6, level6,health6,cuadro6)
    }

    @FXML private fun onPane5Click() {
        b_close.disableProperty().set(false)
        estiloPokemonSelec(name5, level5,health5,cuadro5)

        estiloPokemonNoSelec(name1, level1,health1,cuadro1)
        estiloPokemonNoSelec(name2, level2,health2,cuadro2)
        estiloPokemonNoSelec(name3, level3,health3,cuadro3)
        estiloPokemonNoSelec(name4, level4,health4,cuadro4)
        estiloPokemonNoSelec(name6, level6,health6,cuadro6)
    }

    @FXML private fun onPane6Click() {
        b_close.disableProperty().set(false)
        estiloPokemonSelec(name6, level6,health6,cuadro6)

        estiloPokemonNoSelec(name1, level1,health1,cuadro1)
        estiloPokemonNoSelec(name2, level2,health2,cuadro2)
        estiloPokemonNoSelec(name3, level3,health3,cuadro3)
        estiloPokemonNoSelec(name4, level4,health4,cuadro4)
        estiloPokemonNoSelec(name5, level5,health5,cuadro5)
    }
}

data class Pokemon(var nombre: String, var nivel:Int, var rutaImagen:File, var sexo: Char, var vidaActual: Int, var vidaMax: Int)

class CargarPokemon {
    companion object{
        fun creaListaPokemon():MutableList<Pokemon>{
            val dialga = Pokemon("Dialga",50,File("src\\main\\kotlin\\com\\example\\poke\\imagenes\\dialga.gif"),'M',100,200)
            val excadril = Pokemon("Excadril",50,File("src\\main\\kotlin\\com\\example\\poke\\imagenes\\excadrill.gif"),'F',129,200)
            val golett = Pokemon("Golett",50,File("src\\main\\kotlin\\com\\example\\poke\\imagenes\\golett.gif"),'M',77,200)
            val metagross = Pokemon("Metagross",50,File("src\\main\\kotlin\\com\\example\\poke\\imagenes\\metagross-mega.gif"),'F',41,200)
            val rhyhorn = Pokemon("Rhyhorn",50,File("src\\main\\kotlin\\com\\example\\poke\\imagenes\\rhyhorn.gif"),' ',20,200)
            val tentacruel = Pokemon("Tentacruel",50,File("src\\main\\kotlin\\com\\example\\poke\\imagenes\\tentacruel.gif"),'M',187,200)
            return mutableListOf(dialga,excadril,golett,metagross,rhyhorn,tentacruel)
        }
    }
}
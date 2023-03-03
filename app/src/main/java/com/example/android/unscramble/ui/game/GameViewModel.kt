package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



/**
* El ViewModel es un contenedor de estado.
* Los principales beneficios del ViewModel son:
*  - Te permite conservar el estado de la UI
*  - Proporciona acceso a la lógica empresarial
*
* El ViewModel permite la persistencia del estado que contiene un ViewModel
* y en las operaciones en las que este activa
* */
class GameViewModel : ViewModel() {
    /** Declara una variable privada mutable y otra variable publica inmutable y anulas
     * el getter de esta ultima devolviendo el valor de la variable privada,
     * esto con el fin de que no se pueda cambiar el valor de este campo desde afuera de la clase
     */
    private val _score = MutableLiveData<Int>(0)
    val score: LiveData<Int>
        get() = _score

    /**
     * Se repite el proceso descrito arriba, esta variable lleva el recuento de todas las palabras utilizadas hasta ahora
     *
     * */
    private val _currentWordCount = MutableLiveData<Int>(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    /**
     * LiveData contiene datos y notifica a un observador cuando los datos almacenados por el LiveData cambian
     */
    private val _currentScrambledWord = MutableLiveData<String>()
    val currentScrambleWord = LiveData<String>
        get() = _currentScrambledWord

    // Variable que almacena la lista de palabras que ya usaste en este juego, para evitar repeticiones
    private var wordList: MutableList<String> = mutableListOf()

    /**
     * Late Initialization: la mayoría de las veces, cuando inicializas una variable, le asignas un valor
     * adelante, sin embargo, si todavia no tenes un valor que asignarle a la variable podes
     * inicializarla más tarde, para esto se usa la palabra reservada lateinit
     */
    private lateinit var currentWord: String



    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordList.clear()
        getNextWord()
    }

    private fun increaseScore() {
        _score += SCORE_INCREASE
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        // Si la palabra que el usuario introdujo esta bien, aumentas el score
        if(playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

        // Función que agarra una palabra aleatoria y la guarda en la lista de palabras utilizadas
    private fun getNextWord() {
        // Agarra una palabra aleatoria y se la asgina a currentWord
        currentWord = allWordsList.random()

        /**
         * Transformas la palabra a un array de caracteres y mezclas los caracteres, despues validas
         * que la palabra mezclada sea diferente de la original
         */
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }

        Log.d("GameViewModel", "valor de wordlist: $wordList")


        /**
         * Si la palabra esta en la lista de palabras usada llama de vuelta a la función
         * Si no, almacenas la palabra pasada a String en la lista
         */
        if(wordList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord.value = String(tempWord)
            ++_currentWordCount
            wordList.add(currentWord)
        }
    }


    fun nextWord(): Boolean {
        // Llama a la función getNextWord si todavia no ha terminado el juego
        return if(_currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    /**
     * El init es el bloque inicializador, es el lugar donde se hace  la configuración inicial
     * que se necesita durante la instanciación de un objeto
     * */
    init {
        Log.d("GameFragment", "viewmodel creado")
        getNextWord()
    }


    /**
     * El ViewModel se destruye cuando el fragmento asociado es separado(ver ciclo de vida de
     * los fragmentos) o cuando una actividad es finalizada
     */
    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "ViewModel destruido")
    }

}
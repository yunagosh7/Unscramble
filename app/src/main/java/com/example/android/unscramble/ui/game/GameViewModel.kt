package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel



/*
* Capa de dominio: es una capa opcional que se encuentra entra la capa de la UI y la capa de datos.
* Es responsable de encapsular la lógica empresarial compleja o simple que uno o varios ViewModels utilizan
* Esta capa solo se debe utilizar cuando se busca administrar la complejidad o favorecer la
* reutilización o facilitar la expansión de la aplicación
*
* */
class GameViewModel : ViewModel() {
    private var _score = 0
    val score: Int
        get() = _score

    private var _currentWordCount = 0
    val currentWordCount: Int
        get() = _currentWordCount
    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var wordList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String



    fun reinitializeData() {
        _score = 0
        _currentWordCount = 0
        wordList.clear()
        getNextWord()
    }

    private fun increaseScore() {
        _score += SCORE_INCREASE
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        if(playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }


    private fun getNextWord() {
        currentWord = allWordsList.random()

        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }

        Log.d("GameViewModel", "valor de wordlist: $wordList")
        if(wordList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordList.add(currentWord)
        }
    }

    fun nextWord(): Boolean {
        return if(_currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    init {
        Log.d("GameFragment", "viewmodel creado")
        getNextWord()
    }




    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "viewmodel destruido")
    }

}
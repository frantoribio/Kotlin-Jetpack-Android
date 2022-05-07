package es.joseluisgs.jetpacktutorial.repositories

import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.services.FilmsProvider

class FilmsRepository {
    fun get(): List<Film> = FilmsProvider.get()
}
package uz.akbarali.models

class Movie {
    var name: String? = null
    var category: String? = null
    var releaseDate: String? = null
    var poster: Int? = null
    var rating: Float? = null

    constructor(
        name: String?,
        category: String?,
        releaseDate: String?,
        poster: Int?,
        rating: Float?
    ) {
        this.name = name
        this.category = category
        this.releaseDate = releaseDate
        this.poster = poster
        this.rating = rating
    }

    constructor()

}
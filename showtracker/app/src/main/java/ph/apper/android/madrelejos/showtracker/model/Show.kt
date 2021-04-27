package ph.apper.android.madrelejos.showtracker.model

//DATA CLASS with primary constructor
data class Show(val title: String, var type:ShowType, var genre: ShowGenres) {

    constructor() : this("", ShowType.UNDEFINED, ShowGenres.UNDEFINED)

}

enum class ShowType {
    UNDEFINED,
    ANIME,
    MOVIE,
    SERIES,
    OVA,
    SHORTFILMS;

    companion object {
        fun getType(type: String) =
            when(type){
                "ANIME" -> ANIME
                "MOIVE" -> MOVIE
                "SERIES" -> SERIES
                "OVA" -> OVA
                "SHORTFILMS" -> SHORTFILMS
                else -> UNDEFINED
            }
    }
}

enum class ShowGenres{
    UNDEFINED,
    DRAMA,
    COMEDY,
    HORROR,
    THRILLER,
    ACTION,
    ANIMATION,
    FOREIGN,
    ARTHOUSE,
    ROMANCE,
    FANTASY,
    SCIFI,
    DOCUMENTARY;

    companion object {
        fun getGenre(genre: String) =
            when(genre){
                "DRAMA" -> DRAMA
                 "COMEDY"-> COMEDY
                 "HORROR"-> HORROR
                 "THRILLER"-> THRILLER
                "ACTION" -> ACTION
                "ANIMATION" -> ANIMATION
                 "FOREIGN"-> FOREIGN
                "ARTHOUSE" -> ARTHOUSE
                "ROMANCE" -> ROMANCE
                "FANTASY" -> FANTASY
                "SCIFI" -> SCIFI
                "DOCUMENTARY" -> DOCUMENTARY
                else -> UNDEFINED
            }
    }
}
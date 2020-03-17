package com.lambdaschool.sprint4challenge_mymovies.apiaccess

object MovieConstants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY_PARAM = "&api_key=359211348348a13a2b996217f7538f45"
    const val FIXED_QUERY_PARAMS = "?language=en-US&page=1&include_adult=false"
    const val SEARCH_MOVIES_ENDPOINT = "search/movie$FIXED_QUERY_PARAMS"
    const val USER_QUERY = "&query="
    const val TO_SEARCH = SEARCH_MOVIES_ENDPOINT + API_KEY_PARAM + USER_QUERY// + "user's search"
}

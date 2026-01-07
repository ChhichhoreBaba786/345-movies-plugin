package com.movies345.

import com.lagradost.cloudstream3.MainAPI
import com.lagradost.cloudstream3.SearchResponse
import com.lagradost.cloudstream3.TvType

class ExampleProvider : MainAPI() { 
    override var mainUrl = "https://345movies.net" 
    override var name = "345 Movies"
    override val supportedTypes = setOf(TvType.Movie)

    override var lang = "en"
    override val hasMainPage = true

    override suspend fun search(query: String): List<SearchResponse> {
        return listOf()
    }
}

package com.example

import com.lagradost.cloudstream3.MainAPI
import com.lagradost.cloudstream3.SearchResponse
import com.lagradost.cloudstream3.TvType

class ExampleProvider : MainAPI() {
    override var mainUrl = "https://345movies.net"
    override var name = "345 Movies"
    override val supportedTypes = setOf(TvType.Movie)

    override var lang = "en"
    override val hasMainPage = true

    init {
        // Debug: confirms provider instantiation and shows configured address
        println("ExampleProvider initialized: $name ($mainUrl)")
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val q = query.trim()
        val encoded = q.replace(" ", "+")
        // Include the provider address in the returned URL so you can verify it's used
        val resultUrl = "$mainUrl/search?q=$encoded"

        return listOf(
            SearchResponse(
                name = "Test: $q",
                url = resultUrl,
                apiName = name,
                type = TvType.Movie,
                posterUrl = "$mainUrl/favicon.ico"
            )
        )
    }
}

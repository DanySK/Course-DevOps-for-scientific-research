package it.unibo.ci

import com.omertron.thetvdbapi.TheTVDBApi
import java.lang.IllegalStateException

const val LANG = "it"
fun main(vararg args: String) {
    val key = Thread.currentThread().contextClassLoader.getResource("TheTVDBAPIKey")?.readText()
        ?: throw IllegalStateException("Unable to find TheTVDB API Key")
    val series = args.takeIf { it.isNotEmpty() }?.asSequence() ?: sequenceOf("Breaking Bad")
    series.flatMap { serie ->
        with (TheTVDBApi(key)) {
            searchSeries(serie, LANG).asSequence()
                .filter { it.seriesName == serie }
                .flatMap { getAllEpisodes(it.id, LANG).asSequence() }
                .map { it.episodeName }
        }
    }.forEach { println(it) }
}

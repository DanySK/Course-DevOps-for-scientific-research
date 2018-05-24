package it.unibo.ci;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import com.omertron.thetvdbapi.TheTVDBApi;
import com.omertron.thetvdbapi.model.Episode;
import com.omertron.thetvdbapi.model.Series;
import static java.nio.charset.StandardCharsets.UTF_8;

public final class PrintBreakingBad {
    private static final String LANG = "it";
    private static final String SERIE = "Breaking Bad";
    private PrintBreakingBad() { }
    public static void main(String... args) throws ClassNotFoundException, IOException {
        final String key = IOUtils.toString(PrintBreakingBad.class.getResourceAsStream("/TheTVDBAPIKey"), UTF_8);
        final TheTVDBApi api = new TheTVDBApi(key);
        api.searchSeries(SERIE, LANG).stream()
            .filter(s -> s.getSeriesName().equals(SERIE))
            .map(Series::getId)
            .flatMap(s -> api.getAllEpisodes(s, LANG).stream())
            .map(Episode::getEpisodeName)
            .forEach(System.out::println);
    }
}

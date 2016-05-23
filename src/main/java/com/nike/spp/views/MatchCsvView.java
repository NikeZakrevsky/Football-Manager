package com.nike.spp.views;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.supercsv.io.ICsvBeanWriter;

import com.nike.spp.dto.Match;
 
/**
 * An implementation of the AbstractCsvView.
 * This decides what model data to be used to generate CSV data.
 * @author www.codejava.net
 *
 */
public class MatchCsvView extends AbstractCsvView {
 
    @Override
    protected void buildCsvDocument(ICsvBeanWriter csvWriter,
            Map<String, Object> model) throws IOException {
 
        List<Match> Matchs = (List<Match>) model.get("matches");
        String[] header = { "team1Name", "team2Name"};
 
        csvWriter.writeHeader(header);
 
        for (Match Match : Matchs) {
            csvWriter.write(Match, header);
        }
    }
}

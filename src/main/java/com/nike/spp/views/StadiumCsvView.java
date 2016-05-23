package com.nike.spp.views;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.supercsv.io.ICsvBeanWriter;

import com.nike.spp.dto.Team;

/**
 * An implementation of the AbstractCsvView. This decides what model data to be
 * used to generate CSV data.
 * 
 * @author www.codejava.net
 *
 */
public class StadiumCsvView extends AbstractCsvView {

	@Override
	protected void buildCsvDocument(ICsvBeanWriter csvWriter, Map<String, Object> model) throws IOException {

		List<Team> teams = (List<Team>) model.get("stadiums");
		String[] header = { "name" };

		csvWriter.writeHeader(header);

		for (Team team : teams) {
			csvWriter.write(team, header);
		}
	}
}

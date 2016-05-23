package com.nike.spp.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.nike.spp.dto.Stadium;

public class StadiumPDFView extends AbstractPdfView {
	protected void buildPdfDocument(Map model, Document document, PdfWriter writer, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		String s = "";
		List<Stadium> employee = (List<Stadium>) model.get("stadiums");
		for (Stadium stadium : employee) {
			s += "Stadium : " + stadium.getName() + " " + stadium.getCapacity() + " " + stadium.getTown() + "\r\n";
		}
		Paragraph header = new Paragraph(new Chunk("Generate Pdf", FontFactory.getFont(FontFactory.HELVETICA, 30)));
		Paragraph by = new Paragraph(new Chunk(s, FontFactory.getFont(FontFactory.HELVETICA, 20)));

		document.add(header);
		document.add(by);

	}

}
package com.nike.spp.views;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.pdf.PdfWriter;
import com.nike.spp.dto.Team;

public class PDFView extends AbstractPdfView {
	protected void buildPdfDocument(Map model, Document document, PdfWriter writer, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Phrase watermark = new Phrase("NoQueues", FontFactory.getFont(FontFactory.HELVETICA, 40,
				Font.BOLD, Color.GRAY));
		Rectangle pageSize = writer.getPageSize();
		float x = (pageSize.getLeft() + pageSize.getRight()) / 2;
		float y = (pageSize.getTop() + pageSize.getBottom()) / 2;
		PdfContentByte canvas = writer.getDirectContentUnder();
		ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, x, y, 45);
		String s = "";
		List<Team> employee = (List<Team>) model.get("command");
		for (Team team : employee) {
			s += "Team : " + team.getName() + "\r\n";
		}
		Paragraph header = new Paragraph(
				new Chunk("Generate Pdf", FontFactory.getFont(FontFactory.HELVETICA, 30)));
		Paragraph by = new Paragraph(new Chunk(s, FontFactory.getFont(FontFactory.HELVETICA, 20)));
		document.add(header);
		document.add(by);

	}


	private static void addWaterMark(PdfWriter writer) {
		Phrase watermark = new Phrase("NoQueues", FontFactory.getFont(FontFactory.HELVETICA, 40,
				Font.BOLD, Color.GRAY));
		Rectangle pageSize = writer.getPageSize();
		float x = (pageSize.getLeft() + pageSize.getRight()) / 2;
		float y = (pageSize.getTop() + pageSize.getBottom()) / 2;
		PdfContentByte canvas = writer.getDirectContentUnder();
		ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, x, y, 45);

	}

}
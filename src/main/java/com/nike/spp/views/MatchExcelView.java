package com.nike.spp.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.nike.spp.dto.Match;

public class MatchExcelView extends AbstractExcelView {
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Match> Matchs = (List<Match>) model.get("matches");
		HSSFSheet sheet = workbook.createSheet("Employee Report");

		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Team1");
		header.createCell(1).setCellValue("Team2");
		header.createCell(2).setCellValue("Score1");
		header.createCell(3).setCellValue("Score2");
		int counter = 1;
		for (Match e : Matchs) {
			HSSFRow row = sheet.createRow(counter++);
			row.createCell(0).setCellValue(e.getTeam1Name());
			row.createCell(1).setCellValue(e.getTeam2Name());
			row.createCell(2).setCellValue(e.getScoreFirst());
			row.createCell(3).setCellValue(e.getScoreSecond());
		}
	}
}
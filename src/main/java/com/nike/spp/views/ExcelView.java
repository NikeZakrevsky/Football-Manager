package com.nike.spp.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.nike.spp.dto.Team;

@SuppressWarnings("deprecation")
public class ExcelView extends AbstractExcelView {
 @Override
 protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
   HttpServletRequest request, HttpServletResponse response)
   throws Exception {

  List<Team> teams = (List<Team>) model.get("teams");
  HSSFSheet sheet = workbook.createSheet("Employee Report");

  HSSFRow header = sheet.createRow(0);
  header.createCell(0).setCellValue("Team name");

  int counter = 1;
  for (Team e : teams) {
   HSSFRow row = sheet.createRow(counter++);
   row.createCell(0).setCellValue(e.getName());
  }
 }
}
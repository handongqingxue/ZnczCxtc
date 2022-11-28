package com.znczCxtc.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;
import com.znczCxtc.util.*;

//https://www.cnblogs.com/RunningSnails/p/13275549.html
//https://www.cnblogs.com/wangjuns8/p/7243342.html
@Controller
@RequestMapping("/"+ExportExcelController.MODULE_NAME)
public class ExportExcelController {

	@Autowired
	private ExportExcelService exportExcelService;
	public static final String MODULE_NAME=Constant.EXPORT_EXCEL_MODULE_NAME;

	@RequestMapping(value="/exportGBJLList")
	public void exportGBJLList(String ddh,String cyclCph,String gbsjks,String gbsjjs,Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			System.out.println("ddh="+ddh);
			System.out.println("cyclCph="+cyclCph);
			System.out.println("gbsjks="+gbsjks);
			System.out.println("gbsjjs="+gbsjjs);
			System.out.println("page="+page);
			System.out.println("rows="+rows);
			System.out.println("dcfw="+dcfw);
			
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			HSSFSheet sheet = wb.createSheet("过磅记录");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("订单号");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("过磅重量");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("过磅状态");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("过磅类型");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("过磅时间");
			cell.setCellStyle(style);
			
			List<GuoBangJiLu> gbjlList = exportExcelService.queryGBJList(ddh, cyclCph, gbsjks, gbsjjs, page, rows, dcfw);
			for (int i = 0; i < gbjlList.size(); i++) {
				GuoBangJiLu gbjl = gbjlList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String ddh1 = gbjl.getDdh();
				if(ddh1!=""&&ddh1!=null)
					cell.setCellValue(ddh1);
				
				cell = row.createCell(1);
				String cyclCph1 = gbjl.getCyclCph();
				if(cyclCph1!=""&&cyclCph1!=null)
					cell.setCellValue(cyclCph1);
				
				cell = row.createCell(2);
				Float gbzl = gbjl.getGbzl();
				if(gbzl!=null)
					cell.setCellValue(gbzl);
				
				cell = row.createCell(3);
				Integer gbzt = gbjl.getGbzt();
				if(gbzt!=null)
					cell.setCellValue(gbzt==GuoBangJiLu.ZHENG_CHANG?GuoBangJiLu.ZHENG_CHANG_TEXT:GuoBangJiLu.YI_CHANG_TEXT);
				
				cell = row.createCell(4);
				Integer gblx = gbjl.getGblx();
				if(gblx!=null)
					cell.setCellValue(gblx==GuoBangJiLu.RU_CHANG_GUO_BANG?GuoBangJiLu.RU_CHANG_GUO_BANG_TEXT:GuoBangJiLu.CHU_CHANG_GUO_BANG_TEXT);
				
				cell = row.createCell(5);
				String gbsj = gbjl.getGbsj();
				if(gbsj!=""&&gbsj!=null)
					cell.setCellValue(gbsj);
			}
			
			download("过磅记录查询", wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void download(String fileName, HSSFWorkbook wb, HttpServletResponse response) throws IOException {  
	      ByteArrayOutputStream os = new ByteArrayOutputStream();
	      wb.write(os);
	      byte[] content = os.toByteArray();
	      InputStream is = new ByteArrayInputStream(content);
	      // 设置response参数，可以打开下载页面
	      response.reset();
	      response.setContentType("application/vnd.ms-excel;charset=utf-8");
	      response.setHeader("Content-Disposition", "attachment;filename="
	          + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
	      ServletOutputStream out = response.getOutputStream();
	      BufferedInputStream bis = null;
	      BufferedOutputStream bos = null;
	 
	      try {
	        bis = new BufferedInputStream(is);
	        bos = new BufferedOutputStream(out);
	        byte[] buff = new byte[2048];
	        int bytesRead;
	        // Simple read/write loop.
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	          bos.write(buff, 0, bytesRead);
	        }
	      } catch (Exception e) {
	        // TODO: handle exception
	        e.printStackTrace();
	      } finally {
	        if (bis != null)
	          bis.close();
	        if (bos != null)
	          bos.close();
	      }
    }
}

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
import java.net.URLDecoder;
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

	@RequestMapping(value="/exportDDZHCXList")
	public void exportDDZHCXList(String ddh,Integer ddztId,String ddztMc,String cyclCph,String jhysrq,String yssMc,String wzMc,
			String fhdwMc,String shdwMc,String cysjXm,String cysjSfzh,String jcsjs,String jcsje,String ccsjs,String ccsje,
			Integer page,Integer rows,int sheetFlag,int dcfw,HttpServletResponse response) {
		try {
			System.out.println("ddh="+ddh);
			System.out.println("ddztId="+ddztId);
			ddztMc=StringUtil.decode(ddztMc, "UTF-8");
			System.out.println("ddztMc="+ddztMc);
			System.out.println("cyclCph="+cyclCph);
			System.out.println("jhysrq="+jhysrq);
			System.out.println("yssMc="+yssMc);
			System.out.println("wzMc="+wzMc);
			System.out.println("fhdwMc="+fhdwMc);
			System.out.println("shdwMc="+shdwMc);
			System.out.println("cysjXm="+cysjXm);
			System.out.println("cysjSfzh="+cysjSfzh);
			System.out.println("jcsjs="+jcsjs);
			System.out.println("jcsje="+jcsje);
			System.out.println("ccsjs="+ccsjs);
			System.out.println("ccsje="+ccsje);
			System.out.println("page="+page);
			System.out.println("rows="+rows);
			System.out.println("sheetFlag="+sheetFlag);
			System.out.println("dcfw="+dcfw);
	
			int rowNum=0;
			//��һ��������һ��Workbook����Ӧһ��Excel�ļ�
			HSSFWorkbook wb=new HSSFWorkbook();
			//�ڶ�������Workbook�����һ��sheet����ӦExcel�ļ����sheet
			String sheetname = null;
			switch (sheetFlag) {
			case DingDanZhuangTai.DAI_SHEN_HE:
				sheetname = "����˶���";
				break;
			}
			HSSFSheet sheet = wb.createSheet(sheetname);
			
			createDDZHCXSheetHeader(wb,sheet,rowNum,sheetFlag);
			
			List<DingDan> ddList = exportExcelService.queryDDZHCXList(ddh, ddztId,ddztMc,cyclCph,jhysrq,yssMc,wzMc,fhdwMc,shdwMc,cysjXm,cysjSfzh,jcsjs,jcsje,ccsjs,ccsje, page, rows, dcfw);
			
			createDDZHCXSheetBody(ddList,sheet,rowNum,sheetFlag);

			String fileName = null;
			switch (sheetFlag) {
			case DingDanZhuangTai.DAI_SHEN_HE:
				fileName = "����˶�����ѯ";
				break;
			}
			download(fileName, wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createDDZHCXSheetHeader(HSSFWorkbook wb,HSSFSheet sheet,int rowNum,int sheetFlag) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCellStyle style = wb.createCellStyle();
		
		switch (sheetFlag) {
		case DingDanZhuangTai.DAI_SHEN_HE:
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("������");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("���ƺ�");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("��������");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("������");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("������λ");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("�ջ���λ");
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue("��������");
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue("�ƻ���������");
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue("Ԥװж����");
			cell.setCellStyle(style);
			break;
		}
	}
	
	public void createDDZHCXSheetBody(List<DingDan> ddList,HSSFSheet sheet,int rowNum,int sheetFlag) {
		switch (sheetFlag) {
		case DingDanZhuangTai.DAI_SHEN_HE:
			for (int i = 0; i < ddList.size(); i++) {
				DingDan dd = ddList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
	
				HSSFCell cell = row.createCell(0);
				String ddh1 = dd.getDdh();
				if(ddh1!=""&&ddh1!=null)
					cell.setCellValue(ddh1);
				
				cell = row.createCell(1);
				String cyclCph1 = dd.getCyclCph();
				if(cyclCph1!=""&&cyclCph1!=null)
					cell.setCellValue(cyclCph1);
				
				cell = row.createCell(2);
				String wzMc = dd.getWzMc();
				if(wzMc!=null)
					cell.setCellValue(wzMc);
				
				cell = row.createCell(3);
				String yssMc = dd.getYssMc();
				if(yssMc!=null)
					cell.setCellValue(yssMc);
				
				cell = row.createCell(4);
				String fhdwMc = dd.getFhdwMc();
				if(fhdwMc!=null)
					cell.setCellValue(fhdwMc);
					
				cell = row.createCell(5);
				String shdwMc = dd.getShdwMc();
				if(shdwMc!=""&&shdwMc!=null)
					cell.setCellValue(shdwMc);
				
				cell = row.createCell(6);
				Integer lxlx = dd.getLxlx();
				if(lxlx!=null) {
					String lxlxMc=null;
					switch (lxlx) {
					case DingDan.SONG_YUN:
						lxlxMc=DingDan.SONG_YUN_TEXT;
						break;
					case DingDan.QU_YUN:
						lxlxMc=DingDan.QU_YUN_TEXT;
						break;
					}
					cell.setCellValue(lxlxMc);
				}
				
				cell = row.createCell(7);
				String jhysrq = dd.getJhysrq();
				if(jhysrq!=""&&jhysrq!=null)
					cell.setCellValue(jhysrq);
				
				cell = row.createCell(8);
				Float yzxzl = dd.getYzxzl();
				if(yzxzl!=null)
					cell.setCellValue(yzxzl);
			}
			break;
	}
	}

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
			//��һ��������һ��Workbook����Ӧһ��Excel�ļ�
			HSSFWorkbook wb=new HSSFWorkbook();
			//�ڶ�������Workbook�����һ��sheet����ӦExcel�ļ����sheet
			HSSFSheet sheet = wb.createSheet("������¼");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("������");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("���ƺ�");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("��������");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("����״̬");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("��������");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("����ʱ��");
			cell.setCellStyle(style);
			
			List<GuoBangJiLu> gbjlList = exportExcelService.queryGBJLList(ddh, cyclCph, gbsjks, gbsjjs, page, rows, dcfw);
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
			
			download("������¼��ѯ", wb, response);
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
	      // ����response���������Դ�����ҳ��
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

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
			Integer page,Integer rows,Integer sheetFlag,int dcfw,HttpServletResponse response) {
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
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			String sheetname = null;
			switch (sheetFlag) {
			case DingDan.DAI_SHEN_HE_SHEET:
				sheetname = "待审核订单";
				break;
			case DingDanZhuangTai.DAI_JIAN_YAN:
				sheetname = "待质检订单";
				break;
			case DingDanZhuangTai.DAI_ZHUANG_XIE_HUO:
				sheetname = "待入库订单";
				break;
			case DingDan.ZONG_HE_CHA_XUN_SHEET:
				sheetname = "订单综合查询";
				break;
			}
			HSSFSheet sheet = wb.createSheet(sheetname);
			
			createDDZHCXSheetHeader(wb,sheet,rowNum,sheetFlag);
			
			List<DingDan> ddList = exportExcelService.queryDDZHCXList(ddh, ddztId,ddztMc,cyclCph,jhysrq,yssMc,wzMc,fhdwMc,shdwMc,cysjXm,cysjSfzh,jcsjs,jcsje,ccsjs,ccsje, page, rows, dcfw);
			
			createDDZHCXSheetBody(ddList,sheet,rowNum,sheetFlag);

			String fileName = null;
			switch (sheetFlag) {
			case DingDanZhuangTai.DAI_SHEN_HE:
				fileName = "待审核订单查询";
				break;
			case DingDanZhuangTai.DAI_JIAN_YAN:
				fileName = "待质检订单查询";
				break;
			case DingDanZhuangTai.DAI_ZHUANG_XIE_HUO:
				fileName = "待入库订单查询";
				break;
			case DingDan.ZONG_HE_CHA_XUN_SHEET:
				fileName = "订单综合查询";
				break;
			}
			download(fileName, wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据不同表格标识创建表头，调用同一个订单综合查询接口，只是表头显示的列不同，这里需要判断下
	 * @param wb
	 * @param sheet
	 * @param rowNum
	 * @param sheetFlag
	 */
	public void createDDZHCXSheetHeader(HSSFWorkbook wb,HSSFSheet sheet,int rowNum,Integer sheetFlag) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCellStyle style = wb.createCellStyle();
		
		HSSFCell cell = null;
		switch (sheetFlag) {
		case DingDan.DAI_SHEN_HE_SHEET:
		case DingDan.DAI_JIAN_YAN_SHEET:
			cell = row.createCell(0);
			cell.setCellValue("订单号");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("物资名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("运输商");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("发货单位");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("收货单位");
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue("流向类型");
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue("计划运输日期");
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue("预装卸重量");
			cell.setCellStyle(style);
			break;
		case DingDan.DAI_ZHUANG_XIE_HUO_SHEET:
			cell = row.createCell(0);
			cell.setCellValue("订单号");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("司机身份证号");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("司机姓名");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("物资名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("运输商");
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue("发货单位");
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue("收货单位");
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue("流向类型");
			cell.setCellStyle(style);
			
			cell = row.createCell(9);
			cell.setCellValue("预装卸重量");
			cell.setCellStyle(style);
			
			cell = row.createCell(10);
			cell.setCellValue("实际重量");
			cell.setCellStyle(style);
			
			cell = row.createCell(11);
			cell.setCellValue("重量差额比");
			cell.setCellStyle(style);
			
			cell = row.createCell(12);
			cell.setCellValue("编辑时间");
			cell.setCellStyle(style);
			break;
		case DingDan.ZONG_HE_CHA_XUN_SHEET:
			cell = row.createCell(0);
			cell.setCellValue("订单号");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("司机身份证号");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("物资类型");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("物资名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("运输商");
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue("发货单位");
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue("收货单位");
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue("流向类型");
			cell.setCellStyle(style);
			
			cell = row.createCell(9);
			cell.setCellValue("计划运输日期");
			cell.setCellStyle(style);
			
			cell = row.createCell(10);
			cell.setCellValue("订单状态");
			cell.setCellStyle(style);
			
			cell = row.createCell(11);
			cell.setCellValue("一检状态");
			cell.setCellStyle(style);
			
			cell = row.createCell(12);
			cell.setCellValue("二检状态");
			cell.setCellStyle(style);
			
			cell = row.createCell(13);
			cell.setCellValue("一检地磅");
			cell.setCellStyle(style);
			
			cell = row.createCell(14);
			cell.setCellValue("二检地磅");
			cell.setCellStyle(style);
			
			cell = row.createCell(15);
			cell.setCellValue("预装卸重量");
			cell.setCellStyle(style);
			
			cell = row.createCell(16);
			cell.setCellValue("编辑时间");
			cell.setCellStyle(style);
			
			cell = row.createCell(17);
			cell.setCellValue("进厂时间");
			cell.setCellStyle(style);
			
			cell = row.createCell(18);
			cell.setCellValue("出厂时间");
			cell.setCellStyle(style);
			
			cell = row.createCell(19);
			cell.setCellValue("毛重");
			cell.setCellStyle(style);
			
			cell = row.createCell(20);
			cell.setCellValue("皮重");
			cell.setCellStyle(style);
			
			cell = row.createCell(21);
			cell.setCellValue("实际重量");
			cell.setCellStyle(style);
			
			cell = row.createCell(22);
			cell.setCellValue("对方过磅毛重");
			cell.setCellStyle(style);
			
			cell = row.createCell(23);
			cell.setCellValue("对方过磅皮重");
			cell.setCellStyle(style);
			
			cell = row.createCell(24);
			cell.setCellValue("对方过磅净重");
			cell.setCellStyle(style);
			break;
		}
	}
	
	public void createDDZHCXSheetBody(List<DingDan> ddList,HSSFSheet sheet,int rowNum,Integer sheetFlag) {
		switch (sheetFlag) {
		case DingDan.DAI_SHEN_HE_SHEET:
		case DingDan.DAI_JIAN_YAN_SHEET:
			for (int i = 0; i < ddList.size(); i++) {
				DingDan dd = ddList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
	
				HSSFCell cell = row.createCell(0);
				String ddh = dd.getDdh();
				if(ddh!=""&&ddh!=null)
					cell.setCellValue(ddh);
				
				cell = row.createCell(1);
				String cyclCph = dd.getCyclCph();
				if(cyclCph!=""&&cyclCph!=null)
					cell.setCellValue(cyclCph);
				
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
		case DingDan.DAI_ZHUANG_XIE_HUO_SHEET:
			for (int i = 0; i < ddList.size(); i++) {
				DingDan dd = ddList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
	
				HSSFCell cell = row.createCell(0);
				String ddh = dd.getDdh();
				if(ddh!=""&&ddh!=null)
					cell.setCellValue(ddh);
				
				cell = row.createCell(1);
				String cysjSfzh = dd.getCysjSfzh();
				if(cysjSfzh!=""&&cysjSfzh!=null)
					cell.setCellValue(cysjSfzh);
				
				cell = row.createCell(2);
				String cysjXm = dd.getCysjXm();
				if(cysjXm!=""&&cysjXm!=null)
					cell.setCellValue(cysjXm);
				
				cell = row.createCell(3);
				String cyclCph = dd.getCyclCph();
				if(cyclCph!=""&&cyclCph!=null)
					cell.setCellValue(cyclCph);
				
				cell = row.createCell(4);
				String wzMc = dd.getWzMc();
				if(wzMc!=null)
					cell.setCellValue(wzMc);
				
				cell = row.createCell(5);
				String yssMc = dd.getYssMc();
				if(yssMc!=null)
					cell.setCellValue(yssMc);
				
				cell = row.createCell(6);
				String fhdwMc = dd.getFhdwMc();
				if(fhdwMc!=null)
					cell.setCellValue(fhdwMc);
					
				cell = row.createCell(7);
				String shdwMc = dd.getShdwMc();
				if(shdwMc!=""&&shdwMc!=null)
					cell.setCellValue(shdwMc);
				
				cell = row.createCell(8);
				Integer lxlx = dd.getLxlx();
				if(lxlx!=null) {
					String lxlxMc=Constant.getLxlxMcById(lxlx);
					cell.setCellValue(lxlxMc);
				}
				
				cell = row.createCell(9);
				Float yzxzl = dd.getYzxzl();
				if(yzxzl!=null)
					cell.setCellValue(yzxzl);
				
				cell = row.createCell(10);
				Float sjzl = dd.getSjzl();
				if(sjzl!=null)
					cell.setCellValue(sjzl);
				
				cell = row.createCell(11);
				Float zlceb = dd.getZlceb();
				if(zlceb!=null)
					cell.setCellValue(zlceb);
				
				cell = row.createCell(12);
				String bjsj = dd.getBjsj();
				if(bjsj!=""&&bjsj!=null)
					cell.setCellValue(bjsj);
			}
			break;
		case DingDan.ZONG_HE_CHA_XUN_SHEET:
			for (int i = 0; i < ddList.size(); i++) {
				DingDan dd = ddList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
	
				HSSFCell cell = row.createCell(0);
				String ddh = dd.getDdh();
				if(ddh!=""&&ddh!=null)
					cell.setCellValue(ddh);
				
				cell = row.createCell(1);
				String cysjSfzh = dd.getCysjSfzh();
				if(cysjSfzh!=""&&cysjSfzh!=null)
					cell.setCellValue(cysjSfzh);
				
				cell = row.createCell(2);
				String wzlxMc = dd.getWzlxMc();
				if(wzlxMc!=null)
					cell.setCellValue(wzlxMc);
				
				cell = row.createCell(3);
				String wzMc = dd.getWzMc();
				if(wzMc!=null)
					cell.setCellValue(wzMc);
				
				cell = row.createCell(3);
				String cyclCph = dd.getCyclCph();
				if(cyclCph!=""&&cyclCph!=null)
					cell.setCellValue(cyclCph);
				
				cell = row.createCell(5);
				String yssMc = dd.getYssMc();
				if(yssMc!=null)
					cell.setCellValue(yssMc);
				
				cell = row.createCell(6);
				String fhdwMc = dd.getFhdwMc();
				if(fhdwMc!=null)
					cell.setCellValue(fhdwMc);
					
				cell = row.createCell(7);
				String shdwMc = dd.getShdwMc();
				if(shdwMc!=""&&shdwMc!=null)
					cell.setCellValue(shdwMc);
				
				cell = row.createCell(8);
				Integer lxlx = dd.getLxlx();
				if(lxlx!=null) {
					String lxlxMc=Constant.getLxlxMcById(lxlx);
					cell.setCellValue(lxlxMc);
				}
				
				cell = row.createCell(9);
				String jhysrq = dd.getJhysrq();
				if(jhysrq!=""&&jhysrq!=null)
					cell.setCellValue(jhysrq);
				
				cell = row.createCell(10);
				String ddztMc = dd.getDdztMc();
				if(ddztMc!=""&&ddztMc!=null)
					cell.setCellValue(ddztMc);
				
				cell = row.createCell(11);
				Integer yjzt = dd.getYjzt();
				if(yjzt!=null) {
					String yjztMc=Constant.getGbztMcById(yjzt);
					cell.setCellValue(yjztMc);
				}
				
				cell = row.createCell(12);
				Integer ejzt = dd.getEjzt();
				if(ejzt!=null) {
					String ejztMc=Constant.getGbztMcById(ejzt);
					cell.setCellValue(ejztMc);
				}
				
				cell = row.createCell(13);
				Integer yjbfh = dd.getYjbfh();
				if(yjbfh!=null) {
					String yjbfhMc=Constant.getBfMcByBfh(yjbfh);
					cell.setCellValue(yjbfhMc);
				}
				
				cell = row.createCell(14);
				Integer ejbfh = dd.getEjbfh();
				if(ejbfh!=null) {
					String ejbfhMc=Constant.getBfMcByBfh(ejbfh);
					cell.setCellValue(ejbfhMc);
				}
				
				cell = row.createCell(15);
				Float yzxzl = dd.getYzxzl();
				if(yzxzl!=null)
					cell.setCellValue(yzxzl);
				
				cell = row.createCell(16);
				String bjsj = dd.getBjsj();
				if(bjsj!=""&&bjsj!=null)
					cell.setCellValue(bjsj);
				
				cell = row.createCell(17);
				String jcsj = dd.getJcsj();
				if(jcsj!=""&&jcsj!=null)
					cell.setCellValue(jcsj);
				
				cell = row.createCell(18);
				String ccsj = dd.getCcsj();
				if(ccsj!=""&&ccsj!=null)
					cell.setCellValue(ccsj);
				
				cell = row.createCell(19);
				Float mz = dd.getMz();
				if(mz!=null)
					cell.setCellValue(mz);
				
				cell = row.createCell(20);
				Float pz = dd.getPz();
				if(pz!=null)
					cell.setCellValue(pz);
				
				cell = row.createCell(21);
				Float sjzl = dd.getSjzl();
				if(sjzl!=null)
					cell.setCellValue(sjzl);
				
				cell = row.createCell(22);
				Float dfgbpz = dd.getDfgbpz();
				if(dfgbpz!=null)
					cell.setCellValue(dfgbpz);
				
				cell = row.createCell(23);
				Float dfgbmz = dd.getDfgbmz();
				if(dfgbmz!=null)
					cell.setCellValue(dfgbmz);
				
				cell = row.createCell(24);
				Float dfgbjz = dd.getDfgbjz();
				if(dfgbjz!=null)
					cell.setCellValue(dfgbjz);
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

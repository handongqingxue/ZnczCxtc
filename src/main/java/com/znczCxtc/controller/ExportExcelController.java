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

import org.apache.commons.lang.StringUtils;
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
			case DingDan.DAI_JIAN_YAN_SHEET:
				sheetname = "待质检订单";
				break;
			case DingDan.DAI_ZHUANG_XIE_HUO_SHEET:
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
			case DingDan.DAI_SHEN_HE_SHEET:
				fileName = "待审核订单查询";
				break;
			case DingDan.DAI_JIAN_YAN_SHEET:
				fileName = "待质检订单查询";
				break;
			case DingDan.DAI_ZHUANG_XIE_HUO_SHEET:
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
				if(!StringUtils.isBlank(ddh))
					cell.setCellValue(ddh);
				
				cell = row.createCell(1);
				String cyclCph = dd.getCyclCph();
				if(!StringUtils.isBlank(cyclCph))
					cell.setCellValue(cyclCph);
				
				cell = row.createCell(2);
				String wzMc = dd.getWzMc();
				if(!StringUtils.isBlank(wzMc))
					cell.setCellValue(wzMc);
				
				cell = row.createCell(3);
				String yssMc = dd.getYssMc();
				if(!StringUtils.isBlank(yssMc))
					cell.setCellValue(yssMc);
				
				cell = row.createCell(4);
				String fhdwMc = dd.getFhdwMc();
				if(!StringUtils.isBlank(fhdwMc))
					cell.setCellValue(fhdwMc);
					
				cell = row.createCell(5);
				String shdwMc = dd.getShdwMc();
				if(!StringUtils.isBlank(shdwMc))
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
				if(!StringUtils.isBlank(jhysrq))
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
				if(!StringUtils.isBlank(ddh))
					cell.setCellValue(ddh);
				
				cell = row.createCell(1);
				String cysjSfzh = dd.getCysjSfzh();
				if(!StringUtils.isBlank(cysjSfzh))
					cell.setCellValue(cysjSfzh);
				
				cell = row.createCell(2);
				String cysjXm = dd.getCysjXm();
				if(!StringUtils.isBlank(cysjXm))
					cell.setCellValue(cysjXm);
				
				cell = row.createCell(3);
				String cyclCph = dd.getCyclCph();
				if(!StringUtils.isBlank(cyclCph))
					cell.setCellValue(cyclCph);
				
				cell = row.createCell(4);
				String wzMc = dd.getWzMc();
				if(!StringUtils.isBlank(wzMc))
					cell.setCellValue(wzMc);
				
				cell = row.createCell(5);
				String yssMc = dd.getYssMc();
				if(!StringUtils.isBlank(yssMc))
					cell.setCellValue(yssMc);
				
				cell = row.createCell(6);
				String fhdwMc = dd.getFhdwMc();
				if(!StringUtils.isBlank(fhdwMc))
					cell.setCellValue(fhdwMc);
					
				cell = row.createCell(7);
				String shdwMc = dd.getShdwMc();
				if(!StringUtils.isBlank(shdwMc))
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
				if(!StringUtils.isBlank(bjsj))
					cell.setCellValue(bjsj);
			}
			break;
		case DingDan.ZONG_HE_CHA_XUN_SHEET:
			for (int i = 0; i < ddList.size(); i++) {
				DingDan dd = ddList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
	
				HSSFCell cell = row.createCell(0);
				String ddh = dd.getDdh();
				if(!StringUtils.isBlank(ddh))
					cell.setCellValue(ddh);
				
				cell = row.createCell(1);
				String cysjSfzh = dd.getCysjSfzh();
				if(!StringUtils.isBlank(cysjSfzh))
					cell.setCellValue(cysjSfzh);
				
				cell = row.createCell(2);
				String wzlxMc = dd.getWzlxMc();
				if(!StringUtils.isBlank(wzlxMc))
					cell.setCellValue(wzlxMc);
				
				cell = row.createCell(3);
				String wzMc = dd.getWzMc();
				if(!StringUtils.isBlank(wzMc))
					cell.setCellValue(wzMc);
				
				cell = row.createCell(4);
				String cyclCph = dd.getCyclCph();
				if(!StringUtils.isBlank(cyclCph))
					cell.setCellValue(cyclCph);
				
				cell = row.createCell(5);
				String yssMc = dd.getYssMc();
				if(!StringUtils.isBlank(yssMc))
					cell.setCellValue(yssMc);
				
				cell = row.createCell(6);
				String fhdwMc = dd.getFhdwMc();
				if(!StringUtils.isBlank(fhdwMc))
					cell.setCellValue(fhdwMc);
					
				cell = row.createCell(7);
				String shdwMc = dd.getShdwMc();
				if(!StringUtils.isBlank(shdwMc))
					cell.setCellValue(shdwMc);
				
				cell = row.createCell(8);
				Integer lxlx = dd.getLxlx();
				if(lxlx!=null) {
					String lxlxMc=Constant.getLxlxMcById(lxlx);
					cell.setCellValue(lxlxMc);
				}
				
				cell = row.createCell(9);
				String jhysrq = dd.getJhysrq();
				if(!StringUtils.isBlank(jhysrq))
					cell.setCellValue(jhysrq);
				
				cell = row.createCell(10);
				String ddztMc = dd.getDdztMc();
				if(!StringUtils.isBlank(ddztMc))
					cell.setCellValue(ddztMc);
				
				cell = row.createCell(11);
				Integer yjzt = dd.getYjzt();
				if(yjzt!=null) {
					String yjztMc=Constant.getDdGbztMcById(yjzt);
					cell.setCellValue(yjztMc);
				}
				
				cell = row.createCell(12);
				Integer ejzt = dd.getEjzt();
				if(ejzt!=null) {
					String ejztMc=Constant.getDdGbztMcById(ejzt);
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
				if(!StringUtils.isBlank(bjsj))
					cell.setCellValue(bjsj);
				
				cell = row.createCell(17);
				String jcsj = dd.getJcsj();
				if(!StringUtils.isBlank(jcsj))
					cell.setCellValue(jcsj);
				
				cell = row.createCell(18);
				String ccsj = dd.getCcsj();
				if(!StringUtils.isBlank(ccsj))
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

	@RequestMapping(value="/exportDDSHJLList")
	public void exportDDSHJLList(String ddh,Integer shlx,String shsjks,String shsjjs,String cyclCph,String shrYhm,
			String yssMc,String wzMc,String fhdwMc,String shdwMc,String sjXm,String sjSfzh,Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			System.out.println("ddh="+ddh);
			System.out.println("shlx="+shlx);
			System.out.println("shsjks="+shsjks);
			System.out.println("shsjjs="+shsjjs);
			System.out.println("cyclCph="+cyclCph);
			System.out.println("shrYhm="+shrYhm);
			System.out.println("yssMc="+yssMc);
			System.out.println("wzMc="+wzMc);
			System.out.println("fhdwMc="+fhdwMc);
			System.out.println("shdwMc="+shdwMc);
			System.out.println("sjXm="+sjXm);
			System.out.println("sjSfzh="+sjSfzh);
			System.out.println("page="+page);
			System.out.println("rows="+rows);
			System.out.println("dcfw="+dcfw);
		
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			HSSFSheet sheet = wb.createSheet("订单审核记录");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("订单号");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("审核类型");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("审核时间");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("审核结果");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("审核人");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("司机身份证号");
			cell.setCellStyle(style);
		
			cell = row.createCell(6);
			cell.setCellValue("司机姓名");
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue("物资名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(9);
			cell.setCellValue("运输商");
			cell.setCellStyle(style);
			
			cell = row.createCell(10);
			cell.setCellValue("发货单位");
			cell.setCellStyle(style);
			
			cell = row.createCell(11);
			cell.setCellValue("收货单位");
			cell.setCellStyle(style);
			
			cell = row.createCell(12);
			cell.setCellValue("流向类型");
			cell.setCellStyle(style);
		
			cell = row.createCell(13);
			cell.setCellValue("预装卸重量");
			cell.setCellStyle(style);
			
			cell = row.createCell(14);
			cell.setCellValue("实际重量");
			cell.setCellStyle(style);
			
			cell = row.createCell(15);
			cell.setCellValue("重量差额比");
			cell.setCellStyle(style);

			List<DingDanShenHeJiLu> ddshjlList = exportExcelService.queryDDSHJLList(ddh,shlx,shsjks,shsjjs,cyclCph,shrYhm,yssMc,wzMc,fhdwMc,shdwMc,sjXm,sjSfzh, page, rows, dcfw);
			for (int i = 0; i < ddshjlList.size(); i++) {
				DingDanShenHeJiLu ddshjl = ddshjlList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String ddh1 = ddshjl.getDdh();
				if(ddh1!=""&&ddh1!=null)
					cell.setCellValue(ddh1);
				
				cell = row.createCell(1);
				Integer shlx1 = ddshjl.getShlx();
				if(shlx1!=null) {
					String shlxMc=Constant.getDdShlxMcById(shlx1);
					cell.setCellValue(shlxMc);
				}
				
				cell = row.createCell(2);
				String shsj = ddshjl.getShsj();
				if(!StringUtils.isBlank(shsj))
					cell.setCellValue(shsj);
				
				cell = row.createCell(3);
				Boolean shjg = ddshjl.getShjg();
				if(shjg!=null) {
					String shjgMc=Constant.getDdShjgMcByJg(shjg);
					cell.setCellValue(shjgMc);
				}
				
				cell = row.createCell(4);
				String shrYhm1 = ddshjl.getShrYhm();
				if(!StringUtils.isBlank(shrYhm1))
					cell.setCellValue(shrYhm1);
				
				cell = row.createCell(5);
				String sjSfzh1 = ddshjl.getSjSfzh();
				if(!StringUtils.isBlank(sjSfzh1))
					cell.setCellValue(sjSfzh1);
				
				cell = row.createCell(6);
				String sjXm1 = ddshjl.getSjXm();
				if(!StringUtils.isBlank(sjXm1))
					cell.setCellValue(sjXm1);
				
				cell = row.createCell(7);
				String cyclCph1 = ddshjl.getCyclCph();
				if(!StringUtils.isBlank(cyclCph1))
					cell.setCellValue(cyclCph1);
				
				cell = row.createCell(8);
				String wzMc1 = ddshjl.getWzMc();
				if(!StringUtils.isBlank(wzMc1))
					cell.setCellValue(wzMc1);
				
				cell = row.createCell(9);
				String yssMc1 = ddshjl.getYssMc();
				if(!StringUtils.isBlank(yssMc1))
					cell.setCellValue(yssMc1);
				
				cell = row.createCell(10);
				String fhdwMc1 = ddshjl.getFhdwMc();
				if(!StringUtils.isBlank(fhdwMc1))
					cell.setCellValue(fhdwMc1);
				
				cell = row.createCell(11);
				String shdwMc1 = ddshjl.getShdwMc();
				if(!StringUtils.isBlank(shdwMc1))
					cell.setCellValue(shdwMc1);
				
				cell = row.createCell(12);
				Integer lxlx = ddshjl.getLxlx();
				if(lxlx!=null) {
					String lxlxMc=Constant.getLxlxMcById(lxlx);
					cell.setCellValue(lxlxMc);
				}
				
				cell = row.createCell(13);
				Float yzxzl = ddshjl.getYzxzl();
				if(yzxzl!=null)
					cell.setCellValue(yzxzl);
				
				cell = row.createCell(14);
				Float sjzl = ddshjl.getSjzl();
				if(sjzl!=null)
					cell.setCellValue(sjzl);
				
				cell = row.createCell(15);
				Float zlceb = ddshjl.getZlceb();
				if(zlceb!=null)
					cell.setCellValue(zlceb);
			}
			
			download("订单审核记录查询", wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/exportBDJLList")
	public void exportBDJLList(String ddh,Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			System.out.println("ddh="+ddh);
			System.out.println("page="+page);
			System.out.println("rows="+rows);
			System.out.println("dcfw="+dcfw);
	
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			HSSFSheet sheet = wb.createSheet("磅单记录");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("订单号");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("毛重");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("皮重");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("净重");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("日期");
			cell.setCellStyle(style);
		
			List<BangDanJiLu> bdjlList = exportExcelService.queryBDJLList(ddh, page, rows, dcfw);
			for (int i = 0; i < bdjlList.size(); i++) {
				BangDanJiLu bdjl = bdjlList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String ddh1 = bdjl.getDdh();
				if(ddh1!=""&&ddh1!=null)
					cell.setCellValue(ddh1);
				
				cell = row.createCell(1);
				Float mz = bdjl.getMz();
				if(mz!=null)
					cell.setCellValue(mz);
				
				cell = row.createCell(2);
				Float pz = bdjl.getPz();
				if(pz!=null)
					cell.setCellValue(pz);
				
				cell = row.createCell(3);
				Float jz = bdjl.getJz();
				if(jz!=null)
					cell.setCellValue(jz);
				
				cell = row.createCell(4);
				String rq = bdjl.getRq();
				if(!StringUtils.isBlank(rq))
					cell.setCellValue(rq);
			}
			
			download("磅单记录查询", wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@RequestMapping(value="/exportDJYList")
	public void exportDJYList(String ddh,String ddztMc,String cysjXm,String cysjSfzh,String cyclCph,String yssMc,String fhdwMc,
			String shdwMc,String gbsjks,String gbsjjs,Integer gblx,Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			System.out.println("ddh="+ddh);
			ddztMc=StringUtil.decode(ddztMc, "UTF-8");
			System.out.println("ddztMc="+ddztMc);
			System.out.println("cysjXm="+cysjXm);
			System.out.println("cysjSfzh="+cysjSfzh);
			System.out.println("cyclCph="+cyclCph);
			System.out.println("yssMc="+yssMc);
			System.out.println("fhdwMc="+fhdwMc);
			System.out.println("shdwMc="+shdwMc);
			System.out.println("gbsjks="+gbsjks);
			System.out.println("gbsjjs="+gbsjjs);
			System.out.println("gblx="+gblx);
			System.out.println("page="+page);
			System.out.println("rows="+rows);
			System.out.println("dcfw="+dcfw);
		
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			
			
			String sheetname = null;
			if(DingDanZhuangTai.YI_JIAN_DAI_SHEN_HE_TEXT.equals(ddztMc)&&GuoBangJiLu.RU_CHANG_GUO_BANG==gblx)
				sheetname = "一检待审核";
			else if(DingDanZhuangTai.ER_JIAN_DAI_SHEN_HE_TEXT.equals(ddztMc)&&GuoBangJiLu.CHU_CHANG_GUO_BANG==gblx)
				sheetname = "二检待审核";
			HSSFSheet sheet = wb.createSheet(sheetname);
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("订单号");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("司机姓名");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("司机身份证号");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
		
			cell = row.createCell(4);
			cell.setCellValue("运输商");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("发货单位");
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue("收货单位");
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue("流向类型");
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue("过磅重量");
			cell.setCellStyle(style);
			
			cell = row.createCell(9);
			cell.setCellValue("过磅状态");
			cell.setCellStyle(style);
			
			cell = row.createCell(10);
			cell.setCellValue("过磅时间");
			cell.setCellStyle(style);
		
			List<GuoBangJiLu> gbjlList = exportExcelService.queryDJYList(ddh,ddztMc,cysjXm,cysjSfzh,cyclCph,yssMc,fhdwMc,shdwMc,
					gbsjks,gbsjjs,gblx,page, rows, dcfw);
			for (int i = 0; i < gbjlList.size(); i++) {
				GuoBangJiLu gbjl = gbjlList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String ddh1 = gbjl.getDdh();
				if(ddh1!=""&&ddh1!=null)
					cell.setCellValue(ddh1);
				
				cell = row.createCell(1);
				String cysjXm1 = gbjl.getCysjXm();
				if(!StringUtils.isBlank(cysjXm1))
					cell.setCellValue(cysjXm1);
				
				cell = row.createCell(2);
				String cysjSfzh1 = gbjl.getCysjSfzh();
				if(!StringUtils.isBlank(cysjSfzh1))
					cell.setCellValue(cysjSfzh1);
				
				cell = row.createCell(3);
				String cyclCph1 = gbjl.getCyclCph();
				if(!StringUtils.isBlank(cyclCph1))
					cell.setCellValue(cyclCph1);
				
				cell = row.createCell(4);
				String yssMc1 = gbjl.getYssMc();
				if(!StringUtils.isBlank(yssMc1))
					cell.setCellValue(yssMc1);
				
				cell = row.createCell(5);
				String fhdwMc1 = gbjl.getFhdwMc();
				if(!StringUtils.isBlank(fhdwMc1))
					cell.setCellValue(fhdwMc1);
				
				cell = row.createCell(6);
				String shdwMc1 = gbjl.getShdwMc();
				if(!StringUtils.isBlank(shdwMc1))
					cell.setCellValue(shdwMc1);
				
				cell = row.createCell(7);
				Integer lxlx = gbjl.getLxlx();
				if(lxlx!=null) {
					String lxlxMc=Constant.getLxlxMcById(lxlx);
					cell.setCellValue(lxlxMc);
				}
				
				cell = row.createCell(8);
				Float gbzl = gbjl.getGbzl();
				if(gbzl!=null)
					cell.setCellValue(gbzl);
				
				cell = row.createCell(9);
				Integer gbzt = gbjl.getGbzt();
				if(gbzt!=null) {
					String gbztMc=Constant.getGbjlGbztMcById(gbzt);
					cell.setCellValue(gbztMc);
				}
				
				cell = row.createCell(10);
				String gbsj = gbjl.getGbsj();
				if(!StringUtils.isBlank(gbsj))
					cell.setCellValue(gbsj);
			}

			String fileName = null;
			if(DingDanZhuangTai.YI_JIAN_DAI_SHEN_HE_TEXT.equals(ddztMc)&&GuoBangJiLu.RU_CHANG_GUO_BANG==gblx)
				fileName = "一检待审核查询";
			else if(DingDanZhuangTai.ER_JIAN_DAI_SHEN_HE_TEXT.equals(ddztMc)&&GuoBangJiLu.CHU_CHANG_GUO_BANG==gblx)
				fileName = "二检待审核查询";
			download(fileName, wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/exportWZLXList")
	public void exportWZLXList(String mc,Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			mc=StringUtil.decode(mc, "UTF-8");
			System.out.println("mc="+mc);
			
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			HSSFSheet sheet = wb.createSheet("物资类型");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("类名");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("创建时间");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("编辑时间");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("排序");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("备注");
			cell.setCellStyle(style);
			
			List<WuZiLeiXing> wzlxList = exportExcelService.queryWZLXList(mc,page, rows, dcfw);
			for (int i = 0; i < wzlxList.size(); i++) {
				WuZiLeiXing wzlx = wzlxList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String mc1 = wzlx.getMc();
				if(!StringUtils.isBlank(mc1))
					cell.setCellValue(mc1);
				
				cell = row.createCell(1);
				String cjsj = wzlx.getCjsj();
				if(!StringUtils.isBlank(cjsj))
					cell.setCellValue(cjsj);
				
				cell = row.createCell(2);
				String bjsj = wzlx.getBjsj();
				if(!StringUtils.isBlank(bjsj))
					cell.setCellValue(bjsj);
				
				cell = row.createCell(3);
				Integer px = wzlx.getPx();
				if(px!=null)
					cell.setCellValue(px);
				
				cell = row.createCell(4);
				String bz = wzlx.getBz();
				if(!StringUtils.isBlank(bz))
					cell.setCellValue(bz);
			}
	
			download("物资类型查询", wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/exportWuZiList")
	public void exportWuZiList(String mc,String wzlxmc,Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			mc=StringUtil.decode(mc, "UTF-8");
			System.out.println("mc="+mc);
			mc=StringUtil.decode(wzlxmc, "UTF-8");
			System.out.println("wzlxmc="+wzlxmc);
			
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			HSSFSheet sheet = wb.createSheet("物资");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("物资类型");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("编辑时间");
			cell.setCellStyle(style);
		
			List<WuZi> wzList = exportExcelService.queryWuZiList(mc,wzlxmc, page, rows, dcfw);
			for (int i = 0; i < wzList.size(); i++) {
				WuZi wz = wzList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String mc1 = wz.getMc();
				if(!StringUtils.isBlank(mc1))
					cell.setCellValue(mc1);
				
				cell = row.createCell(1);
				String wzlxmc1 = wz.getWzlxmc();
				if(!StringUtils.isBlank(wzlxmc1))
					cell.setCellValue(wzlxmc1);
				
				cell = row.createCell(2);
				String bjsj = wz.getBjsj();
				if(!StringUtils.isBlank(bjsj))
					cell.setCellValue(bjsj);
			}
			
			download("物资查询", wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/exportYunShuShangList")
	public void exportYunShuShangList(String mc,Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			mc=StringUtil.decode(mc, "UTF-8");
			System.out.println("mc="+mc);
			
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			HSSFSheet sheet = wb.createSheet("运输商");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("编辑时间");
			cell.setCellStyle(style);
			
			List<YunShuShang> yssList = exportExcelService.queryYunShuShangList(mc, page, rows, dcfw);
			for (int i = 0; i < yssList.size(); i++) {
				YunShuShang yss = yssList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String mc1 = yss.getMc();
				if(!StringUtils.isBlank(mc1))
					cell.setCellValue(mc1);
				
				cell = row.createCell(1);
				String bjsj = yss.getBjsj();
				if(!StringUtils.isBlank(bjsj))
					cell.setCellValue(bjsj);
			}
			
			download("运输商查询", wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/exportFaHuoDanWeiList")
	public void exportFaHuoDanWeiList(String mc,Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			mc=StringUtil.decode(mc, "UTF-8");
			System.out.println("mc="+mc);
			
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			HSSFSheet sheet = wb.createSheet("发货单位");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("编辑时间");
			cell.setCellStyle(style);
			
			List<FaHuoDanWei> fhdwList = exportExcelService.queryFaHuoDanWeiList(mc, page, rows, dcfw);
			for (int i = 0; i < fhdwList.size(); i++) {
				FaHuoDanWei fhdw = fhdwList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String mc1 = fhdw.getMc();
				if(!StringUtils.isBlank(mc1))
					cell.setCellValue(mc1);
				
				cell = row.createCell(1);
				String bjsj = fhdw.getBjsj();
				if(!StringUtils.isBlank(bjsj))
					cell.setCellValue(bjsj);
			}
			
			download("发货单位查询", wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/exportShouHuoDanWeiList")
	public void exportShouHuoDanWeiList(String mc,Boolean ywdl,Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			mc=StringUtil.decode(mc, "UTF-8");
			System.out.println("mc="+mc);
			
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			HSSFSheet sheet = wb.createSheet("收货单位");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("有无队列");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("队列名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("编辑时间");
			cell.setCellStyle(style);
			
			List<ShouHuoDanWei> shdwList = exportExcelService.queryShouHuoDanWeiList(mc,ywdl, page, rows, dcfw);
			for (int i = 0; i < shdwList.size(); i++) {
				ShouHuoDanWei shdw = shdwList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String mc1 = shdw.getMc();
				if(!StringUtils.isBlank(mc1))
					cell.setCellValue(mc1);
				
				cell = row.createCell(1);
				Boolean ywdl1 = shdw.getYwdl();
				if(ywdl1!=null)
					cell.setCellValue(ywdl1?"有":"无");
				
				cell = row.createCell(2);
				String dlMc = shdw.getDlMc();
				if(!StringUtils.isBlank(dlMc))
					cell.setCellValue(dlMc);
				
				cell = row.createCell(3);
				String bjsj = shdw.getBjsj();
				if(!StringUtils.isBlank(bjsj))
					cell.setCellValue(bjsj);
			}
			
			download("收货单位查询", wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/exportCangKuList")
	public void exportCangKuList(String mc,Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			mc=StringUtil.decode(mc, "UTF-8");
			System.out.println("mc="+mc);
			
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			HSSFSheet sheet = wb.createSheet("仓库");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("名称");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("位置");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("编辑时间");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("备注");
			cell.setCellStyle(style);
			
			List<CangKu> ckList = exportExcelService.queryCangKuList(mc, page, rows, dcfw);
			for (int i = 0; i < ckList.size(); i++) {
				CangKu ck = ckList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String mc1 = ck.getMc();
				if(!StringUtils.isBlank(mc1))
					cell.setCellValue(mc1);
				
				cell = row.createCell(1);
				String wz = ck.getWz();
				if(!StringUtils.isBlank(wz))
					cell.setCellValue(wz);
				
				cell = row.createCell(2);
				String bjsj = ck.getBjsj();
				if(!StringUtils.isBlank(bjsj))
					cell.setCellValue(bjsj);
				
				cell = row.createCell(3);
				String bz = ck.getBz();
				if(!StringUtils.isBlank(bz))
					cell.setCellValue(bz);
			}
			
			download("仓库查询", wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/exportCheLiangList")
	public void exportCheLiangList(String cph,Integer cllx,Boolean sfzy,Integer pfjd,String shzt,String bz,
			Integer page,Integer rows,Integer sheetFlag,int dcfw,HttpServletResponse response) {
		try {
			cph=StringUtil.decode(cph, "UTF-8");
			System.out.println("cph="+cph);
			System.out.println("cllx="+cllx);
			System.out.println("sfzy="+sfzy);
			System.out.println("pfjd="+pfjd);
			System.out.println("shzt"+shzt);
			bz=StringUtil.decode(bz, "UTF-8");
			System.out.println("bz="+bz);
			
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			String sheetname = null;
			switch (sheetFlag) {
			case CheLiang.DAI_SHEN_HE_SHEET:
				sheetname = "待审核车辆";
				break;
			case CheLiang.ZONG_HE_CHA_XUN_SHEET:
				sheetname = "车辆综合查询";
				break;
			}
			HSSFSheet sheet = wb.createSheet(sheetname);
			
			createCLZHCXSheetHeader(wb,sheet,rowNum,sheetFlag);
			
			List<CheLiang> clList = exportExcelService.queryCLZHCXList(cph,cllx,sfzy,pfjd,shzt,bz, page, rows, dcfw);
			
			createCLZHCXSheetBody(clList,sheet,rowNum,sheetFlag);

			String fileName = null;
			switch (sheetFlag) {
			case CheLiang.DAI_SHEN_HE_SHEET:
				fileName = "待审核车辆查询";
				break;
			case CheLiang.ZONG_HE_CHA_XUN_SHEET:
				fileName = "车辆综合查询";
				break;
			}
			download(fileName, wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据不同表格标识创建表头，调用同一个车辆综合查询接口，只是表头显示的列不同，这里需要判断下
	 * @param wb
	 * @param sheet
	 * @param rowNum
	 * @param sheetFlag
	 */
	public void createCLZHCXSheetHeader(HSSFWorkbook wb,HSSFSheet sheet,int rowNum,Integer sheetFlag) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCellStyle style = wb.createCellStyle();
		
		HSSFCell cell = null;
		switch (sheetFlag) {
		case CheLiang.DAI_SHEN_HE_SHEET:
			cell = row.createCell(0);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("品牌型号");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("发动机号码");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("车辆识别代号");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("注册日期");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("排放阶段");
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue("发证日期");
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue("是否在用");
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue("备注");
			cell.setCellStyle(style);
			break;
		case CheLiang.ZONG_HE_CHA_XUN_SHEET:
			cell = row.createCell(0);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("品牌型号");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("发动机号码");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("车辆识别代号");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("注册日期");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("排放阶段");
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue("发证日期");
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue("是否在用");
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue("状态");
			cell.setCellStyle(style);
			
			cell = row.createCell(9);
			cell.setCellValue("备注");
			cell.setCellStyle(style);
			break;
		}
	}
	
	public void createCLZHCXSheetBody(List<CheLiang> clList,HSSFSheet sheet,int rowNum,Integer sheetFlag) {
		switch (sheetFlag) {
		case DingDan.DAI_SHEN_HE_SHEET:
			for (int i = 0; i < clList.size(); i++) {
				CheLiang cl = clList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
	
				HSSFCell cell = row.createCell(0);
				String cph = cl.getCph();
				if(!StringUtils.isBlank(cph))
					cell.setCellValue(cph);
				
				cell = row.createCell(1);
				String ppxh = cl.getPpxh();
				if(!StringUtils.isBlank(ppxh))
					cell.setCellValue(ppxh);
				
				cell = row.createCell(2);
				String fdjhm = cl.getFdjhm();
				if(!StringUtils.isBlank(fdjhm))
					cell.setCellValue(fdjhm);
				
				cell = row.createCell(3);
				String clsbdh = cl.getClsbdh();
				if(!StringUtils.isBlank(clsbdh))
					cell.setCellValue(clsbdh);
				
				cell = row.createCell(4);
				String zcrq = cl.getZcrq();
				if(!StringUtils.isBlank(zcrq))
					cell.setCellValue(zcrq);
				
				cell = row.createCell(5);
				Integer pfjd = cl.getPfjd();
				if(pfjd!=null) {
					String pfjdMc = Constant.getPfjdMcById(pfjd);
					cell.setCellValue(pfjdMc);
				}
				
				cell = row.createCell(6);
				String fzrq = cl.getFzrq();
				if(!StringUtils.isBlank(fzrq))
					cell.setCellValue(fzrq);
				
				cell = row.createCell(7);
				Boolean sfzy = cl.getSfzy();
				if(sfzy!=null)
					cell.setCellValue(sfzy?"是":"否");
				
				cell = row.createCell(8);
				String bz = cl.getBz();
				if(!StringUtils.isBlank(bz))
					cell.setCellValue(bz);
			}
			break;
		case CheLiang.ZONG_HE_CHA_XUN_SHEET:
			for (int i = 0; i < clList.size(); i++) {
				CheLiang cl = clList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
	
				HSSFCell cell = row.createCell(0);
				String cph = cl.getCph();
				if(!StringUtils.isBlank(cph))
					cell.setCellValue(cph);
				
				cell = row.createCell(1);
				String ppxh = cl.getPpxh();
				if(!StringUtils.isBlank(ppxh))
					cell.setCellValue(ppxh);
				
				cell = row.createCell(2);
				String fdjhm = cl.getFdjhm();
				if(!StringUtils.isBlank(fdjhm))
					cell.setCellValue(fdjhm);
				
				cell = row.createCell(3);
				String clsbdh = cl.getClsbdh();
				if(!StringUtils.isBlank(clsbdh))
					cell.setCellValue(clsbdh);
				
				cell = row.createCell(4);
				String zcrq = cl.getZcrq();
				if(!StringUtils.isBlank(zcrq))
					cell.setCellValue(zcrq);
				
				cell = row.createCell(5);
				Integer pfjd = cl.getPfjd();
				if(pfjd!=null) {
					String pfjdMc = Constant.getPfjdMcById(pfjd);
					cell.setCellValue(pfjdMc);
				}
				
				cell = row.createCell(6);
				String fzrq = cl.getFzrq();
				if(!StringUtils.isBlank(fzrq))
					cell.setCellValue(fzrq);
				
				cell = row.createCell(7);
				Boolean sfzy = cl.getSfzy();
				if(sfzy!=null)
					cell.setCellValue(sfzy?"是":"否");
				
				cell = row.createCell(8);
				Integer shzt = cl.getShzt();
				if(shzt!=null) {
					String pfjdMc = Constant.getCLShztMcById(shzt);
					cell.setCellValue(pfjdMc);
				}
				
				cell = row.createCell(9);
				String bz = cl.getBz();
				if(!StringUtils.isBlank(bz))
					cell.setCellValue(bz);
			}
			break;
		}
	}

	@RequestMapping(value="/exportCLSHJLList")
	public void exportCLSHJLList(String clCph,String shrYhm,String shsjks,String shsjjs,
			Integer page,Integer rows,int dcfw,HttpServletResponse response) {
		try {
			clCph=StringUtil.decode(clCph, "UTF-8");
			System.out.println("clCph="+clCph);
			shrYhm=StringUtil.decode(shrYhm, "UTF-8");
			System.out.println("shrYhm="+shrYhm);
			System.out.println("shsjks="+shsjks);
			System.out.println("shsjjs="+shsjjs);
			System.out.println("page="+page);
			System.out.println("rows="+rows);
			System.out.println("dcfw="+dcfw);
			
			int rowNum=0;
			//第一步，创建一个Workbook，对应一个Excel文件
			HSSFWorkbook wb=new HSSFWorkbook();
			//第二步，在Workbook里添加一个sheet，对应Excel文件里的sheet
			HSSFSheet sheet = wb.createSheet("车辆审核记录");
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCellStyle style = wb.createCellStyle();
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue("审核人");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("审核时间");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("审核结果");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("备注");
			cell.setCellStyle(style);
			
			List<CheLiangShenHeJiLu> clshjlList = exportExcelService.queryCLSHJLList(clCph,shrYhm,shsjks,shsjjs, page, rows, dcfw);
			for (int i = 0; i < clshjlList.size(); i++) {
				CheLiangShenHeJiLu clshjl = clshjlList.get(i);
				row=sheet.createRow(++rowNum);
				
				cell = row.createCell(0);
				String clCph1 = clshjl.getClCph();
				if(!StringUtils.isBlank(clCph1))
					cell.setCellValue(clCph1);
				
				cell = row.createCell(1);
				String shrYhm1 = clshjl.getShrYhm();
				if(!StringUtils.isBlank(shrYhm1))
					cell.setCellValue(shrYhm1);
				
				cell = row.createCell(2);
				String shsj = clshjl.getShsj();
				if(!StringUtils.isBlank(shsj))
					cell.setCellValue(shsj);
				
				cell = row.createCell(3);
				Boolean shjg = clshjl.getShjg();
				if(shjg!=null)
					cell.setCellValue(shjg?"合格":"不合格");
				
				cell = row.createCell(4);
				String bz = clshjl.getBz();
				if(!StringUtils.isBlank(bz))
					cell.setCellValue(bz);
			}
			
			download("车辆审核记录查询", wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/exportCLTZList")
	public void exportCLTZList(String ddh,String cph,String ddztIds,String ddztMcs,String jcsjs,String jcsje,String ccsjs,String ccsje,
			Integer page,Integer rows,Integer sheetFlag,int dcfw,HttpServletResponse response) {
		try {
			System.out.println("ddh="+ddh);
			cph=StringUtil.decode(cph, "UTF-8");
			System.out.println("cph="+cph);
			System.out.println("ddztIds="+ddztIds);
			System.out.println("ddztMcs="+ddztMcs);
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
			case CheLiangTaiZhang.ZONG_HE_CHA_XUN_SHEET:
				sheetname = "综合台账";
				break;
			case CheLiangTaiZhang.CHANG_NEI_SHEET:
				sheetname = "厂内台账";
				break;
			}
			HSSFSheet sheet = wb.createSheet(sheetname);
			
			createCLTZZHCXSheetHeader(wb,sheet,rowNum,sheetFlag);
			
			List<CheLiangTaiZhang> cltzList = exportExcelService.queryCLTZList(ddh,cph,ddztIds,ddztMcs,jcsjs,jcsje,ccsjs,ccsje, page, rows, dcfw);

			createCLTZZHCXSheetBody(cltzList,sheet,rowNum,sheetFlag);

			String fileName = null;
			switch (sheetFlag) {
			case CheLiangTaiZhang.ZONG_HE_CHA_XUN_SHEET:
				fileName = "综合台账查询";
				break;
			case CheLiangTaiZhang.CHANG_NEI_SHEET:
				fileName = "厂内台账查询";
				break;
			}
			
			download(fileName, wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createCLTZZHCXSheetHeader(HSSFWorkbook wb,HSSFSheet sheet,int rowNum,Integer sheetFlag) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCellStyle style = wb.createCellStyle();
		HSSFCell cell = null;
		
		switch (sheetFlag) {
		case CheLiangTaiZhang.ZONG_HE_CHA_XUN_SHEET:
			cell = row.createCell(0);
			cell.setCellValue("订单号");
			cell.setCellStyle(style);
		
			cell = row.createCell(1);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("订单状态");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("进厂时间");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("出厂时间");
			cell.setCellStyle(style);
			break;
		case CheLiangTaiZhang.CHANG_NEI_SHEET:
			cell = row.createCell(0);
			cell.setCellValue("订单号");
			cell.setCellStyle(style);
		
			cell = row.createCell(1);
			cell.setCellValue("车牌号");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("订单状态");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("进厂时间");
			cell.setCellStyle(style);
			break;
		}
	}
	
	public void createCLTZZHCXSheetBody(List<CheLiangTaiZhang> cltzList,HSSFSheet sheet,int rowNum,Integer sheetFlag) {
		switch (sheetFlag) {
		case CheLiangTaiZhang.ZONG_HE_CHA_XUN_SHEET:
			for (int i = 0; i < cltzList.size(); i++) {
				CheLiangTaiZhang cltz = cltzList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
				
				HSSFCell cell = row.createCell(0);
				String ddh1 = cltz.getDdh();
				if(!StringUtils.isBlank(ddh1))
					cell.setCellValue(ddh1);
				
				cell = row.createCell(1);
				String cyclCph = cltz.getCyclCph();
				if(!StringUtils.isBlank(cyclCph))
					cell.setCellValue(cyclCph);
				
				cell = row.createCell(2);
				String ddztMc = cltz.getDdztMc();
				if(!StringUtils.isBlank(ddztMc))
					cell.setCellValue(ddztMc);
				
				cell = row.createCell(3);
				String jcsj = cltz.getJcsj();
				if(!StringUtils.isBlank(jcsj))
					cell.setCellValue(jcsj);
				
				cell = row.createCell(4);
				String ccsj = cltz.getCcsj();
				if(!StringUtils.isBlank(ccsj))
					cell.setCellValue(ccsj);
			}
			break;
		case CheLiangTaiZhang.CHANG_NEI_SHEET:
			for (int i = 0; i < cltzList.size(); i++) {
				CheLiangTaiZhang cltz = cltzList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
				
				HSSFCell cell = row.createCell(0);
				String ddh1 = cltz.getDdh();
				if(!StringUtils.isBlank(ddh1))
					cell.setCellValue(ddh1);
				
				cell = row.createCell(1);
				String cyclCph = cltz.getCyclCph();
				if(!StringUtils.isBlank(cyclCph))
					cell.setCellValue(cyclCph);
				
				cell = row.createCell(2);
				String ddztMc = cltz.getDdztMc();
				if(!StringUtils.isBlank(ddztMc))
					cell.setCellValue(ddztMc);
				
				cell = row.createCell(3);
				String jcsj = cltz.getJcsj();
				if(!StringUtils.isBlank(jcsj))
					cell.setCellValue(jcsj);
			}
			break;
		}
	}

	@RequestMapping(value="/exportSiJiList")
	public void exportSiJiList(String xm,String sjh,String sfzh,Integer zyzt,Integer shzt,Integer page,Integer rows,Integer sheetFlag,int dcfw,HttpServletResponse response) {
		try {
			xm=StringUtil.decode(xm, "UTF-8");
			System.out.println("xm="+xm);
			System.out.println("sjh="+sjh);
			System.out.println("sfzh="+sfzh);
			System.out.println("zyzt="+zyzt);
			System.out.println("shzt="+shzt);
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
			case SiJi.DAI_SHEN_HE_SHEET:
				sheetname = "待审核司机";
				break;
			case SiJi.ZONG_HE_CHA_XUN_SHEET:
				sheetname = "司机综合查询";
				break;
			}
			
			HSSFSheet sheet = wb.createSheet(sheetname);
			
			createSJZHCXSheetHeader(wb,sheet,rowNum,sheetFlag);
			
			List<SiJi> sjList = exportExcelService.querySiJiList(xm,sjh,sfzh,zyzt,shzt, page, rows, dcfw);
	
			createSJZHCXSheetBody(sjList,sheet,rowNum,sheetFlag);
	
			String fileName = null;
			switch (sheetFlag) {
			case SiJi.DAI_SHEN_HE_SHEET:
				fileName = "待审核司机查询";
				break;
			case SiJi.ZONG_HE_CHA_XUN_SHEET:
				fileName = "司机综合查询";
				break;
			}
			
			download(fileName, wb, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createSJZHCXSheetHeader(HSSFWorkbook wb,HSSFSheet sheet,int rowNum,Integer sheetFlag) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCellStyle style = wb.createCellStyle();
		HSSFCell cell = null;
		
		switch (sheetFlag) {
		case SiJi.DAI_SHEN_HE_SHEET:
			cell = row.createCell(0);
			cell.setCellValue("姓名");
			cell.setCellStyle(style);
		
			cell = row.createCell(1);
			cell.setCellValue("手机号");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("身份证号");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("驾证有效期至");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("资格证有效期至");
			cell.setCellStyle(style);
			break;
		case SiJi.ZONG_HE_CHA_XUN_SHEET:
			cell = row.createCell(0);
			cell.setCellValue("姓名");
			cell.setCellStyle(style);
		
			cell = row.createCell(1);
			cell.setCellValue("手机号");
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue("身份证号");
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue("驾证有效期至");
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue("资格证有效期至");
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue("审核状态");
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue("在用状态");
			cell.setCellStyle(style);
			break;
		}
	}
	
	public void createSJZHCXSheetBody(List<SiJi> sjList,HSSFSheet sheet,int rowNum,Integer sheetFlag) {
		switch (sheetFlag) {
		case SiJi.DAI_SHEN_HE_SHEET:
			for (int i = 0; i < sjList.size(); i++) {
				SiJi sj = sjList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
				
				HSSFCell cell = row.createCell(0);
				String xm = sj.getXm();
				if(!StringUtils.isBlank(xm))
					cell.setCellValue(xm);
				
				cell = row.createCell(1);
				String sjh = sj.getSjh();
				if(!StringUtils.isBlank(sjh))
					cell.setCellValue(sjh);
				
				cell = row.createCell(2);
				String sfzh = sj.getSfzh();
				if(!StringUtils.isBlank(sfzh))
					cell.setCellValue(sfzh);
				
				cell = row.createCell(3);
				String jzyxqz = sj.getJzyxqz();
				if(!StringUtils.isBlank(jzyxqz))
					cell.setCellValue(jzyxqz);
				
				cell = row.createCell(4);
				String zgzyxqz = sj.getZgzyxqz();
				if(!StringUtils.isBlank(zgzyxqz))
					cell.setCellValue(zgzyxqz);
			}
			break;
		case SiJi.ZONG_HE_CHA_XUN_SHEET:
			for (int i = 0; i < sjList.size(); i++) {
				SiJi sj = sjList.get(i);
				HSSFRow row=sheet.createRow(++rowNum);
				
				HSSFCell cell = row.createCell(0);
				String xm = sj.getXm();
				if(!StringUtils.isBlank(xm))
					cell.setCellValue(xm);
				
				cell = row.createCell(1);
				String sjh = sj.getSjh();
				if(!StringUtils.isBlank(sjh))
					cell.setCellValue(sjh);
				
				cell = row.createCell(2);
				String sfzh = sj.getSfzh();
				if(!StringUtils.isBlank(sfzh))
					cell.setCellValue(sfzh);
				
				cell = row.createCell(3);
				String jzyxqz = sj.getJzyxqz();
				if(!StringUtils.isBlank(jzyxqz))
					cell.setCellValue(jzyxqz);
				
				cell = row.createCell(4);
				String zgzyxqz = sj.getZgzyxqz();
				if(!StringUtils.isBlank(zgzyxqz))
					cell.setCellValue(zgzyxqz);
				
				cell = row.createCell(5);
				Integer shzt = sj.getShzt();
				if(shzt!=null) {
					String shztMc = Constant.getCLShztMcById(shzt);
					cell.setCellValue(shztMc);
				}

				cell = row.createCell(6);
				Boolean zyzt = sj.getZyzt();
				if(zyzt!=null)
					cell.setCellValue(zyzt?"是":"否");
			}
			break;
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

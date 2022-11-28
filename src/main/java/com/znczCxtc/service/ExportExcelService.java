package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface ExportExcelService {

	List<GuoBangJiLu> queryGBJList(String ddh, String cyclCph, String gbsjks, String gbsjjs, Integer page, Integer rows,
			int dcfw);

}

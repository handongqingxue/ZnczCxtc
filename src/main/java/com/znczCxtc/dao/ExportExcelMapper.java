package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface ExportExcelMapper {

	List<GuoBangJiLu> queryGBJList(@Param("ddh") String ddh, @Param("cyclCph") String cyclCph, @Param("gbsjks") String gbsjks, @Param("gbsjjs") String gbsjjs,
			@Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);

	List<GuoBangJiLu> queryGBJList(@Param("ddh") String ddh, @Param("cyclCph") String cyclCph, @Param("gbsjks") String gbsjks, @Param("gbsjjs") String gbsjjs, @Param("dcfw") int dcfw);
}

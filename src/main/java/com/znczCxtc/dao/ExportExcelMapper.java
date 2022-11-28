package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface ExportExcelMapper {

	List<GuoBangJiLu> queryGBJList(@Param("ddh") String ddh, @Param("cph") String cph, @Param("gbsjks") String gbsjks, @Param("gbsjjs") String gbsjjs,
			@Param("rowNum") int rowNum, @Param("rows") int rows, @Param("dcfw") int dcfw);
}

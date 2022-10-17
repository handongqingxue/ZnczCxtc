package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface DingDanShenHeJiLuMapper {

	int add(DingDanShenHeJiLu ddshjl);

	int queryForInt(@Param("ddh") String ddh, @Param("shlx") Integer shlx, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs, @Param("cyclCph") String cyclCph, @Param("shrYhm") String shrYhm, @Param("yssMc") String yssMc, @Param("wzMc") String wzMc, @Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("sjXm") String sjXm,
			@Param("sjSfzh") String sjSfzh);

	List<DingDanShenHeJiLu> queryList(@Param("ddh") String ddh, @Param("shlx") Integer shlx, @Param("shsjks") String shsjks, @Param("shsjjs") String shsjjs, @Param("cyclCph") String cyclCph, @Param("shrYhm") String shrYhm, @Param("yssMc") String yssMc, @Param("wzMc") String wzMc, @Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc,
			@Param("sjXm") String sjXm, @Param("sjSfzh") String sjSfzh, @Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

	int deleteByIds(List<String> idList);

}

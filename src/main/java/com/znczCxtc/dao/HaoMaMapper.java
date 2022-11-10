package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface HaoMaMapper {

	public int queryForInt(@Param("dlMc") String dlMc, @Param("hm") String hm, @Param("pdh") String pdh, @Param("hmztId") Integer hmztId);

	public List<HaoMa> queryList(@Param("dlMc") String dlMc, @Param("hm") String hm, @Param("pdh") String pdh, @Param("hmztId") Integer hmztId, @Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

	public int add(HaoMa hm);

	public HaoMa selectHaoMaById(@Param("id") String id);

	public List<HaoMa> getJhPdList();

	public int edit(HaoMa hm);

	public Integer getMaxHmByDlId(@Param("dlId") Integer dlId);

	public Integer getMaxPdh();
}

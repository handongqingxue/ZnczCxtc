package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface HaoMaMapper {

	public int queryForInt(@Param("dlMc") String dlMc, @Param("hm") String hm, @Param("pdh") String pdh, @Param("hmztId") Integer hmztId);

	public List<HaoMa> queryList(@Param("dlMc") String dlMc, @Param("hm") String hm, @Param("pdh") String pdh, @Param("hmztId") Integer hmztId, @Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

	public int add(HaoMa hm);

	public int deleteByIds(List<String> idList);

	public HaoMa selectHaoMaById(@Param("id") String id);

	public List<HaoMa> getJhPdList();

	public int edit(HaoMa hm);

	public Integer getMaxHmByDlId(@Param("dlId") Integer dlId);

	public Integer getMaxPdh();

	public List<HaoMa> getSlzList();

	/**
	 * 获取未满队队列里的第一个排队号(状态对应的是号码状态下的排队中，而不是订单状态下的排队中。不管号码所属收货单位有无队列，号码都参与排队中)
	 * @param ymdDlIdList
	 * @return
	 */
	public HaoMa getFirstWmdPdz(@Param("ymdDlIdList") List<Integer> ymdDlIdList);

	public List<HaoMa> getWmdPdzList(@Param("ymdDlIdList") List<Integer> ymdDlIdList);

	public List<HaoMa> getPdzList();

	public HaoMa getLastByDdId(@Param("ddId") Long ddId);

	public int changeZtByIdList(@Param("hmztId") int hmztId, @Param("idList") List<Long> idList);
}

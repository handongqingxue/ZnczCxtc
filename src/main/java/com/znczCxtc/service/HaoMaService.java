package com.znczCxtc.service;

import java.util.List;
import java.util.Map;

import com.znczCxtc.entity.*;

public interface HaoMaService {


	public int queryForInt(String dlMc, String hm, String pdh, Integer hmztId);

	public List<HaoMa> queryList(String dlMc, String hm, String pdh, Integer hmztId, int page, int rows, String sort,
			String order);

	public int add(HaoMa hm);

	public HaoMa selectHaoMaById(String id);

	/**
	 * 获得叫号中、排队中的号码列表
	 * @return
	 */
	public List<HaoMa> getJhPdList();

	public int edit(HaoMa hm);

	public Integer getMaxHmByDlId(Integer dlId);

	public Integer getMaxPdh();

	/**
	 * 号码状态改为叫号中、订单状态改为待入厂
	 * @return
	 */
	public int changeToJhz();

	/**
	 * 重新排序排队中的号码
	 * @return
	 */
	public int sortPdzHm();

	public HaoMa getLastByDdId(Long ddId);

	public Map<String, Object> changeToJhzByIds(String ids, String hms, String ddIds);

	public int changeToGhzByIds(String ids, String ddIds);

	int deleteByIds(String ids);
}

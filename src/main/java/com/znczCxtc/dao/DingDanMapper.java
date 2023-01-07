package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface DingDanMapper {

	int queryForInt(@Param("ddh") String ddh, @Param("ddztId") Integer ddztId, @Param("ddztMc") String ddztMc, @Param("cyclCph") String cyclCph, @Param("jhysrq") String jhysrq, @Param("yssMc") String yssMc, @Param("wzMc") String wzMc, 
			@Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("cysjXm") String cysjXm, @Param("cysjSfzh") String cysjSfzh, @Param("jcsjs") String jcsjs, @Param("jcsje") String jcsje, @Param("ccsjs") String ccsjs, @Param("ccsje") String ccsje);

	List<DingDan> queryList(@Param("ddh") String ddh, @Param("ddztId") Integer ddztId, @Param("ddztMc") String ddztMc, @Param("cyclCph") String cyclCph, @Param("jhysrq") String jhysrq, @Param("yssMc") String yssMc, @Param("wzMc") String wzMc, 
			@Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("cysjXm") String cysjXm, @Param("cysjSfzh") String cysjSfzh, @Param("jcsjs") String jcsjs, @Param("jcsje") String jcsje, @Param("ccsjs") String ccsjs, @Param("ccsje") String ccsje,
			@Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

	DingDan selectById(@Param("id") String id);

	int add(DingDan dd);

	int deleteByIds(List<String> idList);

	int edit(DingDan dd);

	int editByZt(DingDan dd);

	List<DingDan> getByZtSfzh(@Param("ddztId") int ddztId, @Param("sfzh") String sfzh);

	/**
	 * 这里是根据多个订单状态查询某车牌号关联的订单，因为是一辆车，只返回一条订单信息
	 * @param ddztIdList
	 * @param cph
	 * @return
	 */
	List<DingDan> getByZtListCph(@Param("ddztIdList") List<Integer> ddztIdList, @Param("cph") String cph);

	DingDan getByZt(@Param("yjbfh")Integer yjbfh,@Param("ejbfh") Integer ejbfh, @Param("ddztMc") String ddztMc, @Param("yjzt") Integer yjzt, @Param("ejzt") Integer ejzt);

	int checkByIds(@Param("idList") List<String> idList, @Param("ddztId") int ddztId);

	int getCountByDdh(@Param("ddh") String ddh);

	int getCountByZt(@Param("yjbfh") Integer yjbfh,@Param("ejbfh") Integer ejbfh,@Param("ddztMc") String ddztMc, @Param("yjzt") Integer yjzt, @Param("ejzt") Integer ejzt);

	DingDan getByCphJL(@Param("cph") String cph);

	long getIdByDdh(@Param("ddh") String ddh);

	int getCountByIdCph(@Param("id") Long id, @Param("cph") String cph);

	Integer getMaxDdhNumByDdhDate(@Param("ddhDate") String ddhDate);

	int changeZtByIdList(@Param("ddztId") int ddztId, @Param("idList") List<Long> idList);

}
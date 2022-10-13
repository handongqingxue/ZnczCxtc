package com.znczCxtc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface DingDanMapper {

	int queryForInt(@Param("ddh") String ddh, @Param("ddztId") Integer ddztId, @Param("ddztMc") String ddztMc, @Param("cph") String cph, @Param("jhysrq") String jhysrq, @Param("yssMc") String yssMc, @Param("wzMc") String wzMc, 
			@Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("cysjXm") String cysjXm, @Param("cysjSfzh") String cysjSfzh, @Param("jcsjs") String jcsjs, @Param("jcsje") String jcsje, @Param("ccsjs") String ccsjs, @Param("ccsje") String ccsje);

	List<DingDan> queryList(@Param("ddh") String ddh, @Param("ddztId") Integer ddztId, @Param("ddztMc") String ddztMc, @Param("cph") String cph, @Param("jhysrq") String jhysrq, @Param("yssMc") String yssMc, @Param("wzMc") String wzMc, 
			@Param("fhdwMc") String fhdwMc, @Param("shdwMc") String shdwMc, @Param("cysjXm") String cysjXm, @Param("cysjSfzh") String cysjSfzh, @Param("jcsjs") String jcsjs, @Param("jcsje") String jcsje, @Param("ccsjs") String ccsjs, @Param("ccsje") String ccsje,
			@Param("rowNum") int rowNum, @Param("rows") int rows, String sort, String order);

	DingDan selectById(@Param("id") String id);

	int add(DingDan dd);

	int deleteByIds(List<String> idList);

	int edit(DingDan dd);

	int editByZt(DingDan dd);

	DingDan getByZtCph(@Param("ddztId") int ddztId, @Param("cph") String cph);

	DingDan getByZt(@Param("yjbfh")Integer yjbfh,@Param("ejbfh") Integer ejbfh, @Param("ddztMc") String ddztMc, @Param("yjzt") Integer yjzt, @Param("ejzt") Integer ejzt);

	int checkByIds(@Param("idList") List<String> idList, @Param("ddztId") int ddztId);

	int getCountByDdh(@Param("ddh") String ddh);

	int getCountByZt(@Param("yjbfh") Integer yjbfh,@Param("ejbfh") Integer ejbfh,@Param("ddztMc") String ddztMc, @Param("yjzt") Integer yjzt, @Param("ejzt") Integer ejzt);

	DingDan getByCphJL(@Param("cph") String cph);

	int getIdByDdh(@Param("ddh") String ddh);

	int getCountByIdCph(@Param("id") Integer id, @Param("cph") String cph);

	int getCountByDdhDate(@Param("ddhDate") String ddhDate);

}
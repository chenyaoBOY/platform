package com.frog.platform.dao;

import com.frog.platform.entity.VisitPv;
import com.frog.platform.entity.VisitPvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitPvMapper {
    int countByExample(VisitPvExample example);

    int deleteByExample(VisitPvExample example);

    int deleteByPrimaryKey(String id);

    int insert(VisitPv record);

    int insertSelective(VisitPv record);

    List<VisitPv> selectByExample(VisitPvExample example);

    VisitPv selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VisitPv record, @Param("example") VisitPvExample example);

    int updateByExample(@Param("record") VisitPv record, @Param("example") VisitPvExample example);

    int updateByPrimaryKeySelective(VisitPv record);

    int updateByPrimaryKey(VisitPv record);
}
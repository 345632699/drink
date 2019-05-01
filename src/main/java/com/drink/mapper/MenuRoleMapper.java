package com.drink.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by sang on 2018/1/2.
 */
@Repository
public interface MenuRoleMapper {
    int deleteMenuByRid(@Param("rid") Long rid);

    int addMenu(@Param("rid") Long rid, @Param("mids") Long[] mids);
}

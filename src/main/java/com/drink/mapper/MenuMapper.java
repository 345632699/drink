package com.drink.mapper;


import com.drink.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Repository
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId(Long hrId);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}

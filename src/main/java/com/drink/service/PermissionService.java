package com.drink.service;

import com.drink.entity.Permission;
import com.drink.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    public List<Permission> allList() {
        List<Permission> permissions = permissionMapper.allList();
        if (permissions.size() > 0) {
            return permissions;
        }else {
            return null;
        }
    }

}

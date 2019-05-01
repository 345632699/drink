package com.drink.controller;

import com.drink.common.ResultJson;
import com.drink.entity.Permission;
import com.drink.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("list")
    public ResultJson getList() {
        List<Permission> permissionList = permissionService.allList();
        return ResultJson.ok(permissionList);
    }
}

package com.drink.mapper;

import com.drink.entity.Role;
import com.drink.entity.UserDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author JoeTao
 * createAt: 2018/9/17
 */
@Repository
public interface AuthMapper {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    UserDetail findByUsername(@Param("username") String username);

    /**
     * 创建新用户
     * @param userDetail
     */
    void insert(UserDetail userDetail);

    /**
     * 创建用户角色
     * @param userId
     * @param roleId
     * @return
     */
    int insertRole(@Param("userId") long userId, @Param("roleId") long roleId);

    /**
     * 根据角色id查找角色
     * @param roleId
     * @return
     */
    Role findRoleById(@Param("roleId") long roleId);

    /**
     * 根据用户id查找该用户角色
     * @param userId
     * @return
     */
    Role findRoleByUserId(@Param("userId") long userId);

    List<Role> getRolesByHrId(Long id);
}

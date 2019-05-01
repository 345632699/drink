package com.drink.common;

import com.drink.entity.UserDetail;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by sang on 2017/12/30.
 */
public class HrUtils {
    public static UserDetail getCurrentHr() {
        return (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

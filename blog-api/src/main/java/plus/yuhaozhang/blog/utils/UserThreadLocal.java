package plus.yuhaozhang.blog.utils;

import plus.yuhaozhang.blog.dao.pojo.SysUser;

/**
 * @author Yuh Z
 * @date 12/10/21
 */
public class UserThreadLocal {
    public UserThreadLocal() {
    }

    private static final ThreadLocal<SysUser> THREAD_LOCAL = new ThreadLocal<>();

    public static void put(SysUser sysUser){
        THREAD_LOCAL.set(sysUser);
    }

    public static SysUser get(){
        return THREAD_LOCAL.get();
    }
    public static void delete(){
        THREAD_LOCAL.remove();
    }
}

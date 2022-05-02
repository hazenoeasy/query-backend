package project.database.forum.handler.interceptor;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Yuh Z
 * @date 5/1/22
 */
@Component
public class DateInterceptor implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //这里是属性名， 不是字段名
        this.setFieldValByName("datetime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //
        //this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}

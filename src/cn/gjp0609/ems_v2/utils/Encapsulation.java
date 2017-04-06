package cn.gjp0609.ems_v2.utils;

import java.sql.ResultSet;

/**
 * 处理结果集数据
 * 实现此接口完成对象的封装
 * Created by gjp06 on 17.3.31.
 */
public interface Encapsulation<T> {
    /**
     * 将结果集中的一行数据封装成所需对象
     *
     * @param rs 结果集中的一行数据
     * @return 封装后的对象
     */
    public T encapsulate(ResultSet rs);
}

package cn.gjp0609.ems_v2.utils;

import java.util.List;

/**
 * 通用 DAO 接口
 * Created by gjp06 on 17.3.31.
 */
public interface CommonDao<T> {

    /**
     * 更新数据库单条数据，包括增加、删除、修改
     *
     * @param sql     sql语句
     * @param t       要更新的对象
     * @param objects 传入的多个参数
     * @return 受影响行数
     */
    public int updateData(String sql, T t, Object... objects);


    /**
     * 查询数据库单条或多条数据，返回对应集合
     * 使用此方法必须实现 Encapsulate 接口
     *
     * @param sql           sql语句
     * @param encapsulation 实现了 Encapsulation 接口的实例化对象
     * @param objects       传入的多个参数
     * @return 查询数据对象的集合
     */
    public List<T> queryData(String sql, Encapsulation<T> encapsulation, Object... objects);
}
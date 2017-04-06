package cn.gjp0609.ems_v2.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用 DAO 类的实现类
 * Created by gjp06 on 17.3.31.
 */
public class CommonDaoImpl<T> implements CommonDao<T> {


    @Override
    public int updateData(String sql, Object o, Object... objects) {
        // 获取连接
        Connection conn = JdbcUtils.getConnection();
        // 得到预处理语句对象
        PreparedStatement ps = null;
        // 定义受影响行数
        int result = 0;
        try {
            // 得到预处理语句对象
            ps = conn.prepareStatement(sql);
            // 循环设置参数，若无参数则跳过（length == 0）
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            // 接收受影响行数
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JdbcUtils.release(null, ps, null);
        }
        return result;
    }

    @Override
    public List<T> queryData(String sql, Encapsulation encapsulation, Object... objects) {
        // 获取连接
        Connection conn = JdbcUtils.getConnection();
        // 定义预处理语句对象
        PreparedStatement ps = null;
        // 定义结果集对象
        ResultSet rs = null;
        // 创建集合存储查询结果
        List<T> list = new ArrayList<>();
        try {
            // 得到预处理语句对象
            ps = conn.prepareStatement(sql);
            // 循环设置参数，若无参数则跳过（length == 0）
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            // 接收查询结果
            rs = ps.executeQuery();
            // 循环查询，每次得到一行数据
            while (rs.next()) {
                // 调用接口 encapsulate() 方法传入 rs 接收到的一行数据，得到泛型对象
                T t = (T) encapsulation.encapsulate(rs);
                // 将封装过的对象存入集合
                list.add(t);

                // System.out.println("---------------------------------"+ t.getClass().getSimpleName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(null, ps, rs);
        }
        return list;
    }
}

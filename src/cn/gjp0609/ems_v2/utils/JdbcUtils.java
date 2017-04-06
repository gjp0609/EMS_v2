package cn.gjp0609.ems_v2.utils;


import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC 相关工具类
 * 提供获取连接对象、关闭相应资源方法
 * Created by gjp06 on 17.3.31.
 */
public class JdbcUtils {

    // 创建 tl 对象存储连接对象
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    // 声明创建数据源对象
    private static DataSource ds = null;

    static {
        try {
            // 创建配置文件对象
            Properties properties = new Properties();
            // 定义配置文件路径
            String fileName = "/dbcp.properties";
            // 复用当前类对象已有输入流
            InputStream is = JdbcUtils.class.getResourceAsStream(fileName);
            // 读取配置文件
            properties.load(is);
            // 通过 DS 工厂创建 ds 对象
            ds = BasicDataSourceFactory.createDataSource(properties);

//            ds = BasicDataSourceFactory.createDataSource(new Properties().load(JdbcUtils.class.getResourceAsStream("/dbcp.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得连接对象
     * 从 ThreadLocal 中取出连接对象
     * 若不存在，则从连接池中取出已有连接对象
     *
     * @return 连接对象
     */
    public static Connection getConnection() {

        // 从 ThreadLocal 中取出连接对象
        Connection conn = tl.get();
        if (conn == null) {
            try {
                // 若 tl 中不存在，则从连接池中取连接对象
                conn = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tl.set(conn);
        }
        return conn;
    }

    /**
     * 释放资源
     * 因为 conn 为从连接池中取得的连接对象，故不执行 close() 而是 remove()
     *
     * @param conn 连接对象
     * @param ps   预处理语句
     * @param rs   结果集
     */
    public static void release(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

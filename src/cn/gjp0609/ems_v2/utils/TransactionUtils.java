package cn.gjp0609.ems_v2.utils;

import java.sql.Connection;

/**
 * Created by gjp06 on 17.4.1.
 */
public class TransactionUtils {

    /**
     * 事务提交
     */
    public static void commit() {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, null, null);
        }
    }

    /**
     * 事务回滚
     */
    public static void rollback() {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            conn.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, null, null);
        }
    }
}

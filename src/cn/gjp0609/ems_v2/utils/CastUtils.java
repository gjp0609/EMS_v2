package cn.gjp0609.ems_v2.utils;

/**
 * Created by gjp06 on 17.4.10.
 */
public class CastUtils<T> {
    public T cast(Object o) {
        T t = null;
        try {
            t = (T) o;
        } catch (ClassCastException e) {
            System.out.println("类型转换失败" + o.getClass().getSimpleName() + " --> " + t.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("??????");
        }
        return t;
    }
}

package cn._94zichao.mybatis;

/**
 * Created by Administrator on 2017/8/14.
 */
public class ReflectUtils {
    public static Class getClassFromMethodString(String method){
        Class clazz = null;
        int last = method.lastIndexOf(".");
        String classname = method.substring(0, last);
        try {
            clazz = Class.forName(classname);
        } catch (ClassNotFoundException e) {

        }
        return  clazz;
    }
}

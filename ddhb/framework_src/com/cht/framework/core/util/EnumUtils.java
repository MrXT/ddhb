package com.cht.framework.core.util;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 枚举工具类<br>
 * 注意：继承自BaseEnum的类不能使用该工具类
 * @author WJK
 * @version 2015-08
 */
public class EnumUtils {

    public static <E extends Enum<E>> Enum<E> getEnum(Class<E> enumClass, String token) {
        return Enum.valueOf(enumClass, token);
    }

    public static <E extends Enum<E>> Map<String, Enum<E>> getEnumMap(Class<E> enumClass) {
        Map<String, Enum<E>> map = new HashMap<String, Enum<E>>();
        Iterator<E> itr = EnumUtils.iterator(enumClass);
        while (itr.hasNext()) {
            Enum<E> enm = itr.next();
            map.put(enm.name(), enm);
        }
        return map;
    }

    public static <E extends Enum<E>> Set<E> getEnumSet(Class<E> enumClass) {
        return EnumSet.allOf(enumClass);
    }

    public static <E extends Enum<E>> Iterator<E> iterator(Class<E> enumClass) {
        return EnumSet.allOf(enumClass).iterator();
    }
    
    /**
     * 功能:判断指定值是否包含在枚举内
     * @param enumClass 枚举类
     * @param type 指定的枚举类型
     * @return
     */
    public static <E extends Enum<E>> boolean contains(Class<E> enumClass, int value){
        EnumSet<E> set = EnumSet.allOf(enumClass);
        boolean result = false;
        for(E e : set){
            if(e.ordinal() == value){
                result = true;
                break;
            }
        }
        return result;
    }
}

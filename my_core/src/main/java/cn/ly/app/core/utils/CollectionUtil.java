package cn.ly.app.core.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionUtil {
    public static <T> Boolean isEmpty(List<T> list){ return list==null || 0>=list.size();}
    public static <T> Boolean isEmpty(Set<T> set){ return set==null || 0>=set.size();}
    public static <T> Boolean isEmpty(Collection<T> collection){ return collection==null || 0>=collection.size();}
    public static <T> Boolean isEmpty(T[] array ){ return array==null || 0>=array.length;}
    public static <K,V> Boolean isEmpty(Map<K,V> map ){ return map==null || 0>=map.size();}

    public static <T> Boolean isNotEmpty(List<T> list){return !isEmpty(list);}
    public static <T> Boolean isNotEmpty(Set<T> set){return !isEmpty(set);}
    public static <T> Boolean isNotEmpty(Collection<T> collection){return !isEmpty(collection);}
    public static <T> Boolean isNotEmpty(T[] array ){return !isEmpty(array);}
    public static <K,V> Boolean isNotEmpty(Map<K,V> map ){return !isEmpty(map);}
}

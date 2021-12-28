package com.nghiahd.server.common;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PageUtilsCommon {

    private static final String DIRECTION_ASC = "ASC";
    private static final String DIRECTION_DESC = "DESC";
    private static final String NULL = " null ";
    private static final String THEN = " THEN ";

    public static void setParamsWithPageable(Query query, Map<String, Object> params, Pageable pageable, Number total) {
        if (params != null && !params.isEmpty()) {
            Set<Map.Entry<String, Object>> set = params.entrySet();
            for (Map.Entry<String, Object> obj : set) {
                if (obj.getValue() != null)
                    query.setParameter(obj.getKey(), obj.getValue());
            }
        }
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
    }

    public static void setParams(Query query, Map<String, Object> params) {
        if (params != null && !params.isEmpty()) {
            Set<Map.Entry<String, Object>> set = params.entrySet();
            for (Map.Entry<String, Object> obj : set) {
                if (obj.getValue() != null)
                    query.setParameter(obj.getKey(), obj.getValue());
            }
        }
    }

    /**
     * <k>
     * get key of maps
     * </k>
     */
    public static <K, V> K getKeyForSort(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * <k>
     * get list key of maps
     * </k>
     */
    public static <K, V> Set<K> getKeysForSortMulti(Map<K, V> map, V value) {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    public static <K, V> V getValueForSort(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey().equals(value)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static StringBuilder orderBySort(Pageable pageable, Map<String, String> nameColumnMap, Map<String, Object> params) {
        String nameFieldSort = "";
        Sort sortsSort = pageable.getSort();
        Sort.Order orders = sortsSort.stream().findFirst().orElse(null);
        if (orders != null && !(orders.getProperty()).isEmpty() && !"null".equals(orders.getProperty())) {
            if (!nameColumnMap.containsKey(orders.getProperty())) {
                return buildSqlOrder(orders, nameFieldSort, params);
            }
            nameFieldSort = PageUtilsCommon.getKeyForSort(nameColumnMap, orders.getProperty());
        }
        return buildSqlOrder(orders, nameFieldSort, params);
    }

    public static StringBuilder buildSqlOrder(Sort.Order orders, String nameFieldSort, Map<String, Object> params) {
        StringBuilder sqlOrderBy = new StringBuilder(" ORDER BY ");
        if ("".equals(nameFieldSort)) {
            return sqlOrderBy.append(NULL);
        }
        String typeDirection = orders.getDirection().name();
        String casePro = " CASE WHEN :pro = '";
        switch (typeDirection) {
            case DIRECTION_ASC:
                sqlOrderBy.append(casePro).append(nameFieldSort).append("'").append(THEN).append(nameFieldSort).append(" END ASC ");
                params.put("pro", orders.getProperty());
                break;
            case DIRECTION_DESC:
                sqlOrderBy.append(casePro).append(nameFieldSort).append("'").append(THEN).append(nameFieldSort).append(" END DESC ");
                params.put("pro", orders.getProperty());
                break;
            default:
                sqlOrderBy.append(NULL);
                break;
        }
        return sqlOrderBy;
    }


}

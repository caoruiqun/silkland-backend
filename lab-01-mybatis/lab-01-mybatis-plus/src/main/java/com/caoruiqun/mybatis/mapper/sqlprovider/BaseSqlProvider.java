package com.caoruiqun.mybatis.mapper.sqlprovider;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.builder.annotation.ProviderContext;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用于缓存和返回通用SQL语句
 *
 * @author Aylvn
 * @date 2021-01-24
 */
@Slf4j
public class BaseSqlProvider {

    private static final Map<String, String> BASE_SQL_CACHE_MAP = new ConcurrentHashMap<>();

    //******************************************************************
//    public String insertBatch(ProviderContext context) {
//        return BASE_SQL_CACHE_MAP.computeIfAbsent(getCacheKey(context), value -> {
//            Sql sql = new Sql();
//            sql.insertIntoBatch(tableName(context), fields(context));
//            sql.valuesBatch(fields(context));
//            log.debug("insertBatch:\n{}", sql.build());
//            return sql.build();
//        });
//    }


    public String insertBatch(ProviderContext context, String tableName) {
        return BASE_SQL_CACHE_MAP.computeIfAbsent(getCacheKey(context), value -> {
            Sql sql = new Sql();
            sql.insertIntoBatch(tableName, fields(context));
            sql.valuesBatch(fields(context));
            log.debug("insertBatch:\n{}", sql.build());
            return sql.build();
        });
    }

    public String deleteById(ProviderContext context) {
        return BASE_SQL_CACHE_MAP.computeIfAbsent(getCacheKey(context), value -> {
            Sql sql = new Sql();
            sql.deleteFrom(tableName(context));
            sql.where(id(context));
            log.debug("deleteById:\n{}", sql.build());
            return sql.build();
        });
    }

    public String countAll(ProviderContext context) {
        return BASE_SQL_CACHE_MAP.computeIfAbsent(getCacheKey(context), value -> {
            Sql sql = new Sql();
            sql.selectCount("*");
            sql.from(tableName(context));
            log.debug("countAll:\n{}", sql.build());
            return sql.build();
        });
    }

    public String countByEntity(ProviderContext context) {
        return BASE_SQL_CACHE_MAP.computeIfAbsent(getCacheKey(context), value -> {
            Sql sql = new Sql();
            sql.selectCount("*");
            sql.from(tableName(context));
            sql.where(fields(context));
            log.debug("countByEntity:\n{}", sql.build());
            return sql.build();
        });
    }

    /**
     * 获取实体类型
     */
    private static Class<?> entityType(ProviderContext context) {
        Class<?> clazz = context.getMapperType();
        return (Class<?>) ((ParameterizedType) (clazz.getGenericInterfaces()[0])).getActualTypeArguments()[0];
    }

    /**
     * 表名称
     */
    public static String tableName(ProviderContext context) {
        return StrUtil.camelToUnderscore(entityType(context).getSimpleName());
    }

    /**
     * 所有字段名称
     */
    public static String[] fields(ProviderContext context) {
        Class<?> entityType = entityType(context);
        Field[] entityFields = entityType.getDeclaredFields();
        Field[] superFields = entityType.getSuperclass().getDeclaredFields();
        // 检查并取得序列化版本号字段
        superFields = Arrays.stream(superFields).filter(field -> !"serialVersionUID".equals(field.getName())).toArray(Field[]::new);
        Field[] fields = Arrays.copyOf(entityFields, entityFields.length + superFields.length);
        System.arraycopy(superFields, 0, fields, entityFields.length, superFields.length);
        return Arrays.stream(fields).map(Field::getName).toArray(String[]::new);
    }

    /**
     * 主键 默认取实体的第一个字段
     */
    public static String id(ProviderContext context) {
        return fields(context)[0];
    }

    private static String getCacheKey(ProviderContext context) {
        return context.getMapperType().getSimpleName() + ":" + context.getMapperMethod().getName();
    }
}
package com.caoruiqun.template.common.result;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

/**
 * @author caoruiqun
 * @date 2023/5/26 15:51
 * @desc:
 */
public class PageResponseResult extends ResponseResult{

    /**
     * 当前页码(从1开始)
     */
    private Long pageIndex;
    /**
     * 每页条数
     */
    private Long pageSize;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 总页数
     */
    private Long pageCount;

    public PageResponseResult() {

    }

    public PageResponseResult(long pageIndex, long pageSize, long total, Collection list) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
        this.pageCount = (long) Math.ceil((double)total/(double)pageSize);
        this.setData(list);
    }

    public PageResponseResult(long pageIndex, long pageSize, long total, long pageCount) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
        this.pageCount = pageCount;
    }

    public PageResponseResult(long pageIndex, long pageSize, long total, long pageCount, Collection list) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
        this.pageCount = pageCount;
        this.setData(list);
    }


//    public PageResponseResult(IPage page) {
//        this.pageIndex = page.getCurrent();
//        this.pageSize = page.getSize();
//        this.total = page.getTotal();
//        this.pageCount = page.getPages();
//        this.setData(page.getRecords());
//    }
//
//    public PageResponseResult(IPage page, List<? extends BaseVO> convertToVOList) {
//        this.pageIndex = page.getCurrent();
//        this.pageSize = page.getSize();
//        this.total = page.getTotal();
//        this.pageCount = page.getPages();
//        this.setData(convertToVOList);
//    }
//
//    public PageResponseResult(IPage page, Class<? extends BaseVO> clazz) {
//        this.pageIndex = page.getCurrent();
//        this.pageSize = page.getSize();
//        this.total = page.getTotal();
//        this.pageCount = page.getPages();
//
//        try {
//            Method method = clazz.getMethod("convertToVOList", List.class);
//            List<Object> list = (List<Object>) method.invoke(clazz.newInstance(), page.getRecords());
//            this.setData(list);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//            log.error("clazz.newInstance()实例化方法异常，message:{}", e.getMessage());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//            log.error("访问方法异常，message:{}", e.getMessage());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//            log.error("vo转换失败,方法未找到，message:{}", e.getMessage());
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//            log.error("调用反射方法失败,message:{}", e.getMessage());
//        }
//    }

}

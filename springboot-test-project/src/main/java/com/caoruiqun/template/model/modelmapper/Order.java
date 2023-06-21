package com.caoruiqun.template.model.modelmapper;

import lombok.Data;

/**
 * @author caoruiqun
 * @date 2023/6/17 11:18
 * @desc:
 */
@Data
public class Order {
    private Address address;
    private Customer customer;
    /**
     * 新增订单来源属性
     */
    private String orderSource;
    private Integer amount;

}

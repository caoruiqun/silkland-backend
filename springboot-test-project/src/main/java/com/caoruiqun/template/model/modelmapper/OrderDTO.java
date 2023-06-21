package com.caoruiqun.template.model.modelmapper;

import lombok.Data;

/**
 * @author caoruiqun
 * @date 2023/6/17 11:20
 * @desc:
 */
@Data
public class OrderDTO {
    private String customerFirstName;
    private String customerLastName;
    private String addressStreet;
    private String addressCity;
    /**
     * 新增属性
     */
    private String cityTest;
    private String streetTest;
    private OrderSource orderSource;
    private Integer amount;
    private String priority;
}

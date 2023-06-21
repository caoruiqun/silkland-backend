package com.caoruiqun.template.testmain;

import com.alibaba.fastjson2.JSON;
import com.caoruiqun.template.model.modelmapper.*;
import org.junit.Test;
import org.modelmapper.Condition;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author caoruiqun
 * @date 2023/6/16 10:14
 * @desc:
 */
public class ModelMapperTest {



    @Test
    public void test00() {
    }

    /**
     * 2.1 ModelMapper 基本映射
     */
    @Test
    public void test01() {
        ModelMapper modelMapper = new ModelMapper();

        Order order = new Order();

        Customer customer = new Customer();
        Name name = new Name();
        name.setLastName("周");
        name.setFirstName("程宇");
        customer.setName(name);

        Address address = new Address();
        address.setCity("深圳");
        address.setStreet("龙岗区横岗街道");

        order.setCustomer(customer);
        order.setAddress(address);

        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        String jsonString = JSON.toJSONString(orderDTO);
        System.out.println("jsonString = " + jsonString);
    }

    /**
     * 2.2  ModelMapper 集合转换
     * 功能要求：将List<Order> 转换为List<OrderDTO>
     */
    @Test
    public void test02() {
        Order order = new Order();
        Customer customer = new Customer();
        Name name = new Name();
        name.setLastName("周");
        name.setFirstName("程宇");
        customer.setName(name);
        Address address = new Address();
        address.setCity("深圳");
        address.setStreet("龙岗区横岗街道");
        order.setCustomer(customer);
        order.setAddress(address);

        Order order2 = new Order();
        Customer customer2 = new Customer();
        Name name2 = new Name();
        name2.setLastName("周");
        name2.setFirstName("晨曦");
        customer2.setName(name2);
        Address address2 = new Address();
        address2.setCity("深圳");
        address2.setStreet("盐田区梅沙街道");
        order2.setCustomer(customer2);
        order2.setAddress(address2);

        List<Order> containers =  new ArrayList<>();
        containers.add(order);
        containers.add(order2);

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<OrderDTO>>() {
        }.getType();
        System.out.println("type = " + type);
        List<OrderDTO> orderDTOs = modelMapper.map(containers, new TypeToken<List<OrderDTO>>() {}.getType());
        String jsonString = JSON.toJSONString(orderDTOs);
        System.out.println("jsonString = " + jsonString);
    }

    /**
     *  2.3  ModelMapper 指定默认值
     * 功能要求：Order类实例对象 转换OrderDTO 类实例对象时，将street属性值设置为:龙岗区横岗街道"。
     */
    @Test
    public void test03() {
        ModelMapper modelMapper = new ModelMapper();
        Order order = new Order();
        Customer customer = new Customer();
        Name name = new Name();
        name.setLastName("周");
        name.setFirstName("程宇");
        customer.setName(name);
        Address address = new Address();
        address.setCity("深圳");
        address.setStreet("盐田区梅沙街道");
        order.setCustomer(customer);
        order.setAddress(address);

        modelMapper.createTypeMap(Order.class, OrderDTO.class)
                .addMappings(mapper-> mapper.using((Converter<String, String>) context ->{
                    return "龙岗区横岗街道" ;
                }).map(it-> it.getAddress().getStreet(),OrderDTO::setAddressStreet));

        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        String jsonString = JSON.toJSONString(orderDTO);
        System.out.println("jsonString = " + jsonString);
    }

    /**
     * 2.4  ModelMapper 属性值转换
     * 功能要求：OrderDTO类对象新增cityTest 和streetTest 属性，对应属性值为Order类实例对象Address 属性对象中的city 和street属性。
     */
    @Test
    public void test04() {
        ModelMapper modelMapper = new ModelMapper();
        Order order = new Order();
        Customer customer = new Customer();
        Name name = new Name();
        name.setLastName("周");
        name.setFirstName("程宇");
        customer.setName(name);
        Address address = new Address();
        address.setCity("深圳");
        address.setStreet("盐田区梅沙街道");
        order.setCustomer(customer);
        order.setAddress(address);

        OrderDTO orderDTO =modelMapper.typeMap(Order.class, OrderDTO.class)
                .addMappings(mapper-> {
                    // 自定义属性转换
                    mapper.map(src -> src.getAddress().getStreet(), OrderDTO::setStreetTest);
                    mapper.map(src -> src.getAddress().getCity(), OrderDTO::setCityTest);
                }).map(order);

        String jsonString = JSON.toJSONString(orderDTO);
        System.out.println("jsonString = " + jsonString);
    }

    /**
     * 拓展功能需求：OrderDTO 类对象新增枚举对象属性：OrderSource orderSource, 对应属性值为Order类实例对象新增字符串属性：String orderSource
     */
    @Test
    public void test04Ext01() {
        ModelMapper modelMapper = new ModelMapper();
        Order order = new Order();
        Customer customer = new Customer();
        Name name = new Name();
        name.setLastName("周");
        name.setFirstName("程宇");
        customer.setName(name);
        Address address = new Address();
        address.setCity("深圳");
        address.setStreet("盐田区梅沙街道");
        order.setCustomer(customer);
        order.setAddress(address);
        order.setOrderSource("1");

        OrderDTO orderDTO =modelMapper.typeMap(Order.class, OrderDTO.class)
                .addMappings(mapper-> {
                    // 自定义属性转换
                    mapper.map(src -> src.getAddress().getStreet(), OrderDTO::setStreetTest);
                    mapper.map(src -> src.getAddress().getCity(), OrderDTO::setCityTest);
                    // 字符串转枚举
                    mapper.using((Converter<String, OrderSource>) context ->{
                        return OrderSource.getInstance(context.getSource()) ;
                    }).map(src -> src.getOrderSource(), OrderDTO::setOrderSource);
                }).map(order);

        String jsonString = JSON.toJSONString(orderDTO);
        System.out.println("jsonString = " + jsonString);
    }

    /**
     * 2.5  ModelMapper 属性值跳过
     * ModelMapper 隐式创建从源类型到目标类型中每个属性的映射，但有时可能需要跳过某些目标属性的映射。
     *
     * 功能要求：跳过OrderDTO类实例对象的addressStreet 和addressCity 属性值映射。
     */
    @Test
    public void test05() {
        ModelMapper modelMapper = new ModelMapper();
        Order order = new Order();
        Customer customer = new Customer();
        Name name = new Name();
        name.setLastName("周");
        name.setFirstName("程宇");
        customer.setName(name);
        Address address = new Address();
        address.setCity("深圳");
        address.setStreet("盐田区梅沙街道");
        order.setCustomer(customer);
        order.setAddress(address);
        order.setOrderSource("1");

        OrderDTO orderDTO =modelMapper.typeMap(Order.class, OrderDTO.class)
                .addMappings(mapper-> {
                    //  跳过属性
                    mapper.skip(OrderDTO::setAddressStreet);
                    mapper.skip(OrderDTO::setAddressCity);
                    // 自定义属性转换
                    mapper.map(src -> src.getAddress().getStreet(), OrderDTO::setStreetTest);
                    mapper.map(src -> src.getAddress().getCity(), OrderDTO::setCityTest);
                    // 字符串转枚举
                    mapper.using((Converter<String, OrderSource>) context ->{
                        return OrderSource.getInstance(context.getSource()) ;
                    }).map(src -> src.getOrderSource(), OrderDTO::setOrderSource);
                }).map(order);

        String jsonString = JSON.toJSONString(orderDTO);
        System.out.println("jsonString = " + jsonString);
    }

    /**
     * 2.6 ModelMapper  条件映射
     * ModelMapper 提供Condition条件接口，判断是否执行源属性到模板属性映射。
     *
     * 功能要求：在Order类中添加订单金额字段:amount, 在OrderDTO 类中添加订单金额字段:amount和订单优先级字段priority，如果金额大于1000, priority 设置为最高基本=3，其他设置为普通基本=2。
     */
    @Test
    public void test06() {
        ModelMapper modelMapper = new ModelMapper();
        Order order = new Order();
        Customer customer = new Customer();
        Name name = new Name();
        name.setLastName("周");
        name.setFirstName("程宇");
        customer.setName(name);
        Address address = new Address();
        address.setCity("深圳");
        address.setStreet("盐田区梅沙街道");
        order.setCustomer(customer);
        order.setAddress(address);
        order.setOrderSource("1");
        order.setAmount(100000);

        OrderDTO orderDTO =modelMapper.typeMap(Order.class, OrderDTO.class)
                .addMappings(mapper-> {
                    //  添加判断条件 + 添加自定义转换条件
                    mapper.when((Condition<Integer, String>) context -> context.getSource() != null && context.getSource() > 0).using((Converter<Integer, String>) context ->{
                        return context.getSource() >=1000 ? "3":"2" ;
                    }).map(it-> it.getAmount(),OrderDTO::setPriority);
                    // 自定义属性转换
                    mapper.map(src -> src.getAddress().getStreet(), OrderDTO::setStreetTest);
                    mapper.map(src -> src.getAddress().getCity(), OrderDTO::setCityTest);
                    // 字符串转枚举
                    mapper.using((Converter<String, OrderSource>) context ->{
                        return OrderSource.getInstance(context.getSource()) ;
                    }).map(src -> src.getOrderSource(), OrderDTO::setOrderSource);
                }).map(order);

        String jsonString = JSON.toJSONString(orderDTO);
        System.out.println("jsonString = " + jsonString);
    }

    /**
     *  拓展功能：如果没有设置订单金额，将priority 设置为异常订单=1。
     *  由于没有设置订单金额，导致OrderDTO 类对象中的 priority 属性字段没有对应 映射
     */
    @Test
    public void test07() {
        ModelMapper modelMapper = new ModelMapper();
        Order order = new Order();
        Customer customer = new Customer();
        Name name = new Name();
        name.setLastName("周");
        name.setFirstName("程宇");
        customer.setName(name);
        Address address = new Address();
        address.setCity("深圳");
        address.setStreet("盐田区梅沙街道");
        order.setCustomer(customer);
        order.setAddress(address);
        order.setOrderSource("1");

        OrderDTO orderDTO =modelMapper.typeMap(Order.class, OrderDTO.class)
                .addMappings(mapper-> {
                    //  添加判断条件 + 添加自定义转换条件
                    mapper.when((Condition<Integer, String>) context -> {
                        if(context.getSource() != null && context.getSource()> 0){
                            return true;
                        }
                        return false;
                    }).using((Converter<Integer, String>) context ->{
                        return context.getSource() >=1000 ? "3":"2" ;
                    }).map(it-> it.getAmount(),OrderDTO::setPriority);
                    // 添加判空添加 + 添加默认值
                    mapper.when((Condition<Integer, ?>) condition ->{
                        if(condition.getSource() == null ||  condition.getSource() == 0){
                            return true;
                        }
                        return false;
                    }).using((Converter<Integer, String>) converter->{
                        return "1";
                    }).map(it-> it.getAmount(),OrderDTO::setPriority);

                    // 自定义属性转换
                    mapper.map(src -> src.getAddress().getStreet(), OrderDTO::setStreetTest);
                    mapper.map(src -> src.getAddress().getCity(), OrderDTO::setCityTest);
                    // 字符串转枚举
                    mapper.using((Converter<String, OrderSource>) context ->{
                        return OrderSource.getInstance(context.getSource()) ;
                    }).map(src -> src.getOrderSource(), OrderDTO::setOrderSource);
                }).map(order);

        String jsonString = JSON.toJSONString(orderDTO);
        System.out.println("jsonString = " + jsonString);
    }


}

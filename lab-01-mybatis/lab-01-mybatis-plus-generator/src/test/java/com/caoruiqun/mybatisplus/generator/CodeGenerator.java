package com.caoruiqun.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.query.SQLQuery;
import com.caoruiqun.mybatisplus.config.MySqlTypeConvertCustom;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author lichennan
 * @since 2021年10月24日 16:52
 */
@SpringBootTest
public class CodeGenerator {

    private  String projectPath = System.getProperty("user.dir"); //E:\My Projects\silkland-backend\lab-01-mybatis\lab-01-mybatis-plus
//    private  String projectPath = System.getProperty("E:\\My Projects\\silkland-backend\\lab-01-mybatis\\lab-01-mybatis-plus");

    // 数据源配置
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder("jdbc:mysql://127.0.0.1:3306/caoruiqun?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "root")
//            .typeConvert(new MySqlTypeConvert())
            .typeConvert(new MySqlTypeConvertCustom())
            .databaseQueryClass(SQLQuery.class);
//            .typeConvert(new MySqlTypeConvertCustom());

    @Test
    public void generatorCode() {
        FastAutoGenerator
                .create(DATA_SOURCE_CONFIG)
                //全局配置
                .globalConfig(builder -> {
                    builder.author("caoruiqun") // 设置作者
                            // .enableSwagger() // 开启 swagger 模式
                            .disableOpenDir() // 执行完毕不打开文件夹
                            .fileOverride() // 覆盖已生成文件
//                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                            .outputDir(projectPath); // 指定输出目录
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("org.mybatisplus.generator") // 设置父包名
                            .controller("controller") //生成controller层
                            .entity("entity") //生成实体层
                            .service("service") //生成服务层
                            .mapper("mapper"); //生成mapper层
//                     .moduleName("mybatis-plus-generator");
                })
                //策略配置
                .strategyConfig(builder -> {
//                    builder.addInclude("tbl_employee","tbl_dept")
                    builder.addInclude("sys_banner") // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_")
                            .addTablePrefix("sys_")// 设置过滤表前缀
                            .serviceBuilder() //开启service策略配置
                            .formatServiceFileName("%sService") //取消Service前的I
                            .mapperBuilder()
                            .enableMapperAnnotation()//开启mapper注解
                            .controllerBuilder() //开启controller策略配置
                            .enableRestStyle() //配置restful风格
                            .enableHyphenStyle() //url中驼峰转连字符
                            .entityBuilder() //开启实体类配置
                            .enableTableFieldAnnotation()//开启生成实体时生成字段注解
                            .idType(IdType.AUTO)//添加全局主键类型
                            .logicDeleteColumnName("deleted")
                            .enableLombok(); //开启lombok
//                            .enableChainModel(); //开启lombok链式操作

                })
                //模板配置
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                //执行
                .execute();
    }
}
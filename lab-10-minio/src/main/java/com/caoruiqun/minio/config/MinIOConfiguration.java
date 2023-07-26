package com.caoruiqun.minio.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.*;

@Configuration
public class MinIOConfiguration {

    @Bean
    public MinioClient minioClient() {
        // Minio 配置。实际项目中，定义到 application.yml 配置文件中
        String endpoint = "http://192.168.0.30:38100/";
        String accessKey = "root";
        String secretKey = "OpUser123";

        // 创建 MinioClient 客户端
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

}

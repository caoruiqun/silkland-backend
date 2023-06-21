CREATE TABLE `t_user_info` (
   `id` int NOT NULL AUTO_INCREMENT,
   `name` varchar(10) NOT NULL,
   `age` int DEFAULT NULL,
   `create_time` datetime DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
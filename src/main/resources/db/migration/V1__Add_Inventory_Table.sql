CREATE TABLE `inventory` (
  `id`                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `inventory_id`         VARCHAR(20)  NOT NULL,
  `name`         VARCHAR(20)  NOT NULL,
  `amount`     BIGINT  NOT NULL,
  `created_date` TIMESTAMP
);
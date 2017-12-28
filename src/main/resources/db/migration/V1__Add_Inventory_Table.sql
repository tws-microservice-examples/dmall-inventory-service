CREATE TABLE `inventory` (
  `id`                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `sku`         VARCHAR(20)  NOT NULL,
  `warehouse`         VARCHAR(20)  NOT NULL,
  `quantity`     BIGINT  NOT NULL,
  `created_date` TIMESTAMP
);
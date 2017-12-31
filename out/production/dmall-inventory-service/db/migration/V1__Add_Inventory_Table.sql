CREATE TABLE `inventory` (
  `id`                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `sku`         VARCHAR(20)  NOT NULL,
  `warehouse`         VARCHAR(20)  NOT NULL,
  `currentQuantity`     BIGINT  NOT NULL,
  `lockedQuantity`     BIGINT  NOT NULL,
  `created_date` TIMESTAMP
);
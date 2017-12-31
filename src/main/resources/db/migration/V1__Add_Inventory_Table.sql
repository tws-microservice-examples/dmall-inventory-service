CREATE TABLE `inventory` (
  `id`                 BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `sku`         VARCHAR(20)  NOT NULL,
  `warehouse`         VARCHAR(20)  NOT NULL,
  `current_quantity`     BIGINT  NOT NULL,
  `locked_quantity`     BIGINT  NOT NULL,
  `created_date` TIMESTAMP
);

INSERT INTO inventory (id, sku, warehouse, current_quantity, locked_quantity, created_date) VALUES (null, 'iPhone X 64G 黑色', '北京仓', 100, 0, null);
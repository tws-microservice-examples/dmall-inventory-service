ALTER TABLE `inventory` CHANGE COLUMN `currentQuantity` `current_quantity` BIGINT NOT NULL;
ALTER TABLE `inventory` CHANGE COLUMN `lockedQuantity` `locked_quantity` BIGINT NOT NULL;

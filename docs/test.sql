create table `item`
(
    `item_id` bigint(20) NOT NULL AUTO_INCREMENT comment "商品编号",
    `name`    varchar(10) COMMENT "商品名称",
    `number`  int(10) unsigned NOT NULL DEFAULT 0 COMMENT "数量",
    PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table `order`
(
    `order_id` bigint(20) NOT NULL AUTO_INCREMENT comment "订单编号",
    `item_id`  bigint(20) COMMENT "商品编号",
    `user_id`  bigint(20) COMMENT "用户id",
    PRIMARY KEY (`order_id`, `item_id`, `user_id`),
    FOREIGN KEY (item_id) REFERENCES item (item_id),
    FOREIGN KEY (user_id) REFERENCES `user` (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


create table `user`
(
    `user_id`  bigint(20) NOT NULL AUTO_INCREMENT comment "用户编号",
    `name`     varchar(10) COMMENT "用户名称",
    `password` varchar(16) COMMENT "用户密码",
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into item
values (1, "商品1", 1),
       (2, "商品2", 2),
       (3, "商品3", 3),
       (4, "商品4", 4),
       (5, "商品5", 5),
       (6, "商品6", 6),
       (7, "商品7", 7);
insert into item
values (8, "商品8", 8),
       (9, "商品9", 9),
       (10, "商品10", 10),
       (11, "商品11", 11),
       (12, "商品12", 12),
       (13, "商品13", 13),
       (14, "商品14", 14);
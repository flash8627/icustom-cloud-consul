
# spring(2.0.1.RELEASE) security(spring-boot-starter-security 2.0.1.RELEASE security spring-security-config-5.0.4.RELEASE)
  *添加测试数据：
  ```
  -- ----------------------------
-- Table structure for `s_user`
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `s_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role` (
  `fk_user_id` int(11) DEFAULT NULL,
  `fk_role_id` int(11) DEFAULT NULL,
  KEY `union_key` (`fk_user_id`,`fk_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `s_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id` int(11) NOT NULL,
  `role` varchar(32) DEFAULT NULL,
  `describe` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `s_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `s_role_permission`;
CREATE TABLE `s_role_permission` (
  `fk_role_id` int(11) DEFAULT NULL,
  `fk_permission_id` int(11) DEFAULT NULL,
  KEY `union_key` (`fk_role_id`,`fk_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `s_permission`
-- ----------------------------
DROP TABLE IF EXISTS `s_permission`;
CREATE TABLE `s_permission` (
  `id` int(11) NOT NULL,
  `permission` varchar(32) DEFAULT NULL,
  `url` varchar(32) DEFAULT NULL,
  `describe` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  ```

  *添加测试数据：
  ```
  -- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `s_user` VALUES ('2', 'veiking', 'veiking');
INSERT INTO `s_user` VALUES ('3', 'xiaoming', 'xiaoming');

-- ----------------------------
-- Records of s_user_role
-- ----------------------------
INSERT INTO `s_user_role` VALUES ('1', '1');
INSERT INTO `s_user_role` VALUES ('2', '2');

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('1', 'R_ADMIN', '大总管，所有权限');
INSERT INTO `s_role` VALUES ('2', 'R_HELLO', '说hello相关的权限');

-- ----------------------------
-- Records of s_role_permission
-- ----------------------------
INSERT INTO `s_role_permission` VALUES ('1', '1');
INSERT INTO `s_role_permission` VALUES ('1', '2');
INSERT INTO `s_role_permission` VALUES ('1', '3');
INSERT INTO `s_role_permission` VALUES ('2', '1');
INSERT INTO `s_role_permission` VALUES ('2', '3');

-- ----------------------------
-- Records of s_permission
-- ----------------------------
INSERT INTO `s_permission` VALUES ('1', 'P_INDEX', '/index', 'index页面资源');
INSERT INTO `s_permission` VALUES ('2', 'P_ADMIN', '/admin', 'admin页面资源');
INSERT INTO `s_permission` VALUES ('3', 'P_HELLO', '/hello', 'hello页面资源');
  ```

# 预览测试地址
  http://localhost:8090/
  http://localhost:8090/login


# 目前存在的问题
  * 登陆不成功，报空异常
    
  * 其它









-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.19-0ubuntu0.16.04.1 - (Ubuntu)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 anthony.t_a_user 结构
CREATE TABLE IF NOT EXISTS `t_a_user` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `email` varchar(255) DEFAULT NULL COMMENT 'emial',
  `phone_number` varchar(15) DEFAULT NULL COMMENT '手机号',
  `gender` int(1) DEFAULT '0' COMMENT '性别',
  `head_photo` text COMMENT '头像base64',
  `inherit_organization_power` char(1) NOT NULL DEFAULT '0' COMMENT '是否继承组织权限',
  `organization_id` int(5) DEFAULT '0' COMMENT '组织ID',
  `role_id` int(5) DEFAULT '0' COMMENT '权限表关联',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `register_type` int(1) NOT NULL COMMENT '注册类型',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `operator_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `USER_NAME` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

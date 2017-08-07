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

-- 导出  表 anthony.t_a_equipment 结构
CREATE TABLE IF NOT EXISTS `t_a_equipment` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(5) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `uuid` varchar(50) NOT NULL DEFAULT '0' COMMENT '设备UUID',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `token` varchar(32) NOT NULL COMMENT '登陆TOKEN',
  `login_time_stamp` datetime NOT NULL COMMENT '登录时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备表';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

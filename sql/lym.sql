use `ry-vue`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for driver
-- ----------------------------
DROP TABLE IF EXISTS `sys_driver`;

CREATE TABLE `sys_driver` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
`driver_name` varchar(30) NOT NULL COMMENT '驾驶员姓名',
`sex` char(1) default '0' COMMENT '驾驶员性别(0男 1女)',
`age` tinyint UNSIGNED NOT NULL COMMENT '年龄',
`driving_age` tinyint UNSIGNED NOT NULL COMMENT '驾龄',
`birthday` datetime COMMENT '生日',
`tel` varchar(100) DEFAULT NULL COMMENT '联系方式',
`mail` varchar(100) DEFAULT NULL COMMENT '邮箱',
`remark` varchar(500) DEFAULT NULL COMMENT '备注',
PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='驾驶员表';

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `sys_car`;

CREATE TABLE `sys_car` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
`car_name` varchar(30) NOT NULL COMMENT '车辆名称', -- Airsim小车
`car_type` varchar(30) NOT NULL COMMENT '车辆类型', -- 小客车
`car_length` varchar(30) NOT NULL COMMENT '车辆全长(m)', -- 4.17
`car_width` varchar(30) NOT NULL COMMENT '车辆总宽(m)', -- 1.72
`car_height` varchar(30) NOT NULL COMMENT '车辆总高(m)', -- 1.58
`car_wheelbase` varchar(30) NOT NULL COMMENT '车辆轴距(m)', -- 2.35
`car_maxtorque` varchar(30) COMMENT '车辆最大扭矩(Nm)', -- 512
`car_maxrpm` varchar(30) COMMENT '车辆最高转速(r/min)', -- 7500
`car_differential` varchar(30) COMMENT '车辆差速器类型', -- 限滑前驱
PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='车辆参数表';


-- ----------------------------
-- Table structure for environment
-- ----------------------------
DROP TABLE IF EXISTS `sys_environment`;

CREATE TABLE `sys_environment` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
`env_name` varchar(30) NOT NULL COMMENT '实验环境名称',
`map_name` varchar(30) NOT NULL COMMENT '地图名称',
`env_background` varchar(500) DEFAULT NULL COMMENT '工程背景',
PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='实验环境表';

-- ----------------------------
-- Table structure for driving simulation
-- ----------------------------
DROP TABLE IF EXISTS `sys_simulation`;
CREATE TABLE `sys_simulation` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
`did` int(11) NOT NULL COMMENT '驾驶员编号',
`cartype` varchar(100) NOT NULL COMMENT '车辆类型',
`environment` varchar(100) NOT NULL COMMENT '实验环境',
`env_remark` varchar(100) COMMENT '实验备注',
`starttime` varchar(100) NOT NULL COMMENT '开始时间',
PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='驾驶实验表';

-- ----------------------------
-- Table structure for simulation data
-- ----------------------------
DROP TABLE IF EXISTS `sys_simulationdata`;
CREATE TABLE `sys_simulationdata` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
`sid` int(11) NOT NULL COMMENT '驾驶实验表编号',
`loc_x` float NOT NULL COMMENT 'x坐标',
`loc_y` float NOT NULL COMMENT 'y坐标',
`loc_z` float NOT NULL COMMENT 'z坐标',
`speed` float NOT NULL COMMENT '车速',
`vx` float NOT NULL COMMENT 'x方向速度',
`vy` float NOT NULL COMMENT 'y方向速度',
`vz` float NOT NULL COMMENT 'z方向速度',
`a` float NOT NULL COMMENT '加速度',
`ax` float NOT NULL COMMENT 'x方向加速度',
`ay` float NOT NULL COMMENT 'y方向加速度',
`az` float NOT NULL COMMENT 'z方向加速度',
`gear` int NOT NULL COMMENT '档位',
`rpm` float NOT NULL COMMENT '转速',
`traveled_distance` float NOT NULL COMMENT '行驶里程',
`simulation_time` varchar(100) NOT NULL COMMENT '时间戳',
PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='驾驶数据表';

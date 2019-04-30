/*
Navicat MySQL Data Transfer

Source Server         : localhost_3360
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : chatdb

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2018-09-30 17:24:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comregistration
-- ----------------------------
DROP TABLE IF EXISTS `comregistration`;
CREATE TABLE `comregistration` (
  `Company_name` varchar(255) DEFAULT NULL,
  `Legal_representative` varchar(255) DEFAULT NULL,
  `Company_code` varchar(255) DEFAULT NULL,
  `Company_address` varchar(255) DEFAULT NULL,
  `Tax_number` varchar(255) DEFAULT NULL,
  `Company_nature` varchar(255) DEFAULT NULL,
  `Registered_capital` varchar(255) DEFAULT NULL,
  `Contact_name` varchar(255) DEFAULT NULL,
  `Contact_number` varchar(11) DEFAULT NULL,
  `Contact_email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `ProID` varchar(11) NOT NULL,
  `Logistics_packaging_unit` varchar(255) DEFAULT NULL,
  `Number_of_packages` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`ProID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `Product_name` varchar(255) DEFAULT NULL,
  `Specification_model` varchar(255) DEFAULT NULL,
  `Manufacturer_name` varchar(255) DEFAULT NULL,
  `Owner_name` varchar(255) DEFAULT NULL,
  `Date_of_manufacture` varchar(255) DEFAULT NULL,
  `Quality_guarantee_period` varchar(255) DEFAULT NULL,
  `Production_batch` varchar(255) DEFAULT NULL,
  `Company_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;

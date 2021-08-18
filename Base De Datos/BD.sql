-- --------------------------------------------------------
-- Host:                         mutant.cotpeidr2apb.us-east-2.rds.amazonaws.com
-- Server version:               10.4.13-MariaDB-log - Source distribution
-- Server OS:                    Linux
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for mutant
DROP DATABASE IF EXISTS `mutant`;
CREATE DATABASE IF NOT EXISTS `mutant` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mutant`;

-- Dumping structure for table mutant.ADN
DROP TABLE IF EXISTS `ADN`;
CREATE TABLE IF NOT EXISTS `ADN` (
  `adn` varchar(255) NOT NULL,
  PRIMARY KEY (`adn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for procedure mutant.incstats
DROP PROCEDURE IF EXISTS `incstats`;
DELIMITER //
CREATE PROCEDURE `incstats`(
	IN `idname` VARCHAR(50)
)
BEGIN
	DECLARE QTITY TINYINT DEFAULT 0;
	SELECT count(*) into QTITY FROM STATS WHERE name=idname;
	
	IF QTITY=0 THEN
		INSERT INTO STATS (name,value) VALUES (idname,1);
	ELSE
		UPDATE STATS SET value=value+1 WHERE name=idname;
	END IF;
END//
DELIMITER ;

-- Dumping structure for table mutant.STATS
DROP TABLE IF EXISTS `STATS`;
CREATE TABLE IF NOT EXISTS `STATS` (
  `name` varchar(50) DEFAULT NULL,
  `value` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

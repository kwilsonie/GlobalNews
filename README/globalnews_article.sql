-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: globalnews
-- ------------------------------------------------------
-- Server version	5.1.73

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `dateUpdated` date DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `location` varchar(100) NOT NULL,
  `category` int(10) unsigned DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  `comment` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pn_user_index` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,1,'Facebook says its running out of places to show ads in your news feed ','FACEBOOK REPORTED ANOTHER strong earnings quarter thanks to a significant boost in earnings. The company’s net profit jumped by 186% from a year ago to $2.05 billion (€1.84 billion) and total revenue jumped up to $6.4 billion (€5.76 billion). The majority of this came from advertising revenue, where approximately 84% of revenue came from mobile. But while advertising is where the majority of revenue comes from, the likelihood of it continuing this rapid growth becomes more difficult as it runs out of places to insert ads. ','2016-07-28','2016-07-28','Dublin',1,1,'None'),(2,1,'Joe got us believing that we were good enough to beat anyone','CONOR MURRAY BELIEVES Ireland could deal with losing Joe Schmidt as head coach next summer, but underlined his desire to see the New Zealander stay on beyond 2017. Schmidt has been at home in New Zealand in recent weeks pondering his future, with decision about whether to remain with Ireland through to the 2019 World Cup weighing on his mind.','2016-07-28','2016-07-28','Dublin',1,3,'None'),(3,1,'Its official: Apple has sold a billion iPhones','APPLE HAS CONFIRMED that it recently sold its billionth iPhone. More than nine years after the original iPhone was launched, Apples CEO Tim Cook confirmed it had passed the milestone at an employee meeting yesterday. iPhone has become one of the most important, world-changing and successful products in history, said Cook in a statement. We never set out to make the most, but we always set out to make the best products that make a difference.','2016-07-28','2016-07-28','Dublin',1,4,'None'),(6,1,'Dublin Bus drivers reject 8.25% pay increase','MEMBERS OF STAFF at Dublin Bus have overwhelmingly rejected a Labour Court recommendation that they get an 8.25% pay increase. Workers at the company had sought pay rises of up to 30% in order to bring them in to line with Luas drivers, but have been told they should be paid less than a third of that.Today, 95% of members of the National Bus and Rail Union (NBRU), which represents mostly drivers, as well as 96% of drivers and 95% of clerical staff who are in SIPTU, rejected the deal.','2016-07-29','2016-07-29','Dublin',1,1,'None'),(7,1,'These two people are running the ENTIRE Wild Atlantic Way for charity','That’s the advice of Lillian Deegan, a long-distance runner in the middle of one of her biggest challenges to date. She and Tom Reynolds are currently running the entire Wild Atlantic Way. Driving the 2,500km route would be a daunting enough task, but the Wicklow duo are going above and beyond that. They hope to raise €10,000 for suicide prevention charity Pieta House and Billy’s World Ireland, a charity looking to build a recreation facility for children with disabilities.','2016-08-01','2016-08-01','Wicklow',0,1,'None'),(8,1,'These two people are running the ENTIRE Wild Atlantic Way for charity','That’s the advice of Lillian Deegan, a long-distance runner in the middle of one of her biggest challenges to date. She and Tom Reynolds are currently running the entire Wild Atlantic Way. Driving the 2,500km route would be a daunting enough task, but the Wicklow duo are going above and beyond that. They hope to raise €10,000 for suicide prevention charity Pieta House and Billy’s World Ireland, a charity looking to build a recreation facility for children with disabilities.','2016-08-01','2016-08-01','Wicklow',0,1,'None'),(9,1,'These two people are running the ENTIRE Wild Atlantic Way for charity','That’s the advice of Lillian Deegan, a long-distance runner in the middle of one of her biggest challenges to date. She and Tom Reynolds are currently running the entire Wild Atlantic Way. Driving the 2,500km route would be a daunting enough task, but the Wicklow duo are going above and beyond that. They hope to raise €10,000 for suicide prevention charity Pieta House and Billy’s World Ireland, a charity looking to build a recreation facility for children with disabilities.','2016-08-01','2016-08-01','Wicklow',0,1,'None'),(10,1,'These two people are running the ENTIRE Wild Atlantic Way for charity','That’s the advice of Lillian Deegan, a long-distance runner in the middle of one of her biggest challenges to date. She and Tom Reynolds are currently running the entire Wild Atlantic Way. Driving the 2,500km route would be a daunting enough task, but the Wicklow duo are going above and beyond that. They hope to raise €10,000 for suicide prevention charity Pieta House and Billy’s World Ireland, a charity looking to build a recreation facility for children with disabilities.','2016-08-01','2016-08-01','Wicklow',0,1,'None'),(11,1,'These two people are running the ENTIRE Wild Atlantic Way for charity','That’s the advice of Lillian Deegan, a long-distance runner in the middle of one of her biggest challenges to date. She and Tom Reynolds are currently running the entire Wild Atlantic Way. Driving the 2,500km route would be a daunting enough task, but the Wicklow duo are going above and beyond that. They hope to raise €10,000 for suicide prevention charity Pieta House and Billy’s World Ireland, a charity looking to build a recreation facility for children with disabilities.','2016-08-01','2016-08-01','Wicklow',0,1,'None'),(12,1,'These two people are running the ENTIRE Wild Atlantic Way for charity','That’s the advice of Lillian Deegan, a long-distance runner in the middle of one of her biggest challenges to date. She and Tom Reynolds are currently running the entire Wild Atlantic Way. Driving the 2,500km route would be a daunting enough task, but the Wicklow duo are going above and beyond that. They hope to raise €10,000 for suicide prevention charity Pieta House and Billy’s World Ireland, a charity looking to build a recreation facility for children with disabilities.','2016-08-01','2016-08-01','Wicklow',0,1,'None');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-02 11:48:55

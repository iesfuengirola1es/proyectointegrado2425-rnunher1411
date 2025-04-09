-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: trivialdroid
-- ------------------------------------------------------
-- Server version	9.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ingles`
--

DROP TABLE IF EXISTS `ingles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingles` (
  `ASIGNATURA_ID` int NOT NULL,
  `NIVEL` varchar(2) DEFAULT NULL,
  `FRASE_INGLES` varchar(255) DEFAULT NULL,
  `FRASE_ESPANYOL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ASIGNATURA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingles`
--

LOCK TABLES `ingles` WRITE;
/*!40000 ALTER TABLE `ingles` DISABLE KEYS */;
INSERT INTO `ingles` VALUES (1,'A1','I have a cat','Tengo un gato'),(2,'A1','She is my friend','Ella es mi amiga'),(3,'A1','I live in a small house','Vivo en una casa pequeña'),(4,'A1','We live in Spain','Vivimos en España'),(5,'A1','My favorite color is blue','Mi color favorito es el azul'),(6,'A1','Where do you live?','¿Dónde vives?'),(7,'A1','The weather is nice','El clima es agradable'),(8,'A1','The cat is under the table','El gato está debajo de la mesa'),(9,'A1','They are playing in the park','Ellos están jugando en el parque'),(10,'A1','We are going to the cinema','Vamos al cine'),(11,'A2','I\'m going to visit my grandparents next weekend','Voy a visitar a mis abuelos el próximo fin de semana'),(12,'A2','I\'ve been studying English for two years','Llevo estudiando inglés dos años'),(13,'A2','I think I\'ve lost my keys','Creo que he perdido mis llaves'),(14,'A2','She was waiting for the bus when it started to rain','Ella estaba esperando el autobús cuando empezó a llover'),(15,'A2','We went to the museum and saw some beautiful paintings','Fuimos al museo y vimos algunas pinturas hermosas'),(16,'A2','Do you know how to cook pasta?','¿Sabes cómo cocinar pasta?'),(17,'A2','She hasn\'t finished her work yet','Ella aún no ha terminado su trabajo'),(18,'A2','The weather is better than it was yesterday','El clima está mejor que ayer'),(19,'A2','She wasn\'t at home when I called','Ella no estaba en casa cuando llamé'),(20,'A2','I\'ve never been to Paris before','Nunca he estado en París antes'),(21,'B1','This year I want to focus more on my personal development','Este año quiero enfocarme más en mi desarrollo personal'),(22,'B1','You shouldn\'t worry so much about the small details','No deberías preocuparte tanto por los pequeños detalles'),(23,'B1','I haven\'t decided where to go on vacation yet','Todavía no he decidido a dónde ir de vacaciones'),(24,'B1','He has already finished his homework, so he\'s watching TV','Él ya ha terminado su tarea, así que está viendo la televisión'),(25,'B1','I need to finish this report before the end of the day','Necesito terminar este informe antes de que termine el día'),(26,'B1','She is the most talented musician I know','Ella es la música más talentosa que conozco'),(27,'B1','I had never seen such a beautiful painting before','Nunca había visto una pintura tan hermosa antes'),(28,'B1','If I had studied more, I would have passed the exam','Si hubiera estudiado más, habría aprobado el examen'),(29,'B1','The more I practice, the better I become','Cuanto más practico, mejor me vuelvo'),(30,'B1','I didn\'t realize how late it was until I looked at my watch','No me di cuenta de lo tarde que era hasta que miré mi reloj'),(31,'B2','She has been working here for over a decade and has seen changes','Ha estado trabajando aquí durante más de una década y ha visto cambios'),(32,'B2','The weather was so bad that we decided to stay indoors','El clima era tan malo que decidimos quedarnos dentro'),(33,'B2','I wish you had told me about the meeting beforehand','Ojalá me hubieras dicho sobre la reunión con antelación'),(34,'B2','There\'s no point in worrying about things you can\'t control','No tiene sentido preocuparse por cosas que no puedes controlar'),(35,'B2','The more you practice, the easier it becomes','Cuanto más practicas, más fácil se vuelve'),(36,'B2','Had I known about the event, I would have prepared something special','Si hubiera sabido del evento, habría preparado algo especial'),(37,'B2','If I could turn back time, I would do things differently','Si pudiera retroceder el tiempo, haría las cosas de manera diferente'),(38,'B2','He has a good sense of humor, which makes him popular','Tiene un buen sentido del humor, lo que lo hace popular'),(39,'B2','Had I known you were coming, I would have made dinner','Si hubiera sabido que venías, habría preparado la cena'),(40,'B2','I\'m looking forward to our next vacation','Estoy esperando con ansias nuestras próximas vacaciones'),(41,'C1','I was under the assumption that the meeting had been postponed','Estaba bajo la suposición de que la reunión había sido pospuesta'),(42,'C1','Had the government acted sooner, damage could have been avoided','Si el gobierno hubiera actuado antes, el daño podría haberse evitado'),(43,'C1','The film was praised for its innovative approach to storytelling','La película fue elogiada por su enfoque innovador de la narración'),(44,'C1','She managed to maintain her composure despite the challenging circumstances','Ella logró mantener la compostura a pesar de las circunstancias desafiantes'),(45,'C1','Had it not been for her quick thinking, the situation could have escalated','Si no hubiera sido por su rápida manera de pensar, la situación podría haber escalado'),(46,'C1','There is a growing consensus that more needs to be done to combat climate change','Existe un consenso creciente de que se necesita hacer más para combatir el cambio climático'),(47,'C1','The decision to cut funding has sparked a great deal of controversy','La decisión de recortar fondos ha generado mucha controversia'),(48,'C1','He is well-known for his ability to think on his feet during high-pressure situations','Es conocido por su capacidad para pensar con rapidez en situaciones de alta presión'),(49,'C1','She felt an overwhelming sense of gratitude for the support she had received','Sintió un abrumador sentimiento de gratitud por el apoyo que había recibido'),(50,'C1','The company has been struggling to stay afloat amid the economic downturn','La empresa ha estado luchando por mantenerse a flote en medio de la recesión económica'),(51,'C2','Her performance in the debate was nothing short of extraordinary','Su desempeño en el debate fue nada menos que extraordinario'),(52,'C2','It\'s imperative that we address these issues with a sense of urgency','Es imperativo que abordemos estos problemas con sentido de urgencia'),(53,'C2','Her unwavering commitment to excellence was evident in her work','Su compromiso inquebrantable con la excelencia era evidente en su trabajo'),(54,'C2','It requires a discerning eye to appreciate the subtleties of the text','Se requiere un ojo crítico para apreciar las sutilezas del texto'),(55,'C2','Despite their differences, they reached a consensus','A pesar de sus diferencias, llegaron a un consenso'),(56,'C2','The findings were interpreted with a commendable level of insight','Los hallazgos fueron interpretados con un nivel de perspicacia encomiable'),(57,'C2','The presentation was both thought-provoking and informative','La presentación fue tanto estimulante como informativa'),(58,'C2','The clarity of his argument left little room for doubt','La claridad de su argumento dejó poco margen para la duda'),(59,'C2','The discussion was enlightening, shedding new light on the subject','La discusión fue esclarecedora, arrojando nueva luz sobre el tema'),(60,'C2','The argument was so well-constructed that it left no room for rebuttal','El argumento estaba tan bien construido que no dejó espacio para la réplica');
/*!40000 ALTER TABLE `ingles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matematicas`
--

DROP TABLE IF EXISTS `matematicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matematicas` (
  `ASIGNATURA_ID` int NOT NULL,
  `NOMBRE` varchar(20) DEFAULT NULL,
  `SIMBOLO` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ASIGNATURA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matematicas`
--

LOCK TABLES `matematicas` WRITE;
/*!40000 ALTER TABLE `matematicas` DISABLE KEYS */;
INSERT INTO `matematicas` VALUES (1,'Suma','+'),(2,'Resta','-'),(3,'Multiplicación','*'),(4,'División','/'),(5,'Variado','+,-,*,/'),(6,'Algebra','a,b');
/*!40000 ALTER TABLE `matematicas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-10 14:37:33

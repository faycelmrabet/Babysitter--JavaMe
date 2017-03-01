-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mar 05 Mai 2015 à 23:23
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.3.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `bd_baby_sitting`
--
CREATE DATABASE IF NOT EXISTS `bd_baby_sitting` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bd_baby_sitting`;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE IF NOT EXISTS `evenement` (
  `idEvenement` int(11) NOT NULL AUTO_INCREMENT,
  `nomEvenement` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lieuEvenement` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dateEvenement` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `organisateur` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nbreVisiteur` int(11) NOT NULL,
  `path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idEvenement`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Contenu de la table `evenement`
--



-- --------------------------------------------------------

--
-- Structure de la table `fichebabysitter`
--

CREATE TABLE IF NOT EXISTS `fichebabysitter` (
  `idFiche` int(11) NOT NULL AUTO_INCREMENT,
  `typeb` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nbmissions` int(11) NOT NULL,
  `nbenfants` int(11) NOT NULL,
  `tarif` int(11) NOT NULL,
  `distance` int(11) NOT NULL,
  `experience` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sexe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` int(11) NOT NULL,
  `ville` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `codepostal` int(11) NOT NULL,
  `pays` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `photo` longblob,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFiche`),
  KEY `IDX_54FC15F1FE6E88D7` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Contenu de la table `fichebabysitter`
--




-- --------------------------------------------------------

--
-- Structure de la table `garderie`
--

CREATE TABLE IF NOT EXISTS `garderie` (
  `idGarderie` int(11) NOT NULL AUTO_INCREMENT,
  `nomGarderie` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(2000) COLLATE utf8_unicode_ci NOT NULL,
  `tarif` double NOT NULL,
  `codePostale` int(11) NOT NULL,
  `nomResponsable` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  `path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idGarderie`),
  KEY `IDX_6AFFB2EBFE6E88D7` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Contenu de la table `garderie`
--


-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thread_id` int(11) DEFAULT NULL,
  `sender_id` int(11) DEFAULT NULL,
  `body` longtext COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_790009E3E2904019` (`thread_id`),
  KEY `IDX_790009E3F624B39D` (`sender_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Contenu de la table `message`
--



-- --------------------------------------------------------

--
-- Structure de la table `messagemetadata`
--

CREATE TABLE IF NOT EXISTS `messagemetadata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` int(11) DEFAULT NULL,
  `participant_id` int(11) DEFAULT NULL,
  `is_read` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_DA67B3AD537A1329` (`message_id`),
  KEY `IDX_DA67B3AD9D1C3019` (`participant_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Contenu de la table `messagemetadata`
--



-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE IF NOT EXISTS `mission` (
  `idMission` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `horaire` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  `typeUser` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idMission`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Contenu de la table `mission`
--

-- --------------------------------------------------------

--
-- Structure de la table `newsletter`
--

CREATE TABLE IF NOT EXISTS `newsletter` (
  `idNewsLetter` int(11) NOT NULL AUTO_INCREMENT,
  `addressDest` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `addresseExp` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `objet` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `contenu` varchar(2000) COLLATE utf8_unicode_ci NOT NULL,
  `file` longblob,
  PRIMARY KEY (`idNewsLetter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `offremission`
--

CREATE TABLE IF NOT EXISTS `offremission` (
  `numOffre` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(2000) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `horaire` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `typeUser` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`numOffre`),
  KEY `IDX_EDE7594FE6E88D7` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=14 ;

--
-- Contenu de la table `offremission`
--



-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE IF NOT EXISTS `reclamation` (
  `idReclamation` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `typeUser` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dateReclamation` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReclamation`),
  KEY `IDX_CE606404FE6E88D7` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Contenu de la table `reclamation`
--



-- --------------------------------------------------------

--
-- Structure de la table `thread`
--

CREATE TABLE IF NOT EXISTS `thread` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createdAt` datetime NOT NULL,
  `isSpam` tinyint(1) NOT NULL,
  `createdBy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_368C49B53174800F` (`createdBy_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Contenu de la table `thread`
--



-- --------------------------------------------------------

--
-- Structure de la table `threadmetadata`
--

CREATE TABLE IF NOT EXISTS `threadmetadata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thread_id` int(11) DEFAULT NULL,
  `participant_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL,
  `last_participant_message_date` datetime DEFAULT NULL,
  `last_message_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_BEF427AEE2904019` (`thread_id`),
  KEY `IDX_BEF427AE9D1C3019` (`participant_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Contenu de la table `threadmetadata`
--



-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `locked` tinyint(1) DEFAULT NULL,
  `expired` tinyint(1) DEFAULT NULL,
  `expires_at` datetime DEFAULT NULL,
  `confirmation_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci COMMENT '(DC2Type:array)',
  `credentials_expired` tinyint(1) DEFAULT NULL,
  `credentials_expire_at` datetime DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dateNaissance` date NOT NULL,
  `cin` int(11) NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `codePostale` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` int(11) NOT NULL,
  `nbreEnfant` int(11) DEFAULT NULL,
  `typeUser` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `etat` int(11) NOT NULL,
  `note` int(11) DEFAULT '0',
  `facebookId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_8D93D649A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_8D93D64992FC23A8` (`username_canonical`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=30 ;

--
-- Contenu de la table `user`
--


--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `fichebabysitter`
--


--
-- Contraintes pour la table `garderie`
--


--
-- Contraintes pour la table `message`
--


--
-- Contraintes pour la table `messagemetadata`
--


--
-- Contraintes pour la table `offremission`
--


--
-- Contraintes pour la table `reclamation`
--


--
-- Contraintes pour la table `thread`
--


--
-- Contraintes pour la table `threadmetadata`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 12 déc. 2019 à 01:36
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionclinique`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_admin` int(11) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  `age` int(11) NOT NULL,
  `tel` int(11) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `id_admin`, `nom`, `prenom`, `age`, `tel`, `adresse`, `mdp`) VALUES
(1, 7, 'fahd', 'zaghdoudi', 23, 28320921, 'nouvelle medina 3', 'aaa');

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

DROP TABLE IF EXISTS `chambre`;
CREATE TABLE IF NOT EXISTS `chambre` (
  `numCh` int(11) NOT NULL,
  `dispo` varchar(25) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `chambre`
--

INSERT INTO `chambre` (`numCh`, `dispo`) VALUES
(9, 'Disponible'),
(13, 'Disponible'),
(2, 'Non disponible'),
(7, 'Disponible'),
(6, 'Non disponible'),
(45, 'Disponible'),
(32, 'Non disponible');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `numFact` int(11) NOT NULL,
  `montant` double NOT NULL,
  `id_patient` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`numFact`, `montant`, `id_patient`) VALUES
(321, 145.89, 15),
(41, 111.566, 9),
(13, 98.65, 7),
(60, 77.9, 13),
(11, 100, 45);

-- --------------------------------------------------------

--
-- Structure de la table `infirmier`
--

DROP TABLE IF EXISTS `infirmier`;
CREATE TABLE IF NOT EXISTS `infirmier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_inf` int(11) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  `age` int(11) NOT NULL,
  `tel` int(11) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `service` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `infirmier`
--

INSERT INTO `infirmier` (`id`, `id_inf`, `nom`, `prenom`, `age`, `tel`, `adresse`, `mdp`, `service`) VALUES
(1, 15, 'inf1', 'inf1', 33, 12334, 'Tunis', '123', 'Jour'),
(2, 14, 'inf2', 'inf2', 55, 78958, 'Med5', '778', 'nuit'),
(3, 5, 'ridha', 'zemzmi', 56, 20520365, 'Bardo', 'lkjhg', 'nuit'),
(4, 14, 'Louis', 'pato', 39, 77410258, 'Milano', 'milan', 'garde');

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
CREATE TABLE IF NOT EXISTS `medecin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_med` int(11) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  `age` int(11) NOT NULL,
  `tel` int(11) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `specialite` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`id`, `id_med`, `nom`, `prenom`, `age`, `tel`, `adresse`, `mdp`, `specialite`) VALUES
(1, 20, 'Mohssen', 'Med', 50, 1474, 'Sfax', '2020', 'dentiste'),
(2, 33, 'lamia', 'lii', 22, 369, 'Bizerte', '555', 'Cardio'),
(3, 88, 'fahd', 'zaghdoudi', 33, 28320921, 'Tunis', 'azerty', 'Sport'),
(4, 11, 'Louis', 'Gabriel', 63, 77410258, 'Farnce', 'louisito', 'pediatre');

-- --------------------------------------------------------

--
-- Structure de la table `mesure`
--

DROP TABLE IF EXISTS `mesure`;
CREATE TABLE IF NOT EXISTS `mesure` (
  `dateMes` date NOT NULL,
  `details` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `mesure`
--

INSERT INTO `mesure` (`dateMes`, `details`) VALUES
('2019-11-08', 'etat stable');

-- --------------------------------------------------------

--
-- Structure de la table `ordonnance`
--

DROP TABLE IF EXISTS `ordonnance`;
CREATE TABLE IF NOT EXISTS `ordonnance` (
  `medicamment` varchar(15) NOT NULL,
  `qte` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ordonnance`
--

INSERT INTO `ordonnance` (`medicamment`, `qte`) VALUES
('Analgon', 5);

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pat` int(11) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  `age` int(11) NOT NULL,
  `tel` int(11) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `assurance` varchar(20) NOT NULL,
  `etatCiv` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id`, `id_pat`, `nom`, `prenom`, `age`, `tel`, `adresse`, `mdp`, `assurance`, `etatCiv`) VALUES
(1, 10, 'Lionel', 'Messi', 32, 10, 'Espagne', 'barca', 'cnss', 'marié'),
(3, 30, 'Saber', 'Khelifa', 33, 30, 'Tunis', 'ca', 'ca', 'marié'),
(4, 4, 'Louis', 'Gabriel', 63, 1920, 'Farnce', 'louisito', 'cnam', 'divorcé'),
(5, 99, 'Farouk', 'Khoualdia', 22, 50970528, 'Bizerte', 'tennis', 'Enicarthage', 'Célibataire'),
(6, 13, 'Fahd', 'Zaghdoudi', 23, 58620921, 'Ben Arous', 'football', 'Enicarthage', 'Célibataire'),
(26, 94, 'Hedi', 'Dridi', 32, 98542630, 'Tbarka', 'qwerty', 'cnss', 'marié'),
(24, 55, 'Ben salah', 'Med', 78, 3029445, 'sousse', 'med154', 'cnss', 'marié'),
(25, 9, 'Hbib', 'Hedfi', 19, 99887452, 'Beja', 'azerty', 'cnam', 'célibataire');

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

DROP TABLE IF EXISTS `rdv`;
CREATE TABLE IF NOT EXISTS `rdv` (
  `num_rdv` int(11) NOT NULL,
  `date_rdv` date NOT NULL,
  `remarque` varchar(20) NOT NULL,
  `id_pat` int(11) NOT NULL,
  `id_med` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `rdv`
--

INSERT INTO `rdv` (`num_rdv`, `date_rdv`, `remarque`, `id_pat`, `id_med`) VALUES
(117, '2019-12-19', 'Urgent', 9, 20),
(59, '2019-12-31', '2eme seance', 10, 33),
(107, '2020-02-06', '1ere fois', 88, 13),
(108, '2020-05-08', 'etat stable', 7, 9),
(33, '2019-12-28', 'matin 9h', 7, 107),
(99, '2020-01-21', '3eme seance', 3, 30);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

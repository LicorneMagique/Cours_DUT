<?php

//On essaye de se connecter à la base de données	
try {
    $bd = new PDO('mysql:host=' . BD_HOST . '; dbname=' . BD_DBNAME . '; charset=utf8', BD_USER, BD_PWD);
	$bd -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
}
//En cas d'échec on affiche le message d'erreur
catch(PDOException $e){
    $erreur = 'connexion';
}

//S'il n'y a pas eu de probleme de login
if (!isset($erreur) && isset($login)) {
    $requete = "SELECT * FROM utilisateur WHERE login = '" . $login . "'";
    $donnees = array($login);
	try {
	    $query = $bd -> prepare($requete);
	    $query -> execute($donnees);
	    if (!$resultats = $query -> fetch(PDO::FETCH_ASSOC)) {
	        $erreur = 'login';
	    }
    }
    catch(Exception $e) {
        $erreur = 'query';
    }
}

//Si la requette a marchée
if (isset($resultats)) {
    if ($resultats['mot'] != '') {
        $mot = $resultats['mot'];
        $nbrepet = $resultats['nbrepet'];
    }
    else {
        $erreur = 'login';
    }
}
else {
        $erreur = 'login';
    }

?>


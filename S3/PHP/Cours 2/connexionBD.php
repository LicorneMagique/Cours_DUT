<?php
const ERREUR_LOGIN = 'ERREUR DE LOGIN';
const ERREUR_RESULTAT = 'Pas de résultat'

//On défini les variables de connexion à la BD
define('BD_HOST', 'localhost');
define('BD_DBNAME', 'cours');
define('BD_USER', 'julien');
define('BD_PWD', 'coe8xt4n');

//On sécurise la variable $login
$value = isset($_POST['login']) ? htmlspecialchars($_POST['login']) : '';
if ((strlen($value) > 0) && (strlen($value) < 50)) {
	$login = (string) $_POST['login'];
}
else {
	$erreur = ERREUR_LOGIN;
}
	
//On essaye de se connecter à la base de données	
try {
    $bd = new PDO('mysql:host=' . BD_HOST . '; dbname=' . BD_DBNAME . '; charset=utf8', BD_USER, BD_PWD);
	$bd -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
}
//En cas d'échec on affiche le message d'erreur
catch(PDOException $e){
    die('Erreur de connexion à la base de données : ' . ERREUR_CONNECT_BDD . ' : ' . $e -> getMessage());
}

if (isset($login)) {
    $requete = "SELECT nombre FROM exophp WHERE nom = '" . $login . "'";
    $donnees = array($login);
	try {
	    $query = $bd -> prepare($requete);
	    $query -> execute($donnees);
	    if (!$resultats = $query -> fetch(PDO::FETCH_ASSOC)) {
	        $erreur = ERREUR_RESULTAT;
	    }
    }
    catch(Exception $e) {
        die($e -> getMessage());
    }
}
?>
<!DOCTYPE html>
<HTML>
	<HEAD>
		<meta charset ="utf-8">
		<TITLE>BD</TITLE>
	</HEAD>
	<BODY>
	
	<form method="post" action="connexionBD.php">
		<p><label for="in">Login :<input id="in" type="string" name="login" value="<?= isset($login) ? $login : ''?>"></label></p>
		<input type="hidden" name="source" value="connexionBD.php">
		<p><input type="submit" value="Valider"></p>
		
		
	</form>
		<?php
			if (isset($login)) {
				echo '<p>Login : ' . $login . '</p>';
			}
			if (isset($erreur)) {
			    echo '<p>Erreur : ' . $erreur . '</p>';
			}
			if (isset($resultats) && $resultats['nombre'] != '') {
			    echo '<p>Résultat : ' . $resultats['nombre'] . '</p>';
			}
		?>
	</BODY>
</HTML>

<?php

//On sécurise la variable $login
$value = isset($_POST['login']) ? htmlspecialchars($_POST['login']) : '';
if ((strlen($value) > 0) && (strlen($value) < 50)) {
	$login = (string) $_POST['login'];
}

//appel du modèle hello.php pour accéder à la base de données et 
require_once(PATH_MODELS.$page.'.php');

if (isset($erreur)) {
    $alert = choixAlert($erreur);
    $page = "accueil";
}

//appel de la vue
require_once(PATH_VIEWS.$page.'.php');


?>

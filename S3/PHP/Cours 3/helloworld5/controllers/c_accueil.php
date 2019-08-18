<?php
/*
 * DS PHP
 * Controller page accueil
 *
 * Copyright 2017, Eric Dufour
 * http://techfacile.fr
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT
 */

if (isset($_GET['erreur'])) {
    $erreur = htmlspecialchars($_GET['erreur']);
}

if (isset($erreur)) {
    $alert = choixAlert($erreur);
}

//appel de la vue
require_once(PATH_VIEWS.$page.'.php');
?>

<?php
/*
 * DS PHP
 * Vue page index - page d'accueil
 *
 * Copyright 2016, Eric Dufour
 * http://techfacile.fr
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT
 *
 */

if (isset($test)) echo $test;
?>

<!--  En tête de page -->
<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?php  echo TITRE_PAGE_HELLO;?></h1>

<!--  Liste  -->
<ul>
    <?
    // affichage de la boucle de messages
    for($i = 0; $i <= $user -> getNbRepet(); $i++) {
	    echo '<li>' . $user -> getMot() . ' ' . $user -> getLogin() . '</li>';
    }
    ?>
</ul>

<!--  Fin de la page -->


<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php'); ?>

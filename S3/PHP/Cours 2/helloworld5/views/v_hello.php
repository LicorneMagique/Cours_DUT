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
?>

<!--  En tête de page -->
<?php require_once(PATH_VIEWS.'header.php');?>



<!--  Début de la page -->
<h1><?php  echo TITRE_PAGE_HELLO;?></h1>

<!--  Liste  -->
<ul>
    <?
    if (!isset($erreur) && isset($nbrepet)) {
        for ($i = 0; $i < $nbrepet; $i++) {
            echo "<li>$mot $login</li>";
        }
    }
    ?>
</ul>

<!--  Fin de la page -->


<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php'); ?>

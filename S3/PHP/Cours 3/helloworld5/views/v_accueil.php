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
//  En tête de page
?>
<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php
require_once(PATH_VIEWS.'alert.php');
?>

<!--  Début de la page -->
<h1><?= TITRE_PAGE_ACCUEIL ?></h1>

<!--  Formulaire -->
<form method="post" action="<?= 'index.php?page=hello' ?>">
<p><label for="login">Login :</label><input id="login" type="string" name="login" /></p>
<p><input type="submit" value="Valider"/></p>
</form>

<!--  Fin de la page -->


<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php'); 

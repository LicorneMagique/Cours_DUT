<?php

// Textes
define('TITRE', 'Hello V4');
define('NB_HELLO', 'Nombre de Hello : ');
define('MIN_HELLO', 1);
define('MAX_HELLO', 100);
define ('SUBMIT', 'Envoyer');
define ('ERREUR_NB_HELLO','Le nombre de Hello est incorrect. Il doit être compris entre ' . MIN_HELLO . ' et ' . MAX_HELLO . '.');
define('HELLO', 'Hello World!');

// Controles
if (isset($_POST['nombreHello'])) {
    $nb = (int) $_POST['nombreHello'];
    if ($nb < MIN_HELLO || $nb > MAX_HELLO) {
        $erreur = ERREUR_NB_HELLO;
    }
}

//Affichage
?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title><?=TITRE?></title>
        <link rel="stylesheet" type="text/css" href="hello.css"/>
    </head>
    <body>
        <pre class="debug">
        <?php
        print_r($_POST);
        if (isset($nb)) {
            echo 'nb='.$nb;
        }
        ?>
        </pre>
        <form action="helloworld4.php" method="post">
            <label><?=NB_HELLO?>
                <input type="text" name="nombreHello" value="<?= isset($nb) ? $nb : '' ?>" />
            </label>
            <input type="submit" title="<?=SUBMIT?>">
        </form>
        <?php

        //Affichage des erreurs
        if (isset($erreur)) {
            echo '<p class="erreur">'.$erreur.'</p>';
        }
        elseif (isset($nb)) {
            ?>
            <ul>
            <?php 
            for ($i = 1; $i <= $nb; $i++) {
                ?>
                <li class="<?=$i%2==0 ? 'paire' : 'impaire' ?>"><?=HELLO?></li>
                <?php
                if ($i%10 == 0) {
                    echo ' <li>'.$i.'</li>';
                }
            }
            ?>
            </ul>
            <?php
        }
        ?>
    </body>
</html>

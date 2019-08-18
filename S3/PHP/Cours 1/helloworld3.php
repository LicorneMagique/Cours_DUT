<?php
// Controles
if (isset($_POST['nombreHello'])) {
    $nb = (int) $_POST['nombreHello'];
    if ($nb <= 0 || $nb > 100) {
        $erreur = 'Le nombre de Hello est incorrect. Il faut qu\'il soit dans [1;100]';
    }
}

//Affichage
?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Hello V3</title>
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
        <form action="helloworld3.php" method="post">
            <label>Nombre de Hello : 
                <input type="text" name="nombreHello" value="<?= isset($nb) ? $nb : '' ?>" />
            </label>
            <input type="submit" title="Envoyer">
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
                <li class="<?=$i%2==0 ? 'paire' : 'impaire' ?>">Hello World!</li>
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

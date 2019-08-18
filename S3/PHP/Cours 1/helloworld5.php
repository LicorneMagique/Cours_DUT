<?php

// Textes
define('TITRE', 'Hello V5');
define ('LOGIN', 'Login :');
define ('SUBMIT', 'Valider');
define ('ERREUR', 'Login invalide');

define('BD_HOST', 'localhost');
define('BD_DBNAME', 'cours');
define('BD_USER', 'root');
define('BD_PWD', 'cpe7ay5u');

// Controles
if (isset($_POST['login']) and strlen($_POST['login'] <= 50)) {
    $login = htmlspecialchars($_POST['login']);
}
else {
    $erreur = ERREUR;
}

//accès à la base
try {
    $bdd=new PDO('mysql:host='.BD_HOST.';dbname='.BD_DBNAME.';charset=utf8',BD_USER,BD_PWD);
	$bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
}
catch(Exception $erreur) {
    die('Erreur : '.$erreur->getMessage());
}

//récupération depuis la base de donnée
$requete = "SELECT mot FROM utilisateur WHERE login = 'toto';"
$test = $bdd -> prepare();
$donnee = array($test);
$test -> execute($donnee);

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
        <form action="helloworld5.php" method="post">
            <label><?=LOGIN?>
                <input type="text" name="login" value="<? echo (isset($login)) ? $login : "" ?>" />
            </label>
            <input type="submit" title="<?=SUBMIT?>">
        </form>
        <?php

        //Affichage des erreurs
        if (isset($erreur)) {
            echo '<p class="erreur">'.$erreur.'</p>';
        }
        else {
            ?>
            <ul>
            <?php
            echo $donnee; 
            echo "<li>HelloWorld!</li>";
            ?>
            </ul>
            <?php
        }
        ?>
    </body>
</html>

<?php
define ('COEF_IMPOSABLE', 0.72);
define ('MAX1', 5614);
define ('COEF1', 0);
define ('MAX2', 11198);
define ('COEF2', 0.055);
define ('MAX3', 24872);
define ('COEF3', 0.14);
define ('MAX4', 66679);
define ('COEF4', 0.3);
define ('COEF5', 0.4);

$nbEnfants = (int) $_POST['nbEnfants'];
$marie = isset($_POST['marie']) and (string) $_POST['marie'] == '1' ? true : false;
$S = (int) $_POST['salaire'];
$nbParts = $marie ? ($nbEnfants/2)+2 : ($nbEnfants/2)+1;
$R = COEF_IMPOSABLE*$S;
$QF = $R/$nbParts;
if ($QF <= MAX1) {
    $impots = $QF*COEF1;
}
elseif ($QF <= MAX2) {
    $impots = ($QF-MAX1)*COEF2;
}
elseif ($QF <= MAX3) {
    $impots = (MAX2-MAX1)*COEF2 + ($QF-MAX2)*COEF3;
}
elseif ($QF <= MAX4) {
    $impots = (MAX2-MAX1)*COEF2 + (MAX3-MAX2)*COEF3 + ($QF-MAX3)*COEF4;
}
else {
    $impots = (MAX2-MAX1)*COEF2 + (MAX3-MAX2)*COEF3 + (MAX4-MAX3)*COEF4 + ($QF-MAX4)*COEF5;
}
$impots *=$nbParts
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charsert="utf-8"/>
        <title>Impots</title>
    </head>

    <body>
        <form action="impots1.php" method="post">
            <p>Nombre d'enfants : <input type="text" name="nbEnfants" value = "<? echo ($nbEnfants == "0") ? "0" : $nbEnfants ?>"></p>
            <p>Marié : <input type="checkbox" name="marie" value="1"></p>
            <p>Salaire annuel : <input type="text" name="salaire" value="<? echo ($S == 0) ? "0" : $S ?>"></p>
            <input type="submit" value="calculer">
            <?php
            if ($S != 0) {
                echo "<p>Votre impôt prévisionnel est de : " . $impots . " €</p>";
            }
            ?>
        </form>
    </body>
    
</html>

<!DOCTYPE html>
<html>
    <head>
        <title>Page Title</title>
    </head>
    <body>
        <ul>
            <?php
            if (isset $_GET['nb'] && strlen($_GET['nb']) < 10) {
                $nb = (int) htmlspecialchars($_GET['nb']);
                if ($nb > 0 && $nb <= 100) {
                    for($i = 1; $i <= $nb; $i++) {
                        echo "<li>hello world</li>";
                    }
                }
            }
            else {
                echo "<p style=\"color : red\"><strong>Erreur</strong></p>";
            }
            ?>
        </ul>
    </body>
</html>

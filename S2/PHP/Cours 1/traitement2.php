<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Test PHP</title>
  </head>
  
  <body>
    <h1>PHP</h1>
    <?php
      echo htmlspecialchars($_POST['message']);
    ?>
  </body>
</html>

<?php

require_once(PATH_MODELS . 'UtilisateurDAO.php');
// Contrôle - Neutralisation du paramètre reçu 
if (isset($_POST['login'])) {
    $value = htmlspecialchars($_POST['login']);
    
    //Appel du modèle pour charger les données
    $userDAO = new UtilisateurDAO();
    $user = $userDAO -> getUser($value);

    //Gestion des erreurs
    if (is_null($user)) {
        if(!is_null($userDAO -> getErreur())) {
            $erreur = 'query';
            if (DEBUG) die($userDAO -> getErreur());
        }
        else $erreur = 'login';
    }
    //Redirection ou appel de la vue
    if (isset($erreur)) { // affichage des erreurs de login
        header('Location: index.php?erreur=' . $erreur);
        exit();
    }
    else { // affichage des hellos
        require_once(PATH_VIEWS.$page.'.php');  
    }
}
else {
     header('Location: index.php');
}

?>

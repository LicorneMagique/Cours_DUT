<?php
require_once(PATH_MODELS.'Connexion.php');
abstract class DAO {

    private $_erreur; //stocke les messages d'erreurs associées au PDOException
  
    public function getErreur() {
        return $this->_erreur;
    }

    private function _requete($sql, $args = null) {
        if ($args == null) {
            $pdos = Connexion::getInstance() -> getBdd() -> query($sql);// exécution directe
        }
        else {
            $pdos = Connexion::getInstance() -> getBdd() -> prepare($sql);// requête préparée
            $pdos->execute($args);
        }
        return $pdos;
    }
 
  // retourne un tableau 1D avec les données d'un seul enregistrement 
    public function queryRow($sql, $args = null) {
        try {
            $pdos = $this -> _requete($sql, $args);
            $res = $pdos -> fetch();
            $pdos -> closeCursor();
        }
        catch(PDOException $e) {
            $this -> _erreur = $e -> getMessage();
            $res = false;
        } 
        return $res;
    }

    //retourne un tableau 2D avec éventuellement plusieurs enregistrements
    public function queryAll($sql, $args = null) {
        try {
            $pdos = $this -> _requete($sql, $args);
            $res = $pdos -> fetchAll();
            $pdos -> closeCursor();
        }
        catch(PDOException $e) {
            $this->_erreur = $e->getMessage();
            $res = false;
        } 
        return $res;
    }
}

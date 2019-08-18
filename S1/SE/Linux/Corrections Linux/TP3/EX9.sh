#Exercice 9 :
#Écrire un script qui déplace l’utilisateur dans le répertoire passé en paramètre et y crée un fichier vide uniquement si ce répertoire existe et que l’utilisateur est autorisé à se déplacer dedans. Un message d’erreur devra être affiché le cas échéant.



if test -x $1
    then
        cd $1
        touch fichier
    else echo Probleme \:\(
fi

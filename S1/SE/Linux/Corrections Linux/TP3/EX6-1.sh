#Exercice 6 :
#1. Écrire un script qui affiche la liste des fichiers présents  dans un répertoire passé en paramètre en ajoutant un "a" au début du nom de tous les fichiers.



for i in `ls $1`
do
    echo a$i
done

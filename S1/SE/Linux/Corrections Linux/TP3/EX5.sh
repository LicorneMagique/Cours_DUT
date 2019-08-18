#Exercice 5 :
#Écrire un script qui crée 5 fichiers "fic1.txt" à "fic5.txt" dans un répertoire passé en paramètre.



for i in 1 2 3 4 5
do
    touch $1fic$i.txt
done

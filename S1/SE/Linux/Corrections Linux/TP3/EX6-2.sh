#Exercice 6 :
#2. Ce script peut-il être réutilisé par un administrateur système qui voudrait renommer tous les fichiers d'un répertoire donné ? Si oui, expliquer comment.



#Oui :

#$1 l'adresse du repertoire (ex. "~/Dossier/")

for i in `ls $1`
do
    mv $1$i $1a$i
done

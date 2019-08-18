#Exercice 11 :
#Écrire un programme permettant de changer facilement l’extension d’une série de fichiers.
#Exemple : "renomme htm html ~/mydir" renomme tous les fichiers ".htm" du répertoire "mydir" en ".html".


#Version de  M. Samba :

#for nom in `ls $3/*.$1`
#do
#    nom_sans_ext=`basename $nom  .$1`
#    mv $nom $nom_sans_ext.$2
#done


#Ma version :

#$1 est l'extension a modifier (ex. "txxt")
#$2 est l'extension que vous voulez mettre (ex. "txt")
#$3 est le repertoire a entrer (par defaut "./")

for i in `ls $3*$1`
do
    mv $i `basename $i $1`$2
done

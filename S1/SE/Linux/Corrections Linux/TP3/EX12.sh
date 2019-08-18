#Exercice 12 :
#Écrire un script qui affiche un menu donnant le choix entre 3 commandes :
#1. Affichage de la date 
#2. Addition de deux nombres
#3. Quitter


#Version de M.Samba :

choix=0
while test $choix !=3
do
    echo "1 - Date "
    echo "2 - Addition"
    echo "3 - Quitter"
    read choix
    case $choix in
        1) date ;;
        2) echo "saisir deux nombres entiers"; read a b; expr $a + $b ;;
        3) echo Fin;;
        *) echo "Nombre entre 1 et 3";;
    esac
done

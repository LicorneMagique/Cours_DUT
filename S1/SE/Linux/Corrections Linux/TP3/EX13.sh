#Exercice 13 :
#1. Écrire un script "trash" qui déplace dans un répertoire "poubelle" les fichiers dont les noms sont passés en paramètres.
#2. Ajouter une option "-c" à la commande permettant de connaître la taille de la poubelle (indice : utiliser la commande du). 
#3. Ajouter une option "-e" permettant de vider la poubelle 
#4. Ajouter une option "-h" permettant d’afficher l’utilisation de la commande


#Version de M. Samba

vide_poubelle()
{
    rm poubelle/*
}

display_aide()
{
    echo "envoie la liste des fichiers passes en arguments dans le repertoire ./poubelle"
    echo "-c donne la taille de la poubelle"
    echo "-e vide la poubelle"
    echo "-h affiche cette aide"
    exit
}

case $1 in
    "-c") du poubelle;exit ;;
    "-e") vide_poubelle ;;
    "-h") display_aide ;;
esac
if !(test -d poubelle)
    then mkdir poubelle
fi
for nom_fichier
do
    if test -f $nom_fichier 
        then mv $nom_fichier poubelle
        else echo "$nom_fichier inexistant"
    fi
done

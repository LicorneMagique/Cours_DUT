#Exercice 1 :
#Créer un script qui effectue à la suite les opérations suivantes :
#1. crée un répertoire "Essai_Script"
#2. crée un fichier vide "toto.txt" dans ce répertoire"
#3. crée une copie de "toto" nommée "toto2", toujours dans ce répertoire
#4. stocke une liste des fichiers de votre répertoire d’accueil, toujours dans "Essai_Script"
#5. affiche le texte "voila, c'est fait !"



mkdir ~/Essai_Script
touch ~/Essai_Script/toto.txt
cp ~/Essai_Script/toto.txt ~/Essai_Script/toto2.txt
ls ~/ > ~/Essai_Script/liste_repertoire_accueil.txt
echo "Voilà, c'est  fait !"

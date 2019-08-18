#Exercice 8 :
#Écrire un script qui traduit en anglais un chiffre passé en paramètre. Les chiffres sont compris entre 0 et 5. Le script répondra "inconnu" en cas d’erreur.



case $1 in
    0) echo zero;;
    1) echo one;;
    2) echo two;;
    3) echo three;;
    4) echo four;;
    5) echo five;;
    *) echo inconnu;;
esac

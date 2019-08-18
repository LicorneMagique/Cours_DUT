#Exercice 7 :
#En utilisant le fichier "annuaire.txt" du TP précédent, écrire un script "existcopain" permettant de déterminer si le nom passé en paramètre à la commande correspond à une personne de l'annuaire.


#Version de M. Samba (beaucoup plus belle que ma version) :
if (grep -q $1 annuaire.txt)
    then echo “utilisateur trouvé !”
    else echo “utilisateur non trouvé...”
fi



#Ma version :
resultat=0
for i in `cut -d : -f 1 annuaire.txt`
do
    if test $1 = $i
        then echo "Votre bon copain est dans l'annuaire."
        resultat=1
    fi
done

if test $resultat = 0
    then echo "Votre bon copain n'est malheureusement pas dans l'annuaire."
fi

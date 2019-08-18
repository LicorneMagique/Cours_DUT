#Exercice 14 :
#Écrire une commande shell avec 3 arguments. Elle indiquera si les 3 chaînes sont identiques ou non par le code de retour suivant : 
#1. 0 si les 3 chaînes sont égales 
#2. 1, 2 ou 3 si la chaîne différente des autres est à la (1/2/3)ième position
#3. 4 si les trois chaînes sont différentes
#4. 5 si le nombre de paramètres est incorrect


#Version de M. Samba

if (test $# -eq 3)
    then
        if (test $1 = $2)
            then
                if (test $1 = $3)
                    then exit 0
                    else exit 3
                fi
        fi
        if (test $3 = $2)
            then
                exit 1
        fi
        if (test $1 = $3)
            then
                exit 2
        fi
        exit 4
    else 
        echo 
            "nombre d arguments incorrects"
fi
exit 5

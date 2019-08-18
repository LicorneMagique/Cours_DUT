#Exercice 10 :
#Écrire un script shell qui affiche le nom de tous les fichiers du répertoire "/usr/include" dont le nom se termine par ".h" et ayant plus de 100 lignes.


#Version de M. Samba:

#for nom in `ls /usr/include/*h`
#do
#    nb=`wc -l $nom | cut –f1 –d" "`
#    if (test $nb -gt 100)
#        then echo $nom
#    fi
#done


#Ma version :

cd /usr/include
for i in `ls *.h`
do
    if test `wc $i -l | cut -d " " -f 1` -gt 100
        then echo $i
    fi
done

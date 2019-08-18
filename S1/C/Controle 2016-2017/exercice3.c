#include<stdio.h>
#include<stdlib.h>

void afficher(int tab[], int taille)
/*
:entrée tab : tableau d'int
:entrée taille : int
:pré-condition : tab contient taille éléments
:postcondition : affiche à l'écran les éléments de tab
*/
{
     int i;
     for(i=0;i<taille;i++) printf("%d ",tab[i]);
     printf("\n");
}

void remplir(int tab[], int taille)
/*
:entrée/sortie tab : tableau d'int
:entrée taille : int
:pré-condition : tab contient taille éléments
:postcondition : remplit tab avec des valeurs générées aléatoirement comprises entre 0 et 20
*/
{
     int i;
     for(i=0;i<taille;i++) tab[i]= rand() % 21;
}


int entier_premier(int val)
/*
:entrée val : int
:pré-condition : val > 0
:postcondition : retourne 1 si val est un entier premier, 0 sinon
*/
{
     int i;
     
     if(val <= 1) return 0;
     
     for(i=2;i<val;i++)
       {
         if(val % i == 0)
         	return 0;
       }
      return 1;
}


int nb_premiers(int tab[], int taille)
/*
:entrée tab : tableau d'int
:entrée taille : int
:pré-condition : tab contient taille éléments
:postcondition : retourne le nombre d'entiers premiers dans tab
*/
{
     int i, nb=0;
     for(i=0;i<taille;i++)
       {
         if(tab[i] > 1 && entier_premier(tab[i]) == 1)
         	nb++;
       }
    return nb;
}




int main()
{
    int tableau[20];
    remplir(tableau, 20);
    afficher(tableau, 20);

    printf("Nombre d'entiers premiers dans le tableau : %d\n", nb_premiers(tableau, 20));

    return 0;
}

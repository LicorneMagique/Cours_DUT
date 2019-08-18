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
:postcondition : remplit tab avec des valeurs générées aléatoirement comprises entre 0 et 99
*/
{
     int i;
     for(i=0;i<taille;i++) tab[i]= rand() % 100;
}


int tri_croissant_ind(int tab[], int taille, int ind)
/*
:entrée tab : tableau d'int
:entrée taille : int
:entrée ind : int
:pré-condition : tab contient taille éléments et 0 <= ind < taille
:postcondition : retourne 1 si tab est trié à partir de ind, 0 sinon
*/
{
     int i;
     for(i=ind;i<taille-1;i++)
       {
         if(tab[i] > tab[i+1])
         	return 0;
       }
      return 1;
}


int plus_petit_ind_tri_croissant(int tab[], int taille)
/*
:entrée tab : tableau d'int
:entrée taille : int
:pré-condition : tab contient taille éléments
:postcondition : retourne le plus petit indice à partir duquel tab est trié
*/
{
     int i;
     for(i=0;i<taille-1;i++)
       {
         if(tri_croissant_ind(tab, taille, i) == 1)
         	return i;
       }
    return taille - 1;
}




int main()
{
    int tableau[20];
    remplir(tableau, 20);
    afficher(tableau, 20);

    printf("Plus petit indice à partir duquel le tableau est trié : %d\n", plus_petit_ind_tri_croissant(tableau, 20));

    return 0;
}

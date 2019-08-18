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
:postcondition : remplit tab avec des valeurs générées aléatoirement comprises entre 0 et 60
*/
{
     int i;
     for(i=0;i<taille;i++) tab[i]= 10 + rand()%41; /*tab[i]=rand()%61; */
}


int nb_10_50(int tab[], int taille)
/*
:entrée tab : tableau d'int
:entrée taille : int
:pré-condition : tab contient taille éléments
:postcondition : retourne le nombre de valeurs comprises entre 10 et 50 de tab
*/
{
     int i, nb=0;
     for(i=0;i<taille;i++)
       {
         if(tab[i] >= 10 && tab[i] <= 50)
         	nb++;
       }
      return nb;
}


int indice_min(int tab[], int taille)
/*
:entrée tab : tableau d'int
:entrée taille : int
:pré-condition : tab contient taille éléments; les éléments de tab sont compris entre 10 et 50
:postcondition : retourne l'indice de la dernière occurrence de la plus petite valeur de tab
*/
{
     int i, min=0;
     for(i=1;i<taille;i++)
       {
         if(tab[i] <= tab[min])
         	min = i;
       }
      return min;
}




int main()
{
    int tableau[10], min;
    remplir(tableau, 10);
    afficher(tableau, 10);

    if(nb_10_50(tableau, 10) == 10)
      {
    	min = indice_min(tableau, 10);
    	printf("indice de la dernière occurrence de la plus petite valeur %d est : %d\n", tableau[min], min);
      }
    else
      {
        printf("Il existe des valeurs en dehors de l'intervalle [10,50]");
      }

    return 0;
}

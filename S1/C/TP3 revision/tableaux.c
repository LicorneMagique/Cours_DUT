#include<stdio.h>
#include<stdlib.h>

void afficher(int lg, int tab[lg])
{
    int i;
    for(i=0; i<lg; i++) printf("%d ", tab[i]);
    printf("\n");
}

void remplir(int lg, int tab[lg])
{
    int i;
    for(i=0; i<lg; i++) tab[i]=rand()%100;
}

void trier(int lg, int tab[lg])
{
    int i, temp, boucle, pmin;

    for(boucle=0; boucle<lg-1; boucle++)
    {
        for(i=boucle; i<lg; i++)
        {
            if (i==boucle) pmin=boucle;
            else
            {
                if (tab[i]<tab[pmin]) pmin=i;
            }
        }
        temp=tab[boucle];
        tab[boucle]=tab[pmin];
        tab[pmin]=temp;

    }
    printf("Le trie s'est termine apres %d lectures de cases\n", lg*(lg+1)/2);

}

void trier_easy(int lg, int tab[lg])
{
    int i, temp, boucle, nb;

    for(boucle=0; boucle<lg; boucle++)
    {
        nb=1;
        for(i=0; i<lg-1; i++)
        {
            if (tab[i]>tab[i+1])
            {
                temp=tab[i];
                tab[i]=tab[i+1];
                tab[i+1]=temp;
            }
            else nb++;
        }
        if (nb==lg)
        {
            afficher(lg, tab);
            printf("Le trie s'est termine apres %d lectures de cases\n", boucle*(lg-1));
            boucle=lg;
        }
    }
}

int main()
{
    int taille=200;
    int tableau[taille];
    remplir(taille, tableau);
    afficher(taille, tableau);
    trier_easy(taille, tableau);
}

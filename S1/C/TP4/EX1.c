#include<stdio.h>
#include<stdlib.h>
#include<time.h>

void remplir(int x, int y, int tab1[x][y]) // 1.1
{
    int i, j;
    for (i=0; i<x; i++)
    {
        for (j=0; j<y; j++) tab1[i][j]=rand()%10;
    }
}

void afficher(int x, int y, int tab1[x][y]) // 1.2
{
    int i, j;
    for (i=0; i<x; i++)
    {
        for (j=0; j<y; j++) printf("%d ", tab1[i][j]);
        printf("\n");
    }
    printf("\n");
}

void deuxMin(int x, int y, int tab1[x][y]) // 1.3
{
    int min1, min2;
    trier_ligne(x, y, tab1);
    trier_colone(x, y, tab1);
    min1=tab1[0][0];
    if (tab1[0][1]<=tab1[1][0]) min2=tab1[0][1];
    else min2=tab1[1][0];
    printf("Les deux premiers minimums sont %d et %d.\n", min1, min2);
}

void trier_colone(int x, int y, int tab1[x][y]) // 1.4
{
    int i, j, temp, boucle;
    for(boucle=0; boucle<x; boucle++)
    {
        for(j=0; j<y; j++)
        {
            for(i=0; i<x-1; i++)
            {
                if (tab1[i][j]>tab1[i+1][j])
                {
                    temp=tab1[i][j];
                    tab1[i][j]=tab1[i+1][j];
                    tab1[i+1][j]=temp;
                }
            }
        }
    }
}

void trier_ligne(int x, int y, int tab1[x][y]) //1.4
{
    int i, j, temp, boucle;
    for(boucle=0; boucle<x; boucle++)
    {
        for(i=0; i<y; i++)
        {
            for(j=0; j<x-1; j++)
            {
                if (tab1[i][j]>tab1[i][j+1])
                {
                    temp=tab1[i][j];
                    tab1[i][j]=tab1[i][j+1];
                    tab1[i][j+1]=temp;
                }
            }
        }
    }
}


int main()
{
    int taille1=5, taille2=5;
    int tab1[taille1][taille2];
    remplir(taille1, taille2, tab1);
    afficher(taille1, taille2, tab1);
    trier_ligne(taille1, taille2, tab1);
    deuxMin(taille1, taille2, tab1);
    afficher(taille1, taille2, tab1);
    trier_colone(taille1, taille2, tab1);
    afficher(taille1, taille2, tab1);


    return 0;
}


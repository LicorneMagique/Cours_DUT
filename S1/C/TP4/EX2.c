#include<stdio.h>
#include<stdlib.h>
#include<time.h>

void afficher(int x, int y, char tab1[x][y]) // 1.2
{
    int i, j;
    for (i=0; i<x; i++)
    {
        for (j=0; j<y; j++) printf("%c ", tab1[i][j]);
        printf("\n");
    }
    printf("\n");
}

int main()
{
    int taille1=3;
    char tab1[taille1][taille1];

    afficher(taille1, taille1, tab1);


    return 0;
}

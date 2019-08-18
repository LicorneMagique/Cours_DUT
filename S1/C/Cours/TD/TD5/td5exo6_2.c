#include<stdio.h>
#include<stdlib.h>
#include<time.h>

void remplir(int tab[], int taille)
{
     int i;
     printf("remplir : sizeof(tab) = %d\n",sizeof(tab));
     for(i=0;i<taille;i++) tab[i]=rand()%109-9;
}

void remplir2(int *p, int taille)
{
     int i;
     printf("remplir2 : sizeof(p) = %d\n",sizeof(p));
     for(i=0;i<taille;i++) p[i]=rand()%109-9;
}

void afficher(int tab[], int taille)
{
     int i;
     for(i=0;i<taille;i++) printf("%d ",tab[i]);
     printf("\n");
}

void afficher2(int *p, int taille)
{
     int i;
     for(i=0;i<taille;i++) printf("%d ",p[i]);
     printf("\n");
}


int main()
{
 int tablo[10], *pt;
 srand(time(NULL));
 pt=tablo;
 printf("taille tablo = %d\ntaille pt = %d\n", sizeof(tablo), sizeof(pt));
 remplir(tablo,10);
 afficher(tablo, 10);
 remplir2(tablo,10);
 afficher2(tablo, 10);
 remplir2(pt,10);
 afficher2(pt, 10);
 //system("pause");
 return 0;   
}

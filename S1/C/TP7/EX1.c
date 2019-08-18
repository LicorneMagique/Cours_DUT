#include<stdio.h>
#include<stdlib.h>

void remplir(int tab[], int n)
{
	int i;
	for(i=0; i<n; i++) tab[i]=rand()%100;
}

void afficher(int tab[], int n)
{
	int i;
	for(i=0; i<n; i++) printf("%d ", tab[i]);
}

int main()
{
	int n, *tab = NULL;
	printf("Donner la taille du tableau\n");
	scanf("%d", &n);
	tab = calloc(n,sizeof(int));
	remplir(tab, n);
	printf("Le contenu du tableau est : " );
	afficher(tab, n);
	printf("et l'adresse du tableau est : %p.\n", &tab);
	return 0;
}
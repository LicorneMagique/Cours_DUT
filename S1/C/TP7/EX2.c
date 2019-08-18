#include<stdio.h>
#include<stdlib.h>

void remplir(int tab[], int n, int rang)
{
	int i;
	for(i=rang; i<n; i++) tab[i]=rand()%100;
}

void afficher(int tab[], int n)
{
	int i;
	for(i=0; i<n; i++) printf("%d ", tab[i]);
	printf("\n");
}

int main()
{
	int n1=10, n2=10, n3=10,
		*Tablo1 = NULL, *Tablo2 = NULL, *Tablo3 = NULL;
	Tablo1 = calloc(n1, sizeof(int));
	Tablo2 = calloc(n2, sizeof(int));
	Tablo3 = calloc(n3, sizeof(int));
	if(Tablo1 == NULL || Tablo2 == NULL || Tablo3 == NULL) {
		printf("Not enough memory!");
		exit(1);
	}
	remplir(Tablo1, n1, 0);
	remplir(Tablo2, n2, 0);
	remplir(Tablo3, n3, 0);
	printf("Le contenu de Tablo1 est : " );
	afficher(Tablo1, n1);
	printf("Son adresse est : %p.\n", &Tablo1);
	printf("Le contenu de Tablo2 est : " );
	afficher(Tablo2, n2);
	printf("Son adresse est : %p.\n", &Tablo2);
	printf("Le contenu de Tablo3 est : " );
	afficher(Tablo3, n3);
	printf("Son adresse est : %p.\n", &Tablo3);
	printf("Changement de la taille de Tablo2\n");
	n2=20;
	{
		int *new_Tablo2 = realloc(Tablo2, n2*sizeof(int));
		if(new_Tablo2) Tablo2 = new_Tablo2;
		else {
			free(Tablo2);
			printf("Not enough memory!");
			exit(1);
		}
	}
	remplir(Tablo2, n2, 10);
	printf("Le contenu de Tablo2 est : ");
	afficher(Tablo2, n2);
	printf("Son adresse est : %p.\n", &Tablo2);
	return 0;
}
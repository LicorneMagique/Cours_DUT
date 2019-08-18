#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int taille_tab=20;


void remplir_tableau(int tab[], int taille)
{
	int i;
	for(i=0;i<taille;i++) tab[i]=rand()%100;
}


void afficher_tab(int tab[], int taille)
{
	int i;
	for (i=0; i<taille; i++) printf("%d ", tab[i]);
	printf("\n");
}

void afficher_tab_a_l_envers(int tab[], int taille)
{
	int i;
	for (i=0; i<taille; i++) printf("%d ", tab[taille-i-1]);
	printf("\n");
}

void retourne_tab(int tab[], int taille)
{
	int i, temp;
	for(i=0;i<taille/2;i++)
	{
		temp=tab[i];
		tab[i]=tab[taille-i-1];
		tab[taille-i-1]=temp;
	}
}

int max(int tab[], int taille)
{
	int maxi=0, i=0;
	for(i=0; i<taille; i++)
	{
		if (i==0) maxi=tab[i];
		if (tab[i]>maxi) maxi=tab[i];
	}
	return maxi;
}

int extremum(int tab[], int taille, int rang)
{
	int maxi=0, mini=0, i=0, extrem[2];
	for(i=0; i<taille; i++)
	{
		if (i==0)
		{
			maxi=tab[i];
			mini=tab[i];
		}
		if (tab[i]>maxi) maxi=tab[i];
		if (tab[i]<maxi) mini=tab[i];
	}
	extrem[0]=mini;
	extrem[1]=maxi;
	return extrem[rang];
}

void affiche_deux_max(int tab[], int taille)
{
	int pmax1=0, pmax2=0, i=0;
	for(i=0; i<taille; i++)
	{
		if (i==0) tab[pmax1]=tab[i];
		if (tab[i]>tab[pmax1])
		{
			pmax1=i;
		}
	}
	for(i=0; i<taille; i++)
	{
		if (i==0) tab[pmax2]=tab[i];
		if (tab[i]>tab[pmax2] && i!=pmax1)
		{
			pmax2=i;
		}
	}
	printf("Les deux plus grands nombres sont %d et %d\n", tab[pmax1], tab[pmax2]);
}

int trier_int(int tab[], int taille)
{
	int i=0, j=0, temp=0;
	for(j=0; j<taille; j++)
	{
		for(i=0; i<taille-1; i++)
		{
			if (tab[i]>tab[i+1])
			{
				temp=tab[i];
				tab[i]=tab[i+1];
				tab[i+1]=temp;
			}
		}
	}
	afficher_tab(tab, taille);
}

float trier_float(float tab[], float taille)
{
	int i=0, j=0;
	float temp=0.0;
	for(j=0; j<taille; j++)
	{
		for(i=0; i<taille-1; i++)
		{
			if (tab[i]>tab[i+1])
			{
				temp=tab[i];
				tab[i]=tab[i+1];
				tab[i+1]=temp;
			}
		}
	}
	//afficher_tab(tab, taille);
}

int main()
{
	int tableau1[taille_tab], i;
	float* tableau2[taille_tab];
	
	
	
	
	char a;
	printf("Entrer un nombre entre 1 et 8\n");
	scanf("%c\n", &a);
	printf("%c", a);
	switch(a)
	{
		case '1' :
			//Debut EX1
			printf("test\n");
			remplir_tableau(tableau1, taille_tab);
			afficher_tab(tableau1, taille_tab);
			break;
			//Fin EX1

		case '2' :
			//Debut EX2
			//afficher_tab(tableau1, taille_tab);
			//afficher_tab_a_l_envers(tableau1, taille_tab);
			break;
			//Fin  EX2

		case '3' :
			//Debut EX3
			//retourne_tab(tableau1, taille_tab);
			//afficher_tab(tableau1, taille_tab);
			break;
			//Fin EX3

		case '4' :
			//Debut EX4
			//printf("La valeur max est %d.\n", max(tableau1, taille_tab));
			break;
			//Fin EX4

		case '5' :
			//Debut EX5
			//printf("La valeur max est %d et la valeur minumum est %d.\n", extremum(tableau1, taille_tab, 1), extremum(tableau1, taille_tab, 0));
			break;
			//Fin EX5

		case '6' :
			//Debut EX6
			//affiche_deux_max(tableau1, taille_tab);
			break;
			//Fin EX6

		case '7' :
			//Debut EX7
			//trier_int(tableau1, taille_tab);
			break;
			//Fin EX7

		case '8' :
			//Debut EX8
			//trier_float(tableau2, taille_tab);
			break;
			//Fin EX8
	
		case '9' :
			//terminer
			break;
	}
	
	return 0;
}

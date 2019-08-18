#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>
#include<unistd.h>
#include"ligne_commande.h"

int estCommandeInterne(char*);
void commandeInterne(char** ligne);
void cd(char* dir);
void export(char* var);

int main(int argc,char * args[])
{
	char** ligne;
	int fourchette,retourwait;
	for(;;)
	{
		printf("monPrompt$");
		fflush(stdout); //vide la sortie standard
		
		ligne = lis_ligne(); //lis la saisie de l'utilisateur sur l'entrée standard
		if(fin_de_fichier(ligne)) 
		{
			return 0;
		}
		
		if(!ligne_vide(ligne))
		{
			if(!estCommandeInterne(ligne[0]))  //test si la commande est interne ou pas
			{
				fourchette = fork();  //creation d'un fils pour executer la commande externe
				if(fourchette==0)
				{
				
					if(execvp(ligne[0],ligne) == -1)
					{
						perror("Erreur\n");
					}
				}
				
				if(fourchette>0)
				{
					wait(&retourwait);
				}
			}
			else
			{
				commandeInterne(ligne); //execute la commande interne
			}
		}
	}
	
	return 0;
}

int estCommandeInterne(char * chaine)
{
	return
	(
	(strcmp(chaine,"exit") == 0)
	||
	(strcmp(chaine,"cd") == 0)
	||
	(strcmp(chaine,"export") == 0)
	);
}
void commandeInterne(char** ligne)
{
				if(strcmp(ligne[0],"cd") == 0)  //test si la commande interne est cd
				{
					cd(ligne[1]);
					return;
				}
				
				if(strcmp(ligne[0],"export") == 0)
				{
					export(ligne[1]);
					return;
				}
				
				if(strcmp(ligne[0],"exit") == 0)
				{
					exit(0);
				}
}

void cd(char* dir)
{
	if(chdir(dir) == - 1)
	{
		perror("Erreur chdir");
	}
}
void export(char* var)
{
	char * val = separe_egal(var); //séparation du parametre en deux variables
	if(setenv(var,val,1) == -1) 	
	{
		perror("Erreur setenv\n");
	}
}


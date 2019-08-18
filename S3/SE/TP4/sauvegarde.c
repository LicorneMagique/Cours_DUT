#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include "ligne_commande.h"

int isCommandeInterne(char**);
void cd(char*);
void export(char*);
char** update(char**);
void copy(char* src, char* dest);


int main(int argc, char* argv[]) {

    int retourFils;

    do {
        printf("____$");
        fflush(stdout);
        
        // Récupération de l'entrée utilisateur
        char** l = lis_ligne();
        int i;
        
        // Affichage de l'entrée de l'utilisateur
        for (i = 0; l && l[i]; i++) {
            printf("<%s>\n", l[i]);
        }
        
        // Si ctrl+d → on quitte le programme
        if (fin_de_fichier(l) == 1) break;
        
        // Si l'entrée utilisateur est vide, ça reboucle tout seul
            
        // Si l'entrée utilisateur n'est pas vide
        printf("Cooucou 1");
        if (ligne_vide(l) == 0) {
            printf("Cooucou 2");
        
            // S'il s'agit d'une commande interne
            if (isCommandeInterne(l)) { // Exécution de la commande en interne
            }
            // S'il s'agit d'une commande externe
            else {
                // Exécution de la commande par le fils créé
                int retourFork = fork();
                switch (retourFork) {
                    case 0: // Traitement du fils
                        if ((execvp(l[0], l)) == -1) { // Traitement de l'erreur de execvp
					        perror("Erreur traitement fils");
					        exit(1);
				        }
			        
			        case -1: // Traitement de l'erreur du fork
				        perror("Erreur fork\n");
				        exit(1);
                    
                    default: // Traitement du père
                        // Il faut prendre en compte le "&" --> waitpid(..., WNOHANS)
                        if ((wait(&retourFils)) == -1) { // Traitement de l'erreur du wait si pas de fils
					        perror("Erreur fils");
					        exit(1);
				        }
                    
                } // Fin switch
                
            } // Fin du else
            
        } // Fin if ligne_vide
        
    } // Fin do
    while (1);
    
    printf("\n");
    return 0;
}

int isCommandeInterne(char** commande) {
    printf("Cooucou");
    if (strcmp(commande[0], "cd") == 0) {
	    cd(commande[1]);
	    return 1;
    }
    else if(strcmp(commande[0], "exit") == 0) {
	    exit(0);
	    return 1;
    }
    else if(strcmp(commande[0],"export") == 0) {
	    export(commande[1]);
	    return 1;
    }
    else if (sizeof(commande) > 2) {
        for (int i = sizeof(commande); i > 0; i--) {
            if (strcmp(commande[i], ">")) {
                int fd;
                int retourFils;
                switch (fork()) { /*
                    case 0: // Traitement du fils
                        fd = open(commande[i + 1], O_WRONLY | O_CREAT, 777);
                        if (dup2(fd, 1) < 0) {
                            perror("Erreur dup2 avec >");
                            exit(1);
                        }
                        char ** newCommande = update(commande);
                        if ((execvp(newCommande[0], newCommande)) == -1) { // Traitement de l'erreur de execvp
					        perror("Erreur traitement fils");
					        exit(1);
				        }
			        
			        case -1: // Traitement de l'erreur du fork
				        perror("Erreur fork\n");
				        exit(1);
                    
                    default: // Traitement du père
                        // Il faut prendre en compte le "&" --> waitpid(..., WNOHANS)
                        if ((wait(&retourFils)) == -1) { // Traitement de l'erreur du wait si pas de fils
					        perror("Erreur fils");
					        exit(1);
				        }
                return 1;*/
                } // Fin switch
            } // Fin if
            else if (strcmp(commande[i], ">>")) {
                return 1;
            }
            else if (strcmp(commande[i], "2>")) {
                return 1;
            }
            else if (strcmp(commande[i], "2>>")) {
                return 1;
            }
            else if (strcmp(commande[i], "<")) {
                return 1;
            }
        }
    }
    printf("Cooucou");
    return 0;
}

void cd(char* adresse) {
    if (chdir(adresse) == - 1) {
        perror("Erreur d'adresse");
    }
}

void export(char* nomVariable) {
    char* val = separe_egal(nomVariable); // Séparation du paramètre
    if (setenv(nomVariable, val, 1) == -1) {
        perror("Erreur export\n");
    }
}

char** update(char** ancienneCommande) {
    char** nouvelleCommande;
    for (int i = 0; i < sizeof(ancienneCommande) - 2; i++) {
        copy(ancienneCommande[i], nouvelleCommande[i]);
    }
}

void copy(char* src, char* dest) {
    for(int i = 0; i < strlen(src); i++) {
        dest[i] = src[i];
    }
}

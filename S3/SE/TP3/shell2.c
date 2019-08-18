#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include "ligne_commande.h"

void cd(char* adresse);
void export(char* nomVariable);

int main(int argc, char* argv[]) {

    int retourFils;
    int isCommandeInterne(char*);
    void executeCommandeInterne(char**);

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
        if (ligne_vide(l) == 0) {
        
            // S'il s'agit d'une commande interne
            if (isCommandeInterne(l[0])) {
                // Exécution de la commande en interne
                executeCommandeInterne(l);
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

int isCommandeInterne(char* commande) {
    if ((strcmp(commande, "cd")) == 0 || (strcmp(commande, "exit")) == 0 || (strcmp(commande, "export")) == 0) {
        return 1;
    }
    return 0;
}

void executeCommandeInterne(char** commande) {
    if (strcmp(commande[0], "cd") == 0) {
	    cd(commande[1]);
    }
    else if(strcmp(commande[0], "exit") == 0) {
	    exit(0);
    }
    else if(strcmp(commande[0],"export") == 0) {
	    export(commande[1]);
    }
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


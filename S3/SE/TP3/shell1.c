#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include "ligne_commande.h"

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
        
        //printf("c'est tout %d %d\n", fin_de_fichier(l), l && ligne_vide(l));
        
        // Si ctrl+d → on quitte le programme
        if (fin_de_fichier(l) == 1) break;
        
        // Si l'entrée utilisateur est vide, ça reboucle tout seul
        
        // Si l'entrée utilisateur n'est pas vide, exécution de la commande par le fils créé
        if (ligne_vide(l) == 0) {
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
            
        } // Fin if ligne_vide
        
    } // Fin do
    while (1);
    
    printf("\n");
    return 0;
}

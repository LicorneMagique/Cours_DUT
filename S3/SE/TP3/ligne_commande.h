#ifndef _LIGNE_COMMANDE_V2_H
#define _LIGNE_COMMANDE_V2_H

/**
 * Cette fonction lit sur l'entrée standard une ligne de texte,
 * la découpe selon les espaces, et retourne un tableau de char*
 * du type attendu par execv et execvp.
 *
 * Si la fin de fichier est rencontrée, cette fonction retourne NULL.
 *
 * Voir aussi les fonctions fin_de_fichier et ligne_vide.
 */
char** lis_ligne();

/**
 * Cette fonction prend en paramètre le tableau de char* retourné par lis_ligne
 * et retourne vrai si et seulement si lis_ligne a rencontré la fin de fichier.
 * (c.à.d. si ligne est NULL)
 */
int fin_de_fichier(char** ligne);

/**
 * Cette fonction prend en paramètre le tableau de char* retourné par lis_ligne
 * et retourne vrai si la ligne lue était vide.
 * Pré-condition: on n'est pas en fin de fichier, ligne != NULL
 */
int ligne_vide(char** ligne);

/**
 * Cette procédure coupe une chaîne de caractères en deux à l'endroit du signe
 * égal, de sorte qu'après son exécutuion:
 *  - la chaîne passée en paramètre ne contient plus que sa partie gauche,
 *  - le pointeur retourné pointe vers la partie droite.
 *
 * Si la chaîne passée en paramètre ne contient pas le signe égal, la chaîne
 * n'est pas modifiée, et la fonction retourne NULL.
 */
char* separe_egal(char* str);

#endif


/**
 * Pour la documentation, voir ligne_commande_v2.h .
 */

#include "ligne_commande.h"

#include <stdio.h>
#include <string.h>
#include <unistd.h>

#define LBUF 1024
#define LLIGNE 256
static char buf[LBUF];
static char* ligne[LLIGNE];

char** lis_ligne()
{
    int i = 0;
    int s;
    do
    {
        s = read(0, buf+i, 1);
        i += s;
    } while (i < LBUF-1  &&  s > 0  &&  buf[i-1] != '\n');
    if (s < 0) perror("erreur de lecture dans lis_ligne");
    if (i == 0) return NULL;

    // découpage
    char* tok;
    buf[i] = '\0';
    i = 0;
    ligne[0] = strtok_r(buf, " \t\n\r", &tok);
    while (ligne[i] && i < LLIGNE-1)
    {
        i += 1;
        ligne[i] = strtok_r(NULL, " \t\n\r", &tok);
    }
    if (i == LLIGNE-2) ligne[LLIGNE-1] = NULL;
    return ligne;
}

int fin_de_fichier(char** ligne)
{
    return ligne == NULL;
}

int ligne_vide(char** ligne)
{
    return ligne[0] == NULL;
}

char* separe_egal(char* str)
{
  char* p = str;
  while (*p) {
    if (*p == '=') {
      *p = '\0';
      return p+1;
    }
    p++;
  }
  return NULL;
}

/* fonction de test */ /*
int main (int argc, char** argv)
{
    char** l = lis_ligne();
    int i;
    for(i = 0; l && l[i]; i++) {
        printf("<%s>\n", l[i]);
    }
    printf("c'est tout %d %d\n", fin_de_fichier(l), l && ligne_vide(l));
    // TODO teste aussi separe_egal
    return 0;
}
*/


#include<stdio.h>

void retirer_chariot(char *chaine)
{
 int i=0;
 while(chaine[i]!='\n') i++;
 chaine[i]='\0';
}

void affiche_rec(char *chaine, int i)
{
 if(chaine[i]!='\0')
  {
    affiche_rec(chaine,i+1);
    printf("%c",chaine[i]);
  }
}

void affiche_envers(char *chaine)
{
 affiche_rec(chaine,0);
}




int main()
{
    char chaine1[100];
    printf("Saisir une chaine de caracteres : ");
    fgets(chaine1,99,stdin);
    retirer_chariot(chaine1);
    affiche_envers(chaine1);
    printf("\n");
    //system("pause");
    return 0;
}

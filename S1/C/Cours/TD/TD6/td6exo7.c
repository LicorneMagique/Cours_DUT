#include<stdio.h>

void retirer_chariot(char *chaine)
{
 int i=0;
 while(chaine[i]!='\n') i++;
 chaine[i]='\0';
}

void permuter(char *chaine, int i, int j)
{
 char aux=chaine[i];
 chaine[i]=chaine[j];
 chaine[j]=aux;
}



void anagrammes(char *chaine, int i)
{
 if(chaine[i]=='\0') printf("%s\n",chaine);
 else
  { 
    int j=i;
    while(chaine[j]!='\0')
       {
        permuter(chaine,i,j);
        anagrammes(chaine,i+1);
        permuter(chaine,i,j);
        j++;
       }
   }
}


int main()
{
    char chaine1[100];
    printf("Saisir une chaine de caracteres : ");
    fgets(chaine1,99,stdin);
    retirer_chariot(chaine1);
    anagrammes(chaine1,0);
    //system("pause");
    return 0;
}

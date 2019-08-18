#include<stdio.h>


int longueur(char *chaine)
{
 int i=0;
 while(chaine[i]!='\0') i++;
 return i;
}

void sapin_bas(char * chaine1)
{
  int i=0,j,k,l;
    l=longueur(chaine1)-1;
    j=l;
    while(i<=j)
    {
      for(k=0;k<i;k++) printf(" ");
      for(k=i;k<=j;k++) printf("%c",chaine1[k]);
      //for(k=j+1;k<l;k++) printf(" ");
      printf("\n");
      i++;
      j--;
    }   
}

void sapin_haut(char * chaine1)
{
  int i,j,k,l;
    l=longueur(chaine1)-1;
    i=l/2;
    j=i;
    while(i>=0)
    {
      for(k=0;k<i;k++) printf(" ");
      for(k=i;k<=j;k++) printf("%c",chaine1[k]);
      //for(k=j+1;k<l;k++) printf(" ");
      printf("\n");
      i--;
      j++;
    }   
}

int main()
{
    char chaine1[]="tagada tsointsoin";
    sapin_bas(chaine1);
    sapin_haut(chaine1);
    sapin_bas(chaine1);
    //system("pause");
    return 0;
}

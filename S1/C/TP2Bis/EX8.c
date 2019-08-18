#include<stdio.h>

int main()
{
    char chiffre='z';
    printf("Saisir un chiffre, # pour stopper\n");
    while (chiffre != '#')
    {
        scanf("%c", &chiffre);
        if (chiffre == '0' || chiffre == '1' || chiffre == '2' || chiffre == '3' || chiffre == '4' || chiffre == '5' || chiffre == '6' || chiffre == '7' || chiffre == '8' || chiffre == '9')
        {
            switch(chiffre)
            {
            case '0' :
                printf("ZERO\n");
                break;
            case '1' :
                printf("UN\n");
                break;
            case '2' :
                printf("DEUX\n");
                break;
            case '3' :
                printf("TROIS\n");
                break;
            case '4' :
                printf("QUATRE\n");
                break;
            case '5' :
                printf("CINQ\n");
                break;
            case '6' :
                printf("SIX\n");
                break;
            case '7' :
                printf("SEPT\n");
                break;
            case '8' :
                printf("HUIT\n");
                break;
            case '9' :
                printf("NEUF\n");
                break;
            }
        }
    }
    return 0;
}

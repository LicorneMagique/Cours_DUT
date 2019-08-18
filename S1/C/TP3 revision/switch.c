#include<stdio.h>

int main()
{
    int i;
    printf("Entrer un nombre :\n");
    scanf("%d", &i);
    switch(i)
    {
        case 1 :
        {
            printf("Vous avez entre 1\n");
            break;
        }

        case 2 :
            printf("Vous avez entre 2\n");
            break;

        default :
            printf("Vous n'avez ni 1 ni 2.\n");
    }
    return 0;
}

#include<stdio.h>
int main()
{
    char a='0';
    int nb=0;
    printf("Entrer du texte\n");
    while (a != '\n')
    {

        scanf("%c", &a);
        if (a == 'l' || a == 'L')
        {
            nb++;
        }
    }
    printf("Vous avez tape %d L", nb);
    return 0;
}

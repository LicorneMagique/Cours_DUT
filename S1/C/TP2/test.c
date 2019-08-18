#include<stdio.h>

int main ()
{
    long nb=0, i;
    for (i=0; i<1000000000; i++)
    {
        nb++;
    }

    printf("%d\n", nb);


    return 0;
}

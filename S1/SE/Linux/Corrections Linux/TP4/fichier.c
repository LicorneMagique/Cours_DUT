#include<stdio.h>
#include<unistd.h>

int main()
{
    int i=0;
    while (1==1)
    {
        i=i+100;
        sleep(1);
        printf("%d\n", i);
    }
}

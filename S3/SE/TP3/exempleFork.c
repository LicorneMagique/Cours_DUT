#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>

int main() {
    int monEntier;
    int retourFork = fork();
    printf("retourFork = %d\n", retourFork);
    if (retourFork > 0) {
        printf("Je suis ton père\n");
    }
    if (retourFork == 0) {
        printf("Papa\n");
    }
    if (retourFork < 0) {
        perror("Erreur Fork");
        exit(2);
    }
}

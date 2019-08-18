#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>

int main() {
    char maChaine[100];
    int nbOct;
    while ((nbOct = read(0, maChaine, sizeof(maChaine))) > 0) {
        if (write(1, maChaine, nbOct) != nbOct) {
            perror("Error write");
            exit(1);
        }
    }
    if (nbOct < 0) {
        perror("Error read");
        exit(1);
    }
    return 0;
}

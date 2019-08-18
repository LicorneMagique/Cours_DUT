#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char* argv[]) {
    if (argc != 3) {
        printf("Nombre d'arguments différent de 2");
        exit(1);
    }
    char maChaine[100];
    int nbOct;
    popen(argv[2], maChaine);
    printf("%s", argv[2]);
    while ((nbOct = read(0, argv[1], sizeof(argv[2]))) > 0) {
        if (write(1, argv[1], nbOct) != nbOct) {
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

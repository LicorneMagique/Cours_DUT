#include <stdio.h>
#include <string.h>
#include <unistd.h>

int main() {
    char maChaine[50] = "Hello world\n";
    if (write(1, maChaine, strlen(maChaine)) != strlen(maChaine)) {
        perror("Error write");
    }
    return 0;
}

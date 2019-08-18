#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>

int main() {
    int i, retourExit, retourFork = 1, pid;

    printf("Le shell a pour PID %d\n", getppid());
    for(i = 0; i < 3; i++) {
        retourFork = fork();
        printf("Mon PID est %d mon Pere est %d et i=%d\n", getpid(), getppid(), i);
    }

    while((pid = wait(&retourExit)) > 0) {
        printf("Code de retour du fils %d: %d\n", pid, WEXITSTATUS(retourExit));
    }
    
    sleep(20);
    exit(i);

} //fin du main

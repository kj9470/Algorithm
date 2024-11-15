#include <stdio.h>

int main() {
    int n;
    char a = 'a';
    char b = 'b';
    scanf("%d", &n);
    if (n % 2 == 0){
        for (int i = 0; i < n; i++){
            printf("%c", a);
        }
    }
    else if (n % 2 == 1){
        for (int i = 0; i < n; i++){
            if ((n / 2) == i)
                printf("%c", b);
            else
                printf("%c",a);
        }
    }
    return 0;
}

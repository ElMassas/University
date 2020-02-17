#include <stdio.h>

int mdc(a, b)
{
    if (a == b)
        return a;
    else if (b > a)
        return mdc(a, b - a);
    else 
        return mdc(a - b, b);     
}

int main()
{
    int a, b;

    scanf("%d %d", &a, &b);
    mdc(a, b);
    return 0;
    
}
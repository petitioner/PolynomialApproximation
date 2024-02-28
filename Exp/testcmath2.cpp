#include <iostream>
#include <cmath>
#include<cstdio>
#include<cmath>
#include<iostream>
#include<iomanip>
#include<functional>

//#include<conio.h>  // windows    getch()
//#include<curses.h>   // Linux

using namespace std;

const long double PI= 3.14159265358979323846264338327950288419716939937510L;
const long double E = 2.71828182845904523536028747135266249775724709369995L;


int main() {
    cout << floor(1.2)  << ceil(1.2)  << abs(-3.4)  << max(1,3)  << pow(2,4) << endl;
    cout << endl;

    double a, b, c, d, lambda = 1;

double A11 = 4;
double A12 = 4./3;
double B1 = 2*pow(E, 1) - 2*pow(E, -1);
double A21 = 4./3;
double A22 = 4./5 + 16./3*lambda;
double B2 = 2*E + 8*lambda*pow(E, -1) - 10*pow(E, -1);
a = (B1*A22 - B2*A12) / (A11*A22 - A21*A12);
c = (B2*A11 - B1*A21) / (A11*A22 - A21*A12);

A11 = 4./3 + 4*lambda;
A12 = 4./5 + 4*lambda;
B1 = 4*pow(E, -1) + 2*lambda*pow(E, 1) - 2*lambda*pow(E, -1);
A21 = 4./5 + 4*lambda;
A22 = 4./7 + 36./5*lambda;
B2 = 32*pow(E, -1) - 4*E + 6*lambda*E - 30*lambda*pow(E, -1);
b = (B1*A22 - B2*A12) / (A11*A22 - A21*A12);
d = (B2*A11 - B1*A21) / (A11*A22 - A21*A12);

cout << "p(x) = " << a << " + " << b << " *x + " << c << " *x^2 + " << d << " *x^3" << endl;
cout << endl << endl << "Octave Code: (lambda = " << lambda << ")" << endl;
cout << "y = " << a << " + " << b << " .*x + " << c << " .*x.^2 + " << d << " .*x.^3 ;" << endl;
cout << endl << endl;

/*
output: (when lambda = 1)
123.4316

p(x) = 0.991576 + 0.99636 *x + 0.550876 *x^2 + 0.178834 *x^3


Octave Code: (lambda = 1.0)
p(x) = 0.991576 + 0.99636 .*x + 0.550876 .*x.^2 + 0.178834 .*x.^3


Octave Code: (lambda = 0.5)
y = 0.991854 + 0.996411 .*x + 0.550043 .*x.^2 + 0.178768 .*x.^3 ;
*/


A11 = 4;
A12 = 4./3;
B1 = 2*pow(E, 1)  - 2*pow(E, -1);
A21 = 4./3;
A22 = 4./5 + 16./3*lambda;
B2 = 2*pow(E, 1) - 10*pow(E, -1) + 8*lambda*pow(E, -1);
a = (B1*A22 - B2*A12) / (A11*A22 - A21*A12);
c = (B2*A11 - B1*A21) / (A11*A22 - A21*A12);

b = (4*pow(E, -1) - 2*lambda*pow(E, -1) + 2*lambda*E) / (4./3 + 4*lambda);

cout << "p(x) = " << a << " + " << b << " *x + " << c << " *x^2" << endl;
cout << endl << endl << "Octave Code: (lambda = " << lambda << ")" << endl;
cout << "y = " << a << " + " << b << " .*x + " << c << " .*x.^2  ;" << endl;
cout << endl << endl;

    return 0;
}

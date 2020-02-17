gcd(0, X, X) :-!.
gcd(X, 0, X) :-!.
gcd(X, X, X) :-!.
gcd(M, N, X) :- N>M, Y is N-M, gcd(M, Y, X).
gcd(M, N, X) :- N<M, Y is M-N, gcd(Y, N, X).
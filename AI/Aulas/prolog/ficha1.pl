homem('Afonso Henriques','rei de Portugal',1109).
homem('Henrique de Borgonha','conde de Portugal',1069).

homem('Sancho I','rei de Portugal',1154).
homem('Fernando II','rei de Leão',1137).
homem('Afonso IX', 'rei de Leão e Castela', 1171).
homem('Afonso II', 'rei de Portugal',1185).

homem('Sancho II', 'rei de Portugal',1207).
homem('Afonso III', 'rei de Portugal',1210).
homem('X', 'denso', 1995).
homem('Y', 'dork', 1996).

mulher('Teresa de Castela', 'condessa de Portugal', 1080).
mulher('Mafalda', 'condessa de Saboia', 1125).
mulher('Urraca', 'infanta de Portugal',1151).
mulher('Dulce de Barcelona','infanta de Aragão',1160).
mulher('Berengária', 'infanta de Portugal',1194).
mulher('Urraca C','infanta de Castela',1186).


filho('X', 'Sancho I').
filho('Y', 'Sancho I').
filho('Afonso Henriques','Henrique de Borgonha').
filho('Afonso Henriques','Teresa de Castela').
filho('Urraca C','Afonso Henriques').
filho('Sancho I','Afonso Henriques').
filho('Urraca C','Mafalda').
filho('Sancho I','Mafalda').
filho('Afonso IX','Urraca').
filho('Afonso IX','Fernando II').
filho('Afonso II','Sancho I').
filho('Afonso II','Dulce de Barcelona').
filho('Berengária','Sancho I').
filho('Berengária','Dulce de Barcelona').
filho('Sancho II','Afonso II').
filho('Afonso III','Afonso II').
filho('Sancho II','Urraca C').
filho('Afonso III','Urraca C').

irmao(X, Y) :-
    filho(X, Z),
    filho(Y, Z),
    X \= Y.

primoDireito(X, Y) :-
    filho(X, Z),
    filho(Y, U),
    irmao(Z, U),
    X \= Y.

irmaos(X, L) :-
    findall(Z, irmao(X, Z), L).

irmaos2(X, L) :-
    bagof(Z, irmao(X, Z), L).
    
irmaos3(X, L) :-
    setof(Z, irmao(X, Z), L).       

esposa(X, Y):- 
    mulher(X, _, _),
    homem(Y, _, _),
    filho(Z, X), 
    filho(Z, Y). 
    
ascendente(X, Y):-
    filho(X, Y).

ascendente(X, Y):-
    filho(X, Z),
    ascendente(Z, Y).

descende(X, Y):-
    setof(H, ascendente(X, H), L).

descendente(X, L):-
    setof(H ,ascendente(H, X), L).

pai(X, Y):- filho(X, Y), homem(Y, _, _).
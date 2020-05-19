p('vazio',_,_).
p('rainha',_,_).
estado_inicial(Tabuleiro):-
    tamanho(N),
    cria_tabuleiro(N,Tabuleiro).
teste:-
    resolve(10).
resolve2(N):-
   retractall(tamanho(_)),
   assert(tamanho(N)),
   estado_inicial(Ei),
   resolve(Ei,1,Ef),
   print_tabuleiro([Ef],N).
resolve(N):-
   retractall(tamanho(_)),
   assert(tamanho(N)),
   estado_inicial(Ei),
   findall(Ef,resolve(Ei,1,Ef),Sorted),
   print_tabuleiro(Sorted,N),
   length(Sorted,N_solucoes),
   write(N_solucoes).
resolve(Ef,N,Ef):-heur(Ef,0),tamanho(N1), N is N1+1.
resolve(Ei,Nr_linha,Ef):-
    get_linha(Ei,Nr_linha,Linha),
    testa_linha(Ei,Linha,Lista),
    \+length(Lista,0),
    resolve_linha(Ei,Ef,Nr_linha,Lista).

resolve_linha(Ei,Ef,Nr_linha,[p('rainha',Nr_linha,Y)|T]):-
    (selectchk(p('vazio',Nr_linha,Y),Ei,p('rainha',Nr_linha,Y),Ef2),
    Proxima_linha is Nr_linha+1,
    resolve(Ef2,Proxima_linha,Ef));
    resolve_linha(Ei,Ef,Nr_linha,T).

%Recebe tabuleiro e a linha para testar e retorna a lista de pos
%com heuristica 0

testa_linha(Ei,Linha,Lista):-testa_linha(Ei,Linha,Lista,[]).
testa_linha(_,[],Lista,Lista).
testa_linha(Ei,[p('vazio',X,Y)|T1],Lista1,List2):-
    select(p('vazio',X,Y),Ei,p('rainha',X,Y),Ei2),
    heur(Ei2,0),
    append([p('rainha',X,Y)],List2,List3),
    testa_linha(Ei,T1,Lista1,List3).
testa_linha(Ei,[p('vazio',X,Y)|T1],Lista1,Lista2):-
    select(p('vazio',X,Y),Ei,p('rainha',X,Y),Ei2),
    \+heur(Ei2,0),
    testa_linha(Ei,T1,Lista1,Lista2).



heur(Tabuleiro,Heur):-
    findall(p('rainha',X,Y),member(p('rainha',X,Y),Tabuleiro),L),
    findall(X,(member(X,L),ataca(X,Tabuleiro)),Ataca),
    length(Ataca,Heur),!.
ataca(Posicao,Tabuleiro1):-
    delete(Tabuleiro1,Posicao,Tabuleiro),
    (ataca_linha(Posicao,Tabuleiro);
    ataca_coluna(Posicao,Tabuleiro);
    ataca_diagonal(Posicao,Tabuleiro)).
ataca_linha(p(_,X,_),Tabuleiro):-
    member(p('rainha',X,_),Tabuleiro).
ataca_coluna(p(_,_,Y),Tabuleiro):-
    member(p('rainha',_,Y),Tabuleiro).
ataca_diagonal(Posicao,Tabuleiro1):-
    tamanho(N2),
    %delete(Tabuleiro,Posicao,Tabuleiro1),
    (cima_direita(Posicao,Tabuleiro1,N2);
    cima_esquerda(Posicao,Tabuleiro1,N2);
    baixo_direita(Posicao,Tabuleiro1,N2);
    baixo_esquerda(Posicao,Tabuleiro1,N2)).

cima_direita(p(_,X,Y),List,N):-
    X1 is X-1,
    Y1 is Y+1,
    limite(X1,Y1,N),
    ((member(p('rainha',X1,Y1),List),!);
    cima_direita(p(_,X1,Y1),List,N)).

cima_esquerda(p(_,X,Y),List,N):-
    X1 is X-1,
    Y1 is Y-1,
    limite(X1,Y1,N),
    (member(p('rainha',X1,Y1),List);
    cima_esquerda(p(_,X1,Y1),List,N)).

baixo_direita(p(_,X,Y),List,N):-
    X1 is X+1,
    Y1 is Y+1,
    limite(X1,Y1,N),
    (member(p('rainha',X1,Y1),List);
    baixo_direita(p(_,X1,Y1),List,N)).
baixo_esquerda(p(_,X,Y),List,N):-
    X1 is X+1,
    Y1 is Y-1,
    limite(X1,Y1,N),
    (member(p('rainha',X1,Y1),List);
   baixo_esquerda(p(_,X1,Y1),List,N)).

limite(X,Y,N1):-N is N1,X=<N,X>0,Y>0,Y=<N.

cria_tabuleiro(N,Tabuleiro):-
    findall(p('vazio',X,Y),(numlist(1,N,L),member(X,L),member(Y,L)),Tabuleiro).

get_linha(Tabuleiro,N,Linha):-
    findall(p('vazio',N,Y),member(p('vazio',N,Y),Tabuleiro),Linha).

print_tabuleiro([],_).
print_tabuleiro([H|T],N):-
    %write(H),nl,
    print_tabuleiro(H,N,1),
    nl,
    print_tabuleiro(T,N).
print_tabuleiro([],_,_).
print_tabuleiro([p('rainha',_,_)|T],N,Nr1):-
    write('r'),
    (   Nr1==N->nl,Nr2 is 1;write(' '),Nr2 is Nr1+1),
    print_tabuleiro(T,N,Nr2).
print_tabuleiro([p('vazio',_,_)|T],N,Nr1):-
    write('v'),
    (   Nr1==N->nl,Nr2 is 1;write(' '),Nr2 is Nr1+1),
    print_tabuleiro(T,N,Nr2).

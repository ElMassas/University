

tabuleiro([_,_,_,_,_]).%5 colunas
estado_inicial([[' ',' ',' ','A'],[' ',' ',' ','V'],['A','V','A','A'],[' ',' ','A','V'],[' ','V','V','A']]).
i([[' ',' ',' ',' '],[' ',' ',' ',' '],[' ',' ',' ',' '],[' ',' ',' ',' '],[' ',' ',' ',' ']]).


terminal(T):-linhas(T,_).
terminal(T):-colunas(T,_).
terminal(T):-diagonal(T,_).
terminal(T):-cheio(T).

joga:-
	estado_inicial(Ei),
	%i(Ei),
	ciclo_jogada('A',Ei).

ciclo_jogada('A',Estado):-
	write(Estado),nl,
	minimax_decidir(Estado,Op1),
	write('minimax:'),write(Op1),nl,
	alfabeta(Estado,Op2),
	write('alfabeta:'),write(Op2),nl,
	write('Insira a Coluna que deseja jogar:'),
	read(X),
	jogada(Estado,'A',X,Novoestado),
	ciclo_jogada('V',Novoestado).	

ciclo_jogada('V',Estado):-
	write('Vez do computador'),nl,
	alfabeta(Estado,Op),
	jogada(Estado,'V',Op,Novoestado),
	ciclo_jogada('A',Novoestado).



joga_alfabeta :-
	estado_inicial(Ei), 
	alfabeta(Ei,Op),
	write(Op),nl.



joga_minimax:-  
	estado_inicial(Ei),
	minimax_decidir(Ei,Op),
	nl,write(Op),nl.





alfabeta(Ei,terminou):-terminal(Ei).

alfabeta(Ei,Opf) :- 
	findall(Vc-Nr_coluna, (jogada(Ei,'A',Nr_coluna,Tabuleiro), alfabeta_min(Tabuleiro,Vc,'A',-10000,10000)), L),
	escolhe_max(L,Opf).
alfabeta_min(Ei,Val,_,_,_) :- 
	terminal(Ei), 
	valor(Ei,Val), !.
alfabeta_min(Ei,Val,P,Alfa,Beta) :- 
	muda_jogador(P,J),
	V is 10000,
	findall(Tabuleiro, jogada(Ei,J,_,Tabuleiro), L),
	processa_lista_min(L, J, V, Alfa, Beta, Val), !.


processa_lista_min([], _, V, _, _, V).
processa_lista_min([H|T], P, V, A, B, V1) :-
	alfabeta_max(H, V2, P, -10000, 10000),
	min(V, V2, V3),
	(V3 < A, V1 is V3; min(B, V3, B1), processa_lista_min(T, P, V3, A, B1, V1)).


alfabeta_max(Ei,Val,_,_,_) :- 
	terminal(Ei), 
	valor(Ei,Val), !.

alfabeta_max(Ei,Val,P,Alfa,Beta) :- 
	muda_jogador(P,J),
	V is -10000,
	findall(Tabuleiro, jogada(Ei,J,_,Tabuleiro), L),
	processa_lista_max(L, J, V, Alfa, Beta, Val), !.

processa_lista_max([], _, V, _, _, V).
processa_lista_max([H|T], P, V, A, B, V1) :-
	alfabeta_min(H, V2, P, -10000, 10000),
	max(V, V2, V3),
	(V3 >= B, V1 is V3; max(A, V3, A1), processa_lista_max(T, P, V3, A1, B, V1)).



minimax_decidir(Ei,terminou):-terminal(Ei).

minimax_decidir(Ei,Opf):-
	findall(Vc-Nr_coluna,(jogada(Ei,'A',Nr_coluna,Tabuleiro),minimax_valor(Tabuleiro,Vc,'A')),L),
	escolhe_max(L,Opf).

minimax_valor(Ei,Val,_):-terminal(Ei),valor(Ei,Val).

minimax_valor(Ei,Val,P):-
	muda_jogador(P,J),
	findall(Val1,(jogada(Ei,J,_,Es),minimax_valor(Es,Val1,J)),V),
	seleciona_valor(V,P,Val).

seleciona_valor(V,P,Val) :- 
	P ='A', 
	maximo(V,Val).
seleciona_valor(V,_,Val):- minimo(V,Val).



jogada([H|T],Cor,1,[H1|T]):-poe_na_coluna(H,Cor,H1).
jogada([C1,H|T],Cor,2,[C1,H1|T]):-poe_na_coluna(H,Cor,H1).
jogada([C1,C2,H|T],Cor,3,[C1,C2,H1|T]):-poe_na_coluna(H,Cor,H1).
jogada([C1,C2,C3,H|T],Cor,4,[C1,C2,C3,H1|T]):-poe_na_coluna(H,Cor,H1).
jogada([C1,C2,C3,C4,H],Cor,5,[C1,C2,C3,C4,H1]):-poe_na_coluna(H,Cor,H1).	

%Azul ganha
valor(Tabuleiro,1):-tabuleiro(Tabuleiro),colunas(Tabuleiro,'A'),!.
valor(Tabuleiro,1):-
	tabuleiro(Tabuleiro),
	linhas(Tabuleiro,'A'),!.
valor(Tabuleiro,1):-tabuleiro(Tabuleiro),diagonal(Tabuleiro,'A'),!.

%Vermelho ganha
valor(Tabuleiro,-1):-colunas(Tabuleiro,'V'),!.
valor(Tabuleiro,-1):-
	tabuleiro(Tabuleiro),
	linhas(Tabuleiro,'V'),!.
valor(Tabuleiro,-1):-diagonal(Tabuleiro,'V'),!.
valor(_,0).

cheio([C1,C2,C3,C4,C5]) :- 
	append(C1,C2, C12),
	append(C12, C3, C123),
	append(C123,C4,C1234),
	append(C1234,C5,CF),
	\+member(' ', CF).

colunas([H|T],Cor):-(tres_em_coluna(H,Cor);colunas(T,Cor)).
tres_em_coluna([Cor,Cor,Cor,_],Cor):-Cor\=' '.
tres_em_coluna([_,Cor,Cor,Cor],Cor):-Cor\=' '.


linhas([H1,H2,H3|T],Cor):-(tres_em_linha(H1,H2,H3,Cor);linhas([H2,H3|T],Cor)).
tres_em_linha([Cor,_,_,_],[Cor,_,_,_],[Cor,_,_,_],Cor):-Cor\=' '.
tres_em_linha([_,Cor,_,_],[_,Cor,_,_],[_,Cor,_,_],Cor):-Cor\=' '.
tres_em_linha([_,_,Cor,_],[_,_,Cor,_],[_,_,Cor,_],Cor):-Cor\=' '.
tres_em_linha([_,_,_,Cor],[_,_,_,Cor],[_,_,_,Cor],Cor):-Cor\=' '.

diagonal([H1,H2,H3|T],Cor):-tres_em_diagonal(H1,H2,H3,Cor);diagonal([H2,H3|T],Cor).
tres_em_diagonal([Cor,_,_,_],[_,Cor,_,_],[_,_,Cor,_],Cor):-Cor\=' '.
tres_em_diagonal([_,Cor,_,_],[_,_,Cor,_],[_,_,_,Cor],Cor):-Cor\=' '.
tres_em_diagonal([_,_,Cor,_],[_,Cor,_,_],[Cor,_,_,_],Cor):-Cor\=' '.
tres_em_diagonal([_,_,_,Cor],[_,_,Cor,_],[_,Cor,_,_],Cor):-Cor\=' '.


poe_na_coluna([' ','A'|T],Cor,[Cor,'A'|T]).
poe_na_coluna([' ','V'|T],Cor,[Cor,'V'|T]).
poe_na_coluna([' '],Cor,[Cor]).
poe_na_coluna([H|T1],Cor,[H|T2]):-poe_na_coluna(T1,Cor,T2).

coluna_cheia(Coluna):- \+ member(' ',Coluna).

maximo([A|R],Val):- maximo(R,A,Val).
maximo([],A,A).
maximo([A|R],X,Val):- A < X,!, maximo(R,X,Val).
maximo([A|R],_,Val):- maximo(R,A,Val).

minimo([A|R],Val):- minimo(R,A,Val).
minimo([],A,A).
minimo([A|R],X,Val):- A > X,!, minimo(R,X,Val).
minimo([A|R],_,Val):- minimo(R,A,Val).

escolhe_max([A|R],Val):- escolhe_max(R,A,Val).
escolhe_max([],_-Op,Op).
escolhe_max([A-_|R],X-Op,Val) :- A < X,!, escolhe_max(R,X-Op,Val).
escolhe_max([A|R],_,Val):- escolhe_max(R,A,Val).

muda_jogador('V','A').
muda_jogador('A','V').

max(A,B,B) :- A < B, !.
max(A, _, A).
min(A,B,A) :- A < B, !.
min(_, B, B).




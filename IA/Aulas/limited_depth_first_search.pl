%representacao dos nos
%no(Estado,no_pai,Operador,Custo,Profundidade)

pesquisa_aux(_, [no(E,Pai,Op,C,P)|_],no(E,Pai,Op,C,P)) :- 
	estado_final(E).
pesquisa_aux(N, [no(E,Pai,Op,C,P)|R],Sol):- 
	P < N,
	expande(no(E,Pai,Op,C,P),Lseg),
        insere_inicio(Lseg,R,LFinal),
        pesquisa_aux(N, LFinal,Sol).
pesquisa_aux(N, [no(_,_,_,_,P)|R],Sol):- 
	P == N,
        pesquisa_aux(N, R, Sol).


expande(no(E,Pai,Op,C,P),L):- 
	findall(no(En,no(E,Pai,Op,C,P), Opn, Cnn, P1),
                (op(E,Opn,En,Cn), P1 is P+1, Cnn is Cn+C),
                L).

pesquisa :-
	estado_inicial(S0),
	pesquisa_aux(15, [no(S0,[],[],0,0)], S),
	write(S), nl.

insere_inicio(A,B,C) :- append(A, B, C).

insere_fim(A,B,C) :- append(B, A, C).

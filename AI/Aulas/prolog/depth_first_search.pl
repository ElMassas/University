%representacao dos nos
%no(Estado,no_pai,Operador,Custo,Profundidade)

pesquisa_aux([no(E,Pai,Op,C,P)|_],no(E,Pai,Op,C,P)) :- 
	estado_final(E).
pesquisa_aux([E|R],Sol):- 
	expande(E,Lseg),
        insere_inicio(Lseg,R,LFinal),
        pesquisa_aux(LFinal,Sol).

expande(no(E,Pai,Op,C,P),L):- 
	findall(no(En,no(E,Pai,Op,C,P), Opn, Cnn, P1),
                (op(E,Opn,En,Cn), P1 is P+1, Cnn is Cn+C),
                L).

pesquisa :-
	estado_inicial(S0),
	pesquisa_aux([no(S0,[],[],0,0)], S),
	write(S), nl.

insere_inicio(A,B,C) :- append(A, B, C).

insere_fim(A,B,C) :- append(B, A, C).

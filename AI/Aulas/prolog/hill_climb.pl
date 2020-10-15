pesquisa_local_hill_climbing(E) :- 
	estado_final(E),
	write(E), write(' ').

pesquisa_local_hill_climbing(E) :- 
	write(E), write(' '),
	expande(E,Lseg),
        melhor_vizinho(Lseg,no(ES,Op,_)),
	write(Op), nl,
        pesquisa_local_hill_climbing(ES).

expande(E, L):- 
	findall(no(En,Opn, Heur),
                (op(E,Opn,En,_), heur(En, Heur)),
                L).

melhor_vizinho([no(E,Op,H)], no(E,Op,H)).
melhor_vizinho([no(E,Op,H)|T], V) :-
	melhor_vizinho(T, no(ET, OpT, HeurT)),
	(H < HeurT, V = no(E,Op,H) ; V = no(ET, OpT,HeurT)).

pesquisa :-
	estado_inicial(S0),
	pesquisa_local_hill_climbing(S0).

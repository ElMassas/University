%Descricao do problema:

%estado_inicial(Estado)
estado_inicial([asp(1), [sujo, sujo]]).

%estado_final(Estado)
estado_final([_, [limpo, limpo]]).

%representacao dos operadores
%op(Eact,OP,Eseg,Custo)

op([asp(1), [sujo, X]], aspira, [asp(1), [limpo, X]], 1).
op([asp(2), [X, sujo]], aspira, [asp(2), [X, limpo]], 1).
op([asp(_), X], direita, [asp(2), X], 1).
op([asp(_), X], esquerda, [asp(1), X], 1).


p_profundidade(S, S, [], 0).
p_profundidade(S0, SF, [Accao|T], Cost) :-
	op(S0, Accao, S1, C),
	p_profundidade(S1, SF, T, CT),
	Cost is C + CT.
	
pesquisa :-
	estado_inicial(S0),
	estado_final(SF),
	p_profundidade(S0, SF, L, C),
	write(L), nl,
	write(C), nl.

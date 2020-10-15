%Descricao do problema:

%estado_inicial(Estado)
estado_inicial([asp(1), [limpo, sujo]]).

%estado_final(Estado)
estado_final([_, [limpo, limpo]]).

%representacao dos operadores
%op(Eact,OP,Eseg,Custo)

op([asp(1), [sujo, X]], aspira, [asp(1), [limpo, X]], 1).
op([asp(2), [X, sujo]], aspira, [asp(2), [X, limpo]], 1).
op([asp(_), X], direita, [asp(2), X], 1).
op([asp(_), X], esquerda, [asp(1), X], 1).

%representacao dos nos
%no(Estado,no_pai,Operador,Custo,CustoHeur,Profundidade)

heur([asp(_), [limpo, limpo]], 0).
heur([asp(1), [sujo, limpo]], 1).
heur([asp(2), [sujo, limpo]], 2).
heur([asp(1), [limpo, sujo]], 2).
heur([asp(2), [limpo, sujo]], 1).
heur([asp(_), [sujo, sujo]], 3).
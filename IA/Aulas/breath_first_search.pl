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
%no(Estado,no_pai,Operador,Custo,Profundidade)

pesquisa_largura([no(E,Pai,Op,C,P)|_],no(E,Pai,Op,C,P)) :- 
	estado_final(E).
pesquisa_largura([E|R],Sol):- 
	expande(E,Lseg),
        insere_fim(Lseg,R,LFinal),
        pesquisa_largura(LFinal,Sol).

expande(no(E,Pai,Op,C,P),L):- 
	findall(no(En,no(E,Pai,Op,C,P), Opn, Cnn, P1),
                (op(E,Opn,En,Cn), P1 is P+1, Cnn is Cn+C),
                L).

pesquisa :-
	estado_inicial(S0),
	pesquisa_largura([no(S0,[],[],0,0)], S),
	write(S), nl.


insere_fim([],L,L).
insere_fim(L,[],L).
insere_fim(R,[A|S],[A|L]):- insere_fim(R,S,L).

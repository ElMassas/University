%chamada da pesquisa
%! para só dar uma resposta
pesquisa(A,B,N):-pesquisa(A,B,[A],N),!.
%caso base chega ao estado final
pesquisa((A,B),(A,B),X,_):-nl,write(X).
%pesquisa(Inicio,Final,Visitados,Tamanho)
pesquisa(A,B,Visitados,N):-
	pesquisa_heuristica(A,B,Visitados,N).
	
pesquisa_heuristica(A,B,Visitados,N):-
	calc_heuristics(A,B,N,Visitados,[(X,_)|T]),
	[(X,_)|T] \== [], 
	write("Moving: "),write(X),nl,
	move(A,C,N,Visitados,X),
	append(Visitados,[C],Visitados2),
	(pesquisa(C,B,Visitados2,N);
	write("Returning to: "),write((A)),nl,
	pesquisa_heuristica(A,B,Visitados2,N)).

%List e uma lista do tipo [("left",2),("right",3)]
%com a diracao e a distancia de cada nó ordenado do menor para o maior
calc_heuristics(A,B,N,V,List):-
	append_list(A,B,N,V,[],List2,"Right"),
	append_list(A,B,N,V,List2,List3,"Left"),
	append_list(A,B,N,V,List3,List4,"Up"),
	append_list(A,B,N,V,List4,List5,"Down"),
	list_sort(List5,List).
	
append_list(A,B,N,V,List1,List2,Dir):-
	move(A,C,N,V,Dir)->heuristic(C,B,Heu),append([(Dir,Heu)],List1,List2);
	append([],List1,List2).
		
heuristic((A,B),(C,D),Heu):-Heu is abs((C-A)+(D-B)). 

%da sort a lista pela distância de cada movimento possivel
%insert_sort aplicado ao problema
list_sort(List,Sorted_List):-list_sort(List,[],Sorted_List).
list_sort([],A,A).
list_sort([H|T],List1,List2):-insert(H,List1,List3),list_sort(T,List3,List2).

insert((X,Y),[(A,B)|T1],[(A,B)|T2]):-Y>B,insert(X,T1,T2).
insert((X,Y),[(A,B)|T],[(X,Y),(A,B)|T]):-Y=<B.
insert(X,[],[X]).

%verdade quando A esta dentro dos limites
min(A):-A>1.
max(A,N):-A<N.

parede((4,2),(4,3)).
parede((2,1),(2,2)).
parede((3,1),(4,1)).
parede((3,2),(3,3)).
parede((1,1),(1,2)).

%right
move((A,B),(A,C),N,V,"Right"):-
	max(B,N),
	C is B+1,
	\+member((A,C),V),
	\+(parede((A,B),(A,C));parede((A,C),(A,B))).
	%write("Right"),nl.

%left
move((A,B),(A,C),_,V,"Left"):-
	min(B),
	C is B-1,
	\+member((A,C),V),
	\+(parede((A,B),(A,C));parede((A,C),(A,B))).
	%write("Left"),nl.
	
%up
move((A,B),(C,B),_,V,"Up"):-
	min(A),
	C is A-1,
	\+member((C,B),V),
	\+(parede((A,B),(C,B));parede((C,B),(A,B))).
	%write("Up"),nl.

%Down
move((A,B),(C,B),N,V,"Down"):-
	max(A,N),
	C is A+1,
	\+member((C,B),V),
	\+(parede((A,B),(C,B));parede((C,B),(A,B))).
	%write("Down"),nl.	

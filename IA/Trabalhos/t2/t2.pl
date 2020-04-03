%states
initial_state((1,1)).
final_state((1,4)).


blocked((1,1),(1,2)).
blocked((2,1),(2,2)).
blocked((3,1),(4,1)).
blocked((4,2),(4,3)).
max_size(4).

%True when A is inside the limits
min(A):-A>1.
max(A,N):-A<N.

%right
operation((A,B),(A,C),N):-
	max(B,N),
	C is B+1,
	\+blocked((A,B),(A,C)),
    \+blocked((A,C),(A,B)).


%left
operation((A,B),(A,C),_):-
	min(B),
	C is B-1,
	\+blocked((A,B),(A,C)),
    \+blocked((A,C),(A,B)).


%up
operation((A,B),(C,B),_):-
	min(A),
	C is A-1,
	\+blocked((A,B),(C,B)),
    \+blocked((C,B),(A,B)).


%Down
operation((A,B),(C,B),N):-
	max(A,N),
	C is A+1,
	\+blocked((A,B),(C,B)),
    \+blocked((C,B),(A,B)).


local_search_cicless_hillClimb(E, Path) :- 
	final_state(E),
	append(Path,[E],Final_path),
	write(Final_path), write('|').

local_search_cicless_hillClimb(E, Visited) :- 
    append(Visited,[E], Updated),
    max_size(C),
    operation(E, Next, C),
    \+ member(Next, Updated),
    local_search_cicless_hillClimb(Next, Updated).

search :-
	initial_state(S0),
	local_search_cicless_hillClimb(S0, []).
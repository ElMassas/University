%predicates
    split(l,l,l).

%clauses
    split([],[],[]).

    split([X|List] , Positive , [X|Negative]) :-
        X < 0,
        split(List,Positive,Negative).

    split([X|List] , [X|Positive] , Negative) :-
        X >= 0,
        split(List,Positive,Negative).
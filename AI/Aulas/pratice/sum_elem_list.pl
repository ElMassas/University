%predicates
    findsum(list).
    sum(list,integer).
%clauses

    findsum(L):-
        sum(L,Sum),
        write(\"\nSum Of Given List : ",Sum).

    sum([],0).

    sum([X|Tail],Sum):-
        sum(Tail,Temp),
        Sum=Temp+X.
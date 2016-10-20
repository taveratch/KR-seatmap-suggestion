% :- use_module(seat_map_kind,[]).
:- use_module(seat_map_position,[]).
:- use_module(user_facts,[]).
:- use_module(rules,[]).

getSeat(X,M) :-
  write('Getting seat'),
  nl,
  rules:position(Position,M),
  seat_map_position:near(X,Position),
  rules:notNoisy(X).

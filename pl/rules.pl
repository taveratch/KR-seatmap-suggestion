:- module(rules,[]).
position(window,M) :-
	user_facts:hasChild(M),
	write('This guy has children with him'),
	nl,
	write('His seat should be near window'),
	nl.
position(exitRow,M) :-
  user_facts:isTall(M),
	write('This guy is tall'),
	nl,
	write('His seat should be near exitRow'),
	nl.
position(walkway,M) :-
  user_facts:isOld(M),
  write('This guy is old'),
  nl,
  write('His seat should be near walkway'),
  nl.
position(exitRow,M) :-
  user_facts:isOld(M),
  write('This guy is old'),
  nl,
  write('His seat should be near exitRow'),
  nl.
property(private,M) :-
  user_facts:prefers(M,private),
  write('This guy wants private seat'),
  nl.
noisy(M) :-
  seat_map_position:near(M,toilet);
  seat_map_position:near(M,galley).

filter_private(X,W,M) :-
  (property(private,M)
  -> ako(X,W)
  ;  X=X
  ).

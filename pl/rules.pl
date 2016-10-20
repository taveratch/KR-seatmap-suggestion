:- module(rules,[]).

isOld(M) :-
  user_facts:age(X,M),
  X >= 60.

isTall(M) :-
  user_facts:tall(X,M),
  X >= 180.

position(window,M) :-
	user_facts:hasChild(M),
	write('This guy has children with him'),
	nl,
	write('His seat should be near window'),
	nl.

position(exitRow,M) :-
  isTall(M),
	write('This guy is tall'),
	nl,
	write('His seat should be near exitRow'),
	nl.

position(walkway,M) :-
  isOld(M),
  write('This guy is old'),
  nl,
  write('His seat should be near walkway'),
  nl.

position(exitRow,M) :-
  isOld(M),
  write('This guy is old'),
  nl,
  write('His seat should be near exitRow'),
  nl.

position(private,M) :-
  user_facts:prefers(M,private),
  write('This guy wants private seat'),
  nl.

noisy(M) :-
  seat_map_position:near(M,toilet);
  seat_map_position:near(M,galley).

prefers(adam,private).
hasChild(adam).
isOld(adam) :- false.
isTall(adam) :- false.
position(window,M) :-
	hasChild(M),
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
property(private,M) :-
  prefers(M,private),
  write('This guy wants private seat'),
  nl.
noisy(M) :-
  near(M,toilet);
  near(M,galley).

filter_private(X,W,M) :-
  (property(private,M)
  -> ako(X,W)
  ;  X=X
  ).
getSeat(X,M) :-
	write('Getting seat'),
	nl,
	position(Y,M),
	near(X,Y),
  filter_private(X,private,M).

:- module(user_facts,[]).
prefers(adam,private) :- false.
hasChild(adam).
age(40,adam).
hasInfant(adam) :- false.
height(200,adam).
prefers_class(adam,economy).
prefers_class(adam,business) :- false.
prefers_class(adam,first) :- false.

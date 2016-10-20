from pyswip import Prolog

prolog = Prolog()
prolog.consult("./pl/engine.pl")
# def fact(string):
# 	prolog.assertz(string)

# def isOld(age):
# 	if(age > 60):
# 		fact("isOld(a)")
# 		return True
# 	fact("isOld(a):-false")
# 	return False

# def hasChild(has):
# 	if(has):
# 		fact("hasChild(a)")
# 	else:
# 		fact("hasChild(a):-false")
# 	return has

# def isTall(height):
# 	if(height > 180):
# 		fact("isTall(a)")
# 		return True
# 	fact("isTall(a):-false")
# 	return False

# def privacy(need_privacy):
# 	if(need_privacy):
# 		prolog.query("rules:private(a)")
# 	return need_privacy


# age = raw_input('Age: ')
# print isOld(int(age))

# height = raw_input('Heigth (in centimetre): ')
# print isTall(int(height))

# need_privacy = raw_input('Do you need extra privacy (yes/no): ')
# privacy(need_privacy == "yes")

# child = raw_input('Travel with child (yes/no): ')
# print hasChild(child == "yes")


print str(list(prolog.query("getSeat(X, adam).")))

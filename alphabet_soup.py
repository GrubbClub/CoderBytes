def alphabet_soup(sen): #puts all letters in string in alphabetical order
	arr = [] #holds our ascii nums
	as_str = "" #to put back together
	for s in sen: #gets our chars converted to nums
		arr.append(ord(s))
	arr.sort() #arranges from low to high
	for s in arr: #converts back
		as_str += chr(s)
	return as_str

print alphabet_soup("coderbyte")
print alphabet_soup("hooplah")
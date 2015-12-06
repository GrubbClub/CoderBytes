def alphabet_soup(sen):
	arr = []
	as_str = ""
	for s in sen:
		arr.append(ord(s))
	arr.sort()
	for s in arr:
		as_str += chr(s)
	return as_str

print alphabet_soup("coderbyte")
print alphabet_soup("hooplah")
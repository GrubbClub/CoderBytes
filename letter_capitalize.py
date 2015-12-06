def letter_capitalize(sen):
	arr = sen.split()
	cap_arr = []
	for a in arr:
		cap_arr.append(a.capitalize())
	cap_str = " ".join(cap_arr)
	return cap_str

print letter_capitalize("and I feel that time's a wasted go")
print letter_capitalize("so where you going til tomorrow when i see")
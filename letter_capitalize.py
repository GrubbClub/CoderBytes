def letter_capitalize(sen): #capitalizes the first letter of every word
	arr = sen.split() #splits the words into elements of an array
	cap_arr = [] #for our capitalized words
	for a in arr: #capitalizes each word and puts them in cap_arr
		cap_arr.append(a.capitalize())
	cap_str = " ".join(cap_arr) #puts the sentence back together as a string
	return cap_str

print letter_capitalize("and I feel that time's a wasted go")
print letter_capitalize("so where you going til tomorrow when i see")
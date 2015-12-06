def first_reverse_e(sen):
	str_arr = []
	for s in sen:
		str_arr.append(s)
	print str_arr
	str_arr.reverse()
	print str_arr
	reverse_str = ""
	for a in str_arr:
		reverse_str += a
	return reverse_str

print first_reverse_e("I liek turtles!")
def letter_changes(sen): #moves every letter up on in the alphabet and then capitalizes vowels
	sen_arr = [] #array to put ascii numbers after conversion
	final_str = "" #result string
	for s in sen: #converts all chars to ascii numbers
		sen_arr.append(ord(s))

	for i in sen_arr: #converter
		if i == 90 or i == 122: #for z's
			final_str += "A"
		elif i == 100: #for "d" to become "E"
			final_str += "E"
		elif i == 104: #for "h" to become "I"
			final_str += "I"
		elif i == 110: #for "n"
			final_str += "O"
		elif i == 116: #for "t"
			final_str += "U"
		elif (i > 64 and i < 90) or (i > 96 and i < 122): #converts all remaining letters up 1
			final_str += chr(i + 1)
		else: #for punctuation or whitespace
			final_str += chr(i)
	return final_str

print letter_changes("You can tell by the way I use my walk; I'm a woman's man, no time to talk")
def letter_changes(sen):
	sen_arr = []
	final_str = ""
	for s in sen:
		sen_arr.append(ord(s))

	for i in sen_arr:
		if i == 90 or i == 122:
			final_str += "A"
		elif i == 100:
			final_str += "E"
		elif i == 104:
			final_str += "I"
		elif i == 110:
			final_str += "O"
		elif i == 116:
			final_str += "U"
		elif (i > 64 and i < 90) or (i > 96 and i < 122):
			final_str += chr(i + 1)
		else:
			final_str += chr(i)
	return final_str

print letter_changes("You can tell by the way I use my walk; I'm a woman's man, no time to talk")
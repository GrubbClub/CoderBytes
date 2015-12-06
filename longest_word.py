def longest_word(sen):
	high_score = 0
	winner = ""
	sen_arr = sen.split()
	for s in sen_arr:
		if len(s) > high_score:
			winner = s
			high_score = len(s)
	return winner


print longest_word("I am smelling like a rose on my birthday death bed")
print longest_word("a long long long long time ago before the wind before the snow")
print longest_word("lived a man lived a man i know lived a freak of nature named sir psycho")
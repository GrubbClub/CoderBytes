def simple_symbols(sen):
	i = 0 #counter
	for s in sen: #goes through our string checking for letters
		#if (ord(s) >= 65 and ord(s) <= 90) or (ord(s) >= 97 and ord(s) <= 122): first attempt before learning isalpha()
		if s.isalpha(): #if a letter is found
			if i == 0 or i == len(sen) - 1: #prevents edge cases
				return False
			elif sen[i - 1] != "+" or sen[i + 1] != "+": #returns false if its not surrounded by "+"
				return False
		i += 1 #keep on counting
	return True #if you make it all the way through without returning a false, you gravy baby

print simple_symbols("+d+=3=+s+")
print simple_symbols("f++d+")
print simple_symbols("+d+=3=+s")
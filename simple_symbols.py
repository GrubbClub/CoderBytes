def simple_symbols(sen):
	i = 0
	for s in sen:
		if (ord(s) >= 65 and ord(s) <= 90) or (ord(s) >= 97 and ord(s) <= 122):
			if i == 0 or i == len(sen) - 1:
				return False
			elif sen[i - 1] != "+" or sen[i + 1] != "+":
				return False
		i += 1
	return True

print simple_symbols("+d+=3=+s+")
print simple_symbols("f++d+")
print simple_symbols("+d+=3=+s")
def first_reverse(sen): #reverse all letters in a string
	str_arr = [] #empty array to hold all the individual letters
	reverse_str = "" #empty string to add our reversed letters to
	for s in sen:
		str_arr.append(s) #iterates through all characters in string and adds them to arr as sep elements
	str_arr.reverse() #reverses all elements in array
	for a in str_arr: #iterates through reversed array to add them to our string
		reverse_str += a
	return reverse_str

print first_reverse("I liek turtles!")
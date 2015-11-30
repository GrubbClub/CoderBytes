def off_line_min(arr):
	result = [] #stores final answer
	bfr = [] #creates buffer of currently seen list
	for a in arr:
		if a == "E": #for e's function
			x = min(bfr) #sets x to lowest integer in our current list
			result.append(x) #adds x to our final answer
			bfr.remove(x) #removes x from the buffer
		else:
			bfr.append(a) #builds our buffer
	return result

my_array = [5,4,6,"E",1,7,"E","E",3,2]

print off_line_min(my_array)
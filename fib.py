def fibinocci(n):
	arr = [0, 1] #base case and where the sequence will be stored in order
	i = 0 #counter
	while i < (n - 1): #our counter to know when to stop building out the fibinocci sequence
		arr.append(arr[i] + arr[i+1]) #second to last number plus last number in array give next number
		i += 1 #don't forget to bring a towel
	return arr[i+1]

print fibinocci(120)
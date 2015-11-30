def fibinocci(n):
	arr = [0, 1]
	i = 0
	while i < (n - 1):
		arr.append(arr[i] + arr[i+1])
		i += 1
	return arr[i+1]

print fibinocci(120)
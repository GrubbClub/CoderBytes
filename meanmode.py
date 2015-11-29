def mean(arr): #method to find the mean (average)
	total = 0
	size = len(arr)
	for a in arr: #adding up the numbers in the array
		total += a
	return total / size #duh

def mode(arr): #method to find the mode (number most recurring)
	counter = 0
	high_score = 0
	winner = 0
	for a in arr:
		counter = 0
		for i in range(len(arr)):
			if a == arr[i]:
				counter += 1
				if counter > high_score:
					high_score = counter
					winner = a
	return winner


def meanmode(arr):
	if mean(arr) == mode(arr):
		return 1
	else:
		return 0

a1 = [1, 2, 3, 4, 5, 4]
a2 = [1, 2, 3, 3, 5, 4]

print meanmode(a1)
print meanmode(a2)
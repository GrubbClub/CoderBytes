def mean(arr): #method to find the mean (average)
	total = 0
	size = len(arr)
	for a in arr: #adding up the numbers in the array
		total += a
	return total / size #duh

def mode(arr): #method to find the mode (number most recurring)
	counter = 0
	high_score = 0 #most recurrances
	winner = 0 #current holder of the high score
	for a in arr: #iterates over our contestents
		counter = 0 #resets the counter for current number
		for i in range(len(arr)): #iterates over the indices for comparision with current contestent
			if a == arr[i]: #for each match
				counter += 1
				if counter > high_score: #checks to see if current contestent beats the high score
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
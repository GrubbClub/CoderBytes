def simple_adding(num): #adds all numbers up to num together
	total = 0 #running total
	for i in range(num + 1): #iterates through every number up to num
		total += i #adds to total
	return total

print simple_adding(12)
print simple_adding(49)
print simple_adding(999)
print simple_adding(4)
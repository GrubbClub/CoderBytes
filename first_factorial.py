def first_factorial(num): #multiples all numbers from 1 to num
	total = 1 # running total
	while num > 1: # start from num and count backwards
		total *= num
		num -= 1
	return total

print first_factorial(5)
print first_factorial(18)
print first_factorial(1)
def first_factorial(num):
	total = 1
	while num > 1:
		total *= num
		num -= 1
	return total

print first_factorial(5)
print first_factorial(18)
print first_factorial(1)
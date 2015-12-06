def check_nums(num1, num2): #if 1 is < 2 its true, 1 > 2 false, if same return -1
	if num1 == num2:
		return (-1)
	elif num1 < num2:
		return True
	else:
		return False

print check_nums(3,122)
print check_nums(122, 3)
print check_nums(32, 32)
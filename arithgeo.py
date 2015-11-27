def is_arith(nums): #this funtion returns a boolean of if a list is arithmetic
	arith = True #starts true for while loop
	i = 0
	difference = nums[1] - nums[0] #determines what the arithmetic pattern must be
	while arith:
		if i == len(nums) - 1:
			return arith
		elif nums[i + 1] - nums[i] != difference:
			arith = False
		i += 1
	return arith


def is_geo(nums):
	geo = True
	i = 0
	difference = nums[1] / nums[0]
	if nums[1] % nums[0] != 0:
		return False
	while geo:
		if i == len(nums) - 1:
			return geo
		elif nums[i + 1] % nums[i] != 0:
			geo = False
		elif nums[i + 1] / nums[i] != difference:
			geo = False
		i += 1
	return geo

def arithgeo(nums):
	if is_arith(nums):
		return "Arithmetic"
	elif is_geo(nums):
		return "Geometric"
	else:
		return (-1)


my_a_list_t = [-2, 0, 2, 4, 6, 8, 10]
my_a_list_f = [2, 5, 7, 8, 12]
my_g_list_t = [2, 6, 18, 54, 162]
my_g_list_f1 = [2, 7, 18, 54, 162]
my_g_list_f2 = [2, 6, 12, 36, 108]

print is_arith(my_a_list_t)
print is_arith(my_a_list_f)
print is_geo(my_g_list_t)
print is_geo(my_g_list_f1)
print is_geo(my_g_list_f2)
print "Yolo"

print arithgeo(my_a_list_t)
print arithgeo(my_a_list_f)
print arithgeo(my_g_list_t)
print arithgeo(my_g_list_f1)
print arithgeo(my_g_list_f2)
def binary_converter(num_str): #way too easy version
	bin_str = "0b" + num_str #adds the 0b binary prefix to the string
	return int(bin_str, 2) #simple commands to convery binary string

print binary_converter("101")
print binary_converter("1000")

def bin_converter(num_str): #more involved version
	total = 0 #running count
	power = 2 ** (len(num_str) - 1) #which power of 2 we are on for binary conversion
	for n in num_str:
		total += (int(n) * power) #one times whichever power we are at to get the value of the bit
		power /= 2 #reading left to right we are going down in the powers of 2
	return total

print bin_converter("101")
print bin_converter("1000")
print bin_converter("1")
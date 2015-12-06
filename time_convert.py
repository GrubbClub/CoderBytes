def time_convert(num): #converts minutes to hours and minutes
	hours = str(num / 60) #hours formula
	mins = str(num % 60) #minutes formula
	return hours + ":" + mins #gives string format

print time_convert(126)
print time_convert(45)
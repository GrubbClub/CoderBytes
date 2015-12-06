def time_convert(num):
	hours = str(num / 60)
	mins = str(num % 60)
	return hours + ":" + mins

print time_convert(126)
print time_convert(45)
def bj_highest(str_arr):
	aces = 0     #track number of aces to know how many to reduce when over 21
	king = False    #tracks status of face cards for comparison
	queen = False
	jack = False
	ten = False
	faces = 0
	total = 0 #running total of hand
	highest = "" #current highest card
	high_value = 0 #for comparing high cards
	winlose = "" #string placehold for above, below, and at 21

	values = {   #dictionary with our card values
	"two" : 2,
	"three" : 3,
	"four" : 4,
	"five" : 5,
	"six" : 6,
	"seven" : 7,
	"eight" : 8,
	"nine" : 9,
	"ten" : 10,
	"jack" : 10,
	"queen" : 10,
	"king" : 10,
	"ace" : 11
	}

	for card in str_arr:              #iterates to find our hand total and the presence of aces and faces
		total += values[card]
		if card == "ace":
			aces += 1
		elif card == "king":
			faces += 1
			king = True
		elif card == "queen":
			faces += 1
			queen = True
		elif card == "jack":
			faces += 1
			jack = True
		elif card == "ten":
			faces += 1
			ten = True

	if len(str_arr) == 2 and aces == 1 and faces == 1: #end program if blackjack is found
		return "blackjack ace"

	while total > 21 and aces > 0: #keeps lowering total if the total is above 21 and there as an ace worth 11
		total -= 10 #we turn the ace into a 1
		aces -= 1 #and lower the amount of aces worth 11

	if total > 21:           #sets condition based on final total after aces have been accounted for
		winlose = "above"
	elif total < 21:
		winlose = "below"
	elif total == 21:
		winlose = "at 21"

	if aces > 0: #if there is an ace worth 11 it is automatically the high card
		return winlose + " ace"

	if faces > 0: #if there are any face cards this is how we determine rank
		if king:
			return winlose + " king"
		elif queen:
			return winlose + " queen"
		elif jack:
			return winlose + " jack"
		else:
			return winlose + " ten"


	for card in str_arr:               #if no face cards this will determine the highest card in hand
		if values[card] > high_value:  # based on value dictonary
			highest = card
			high_value = values[card]

	return winlose + " " + highest


hand1 = ["ace", "ace", "ace", "ace"]
hand2 = ["two", "three", "ace", "king"]
hand3 = ["four", "ten", "king"]
hand4 = ["ace", "king", "jack", "queen", "two"]
hand5 = ["ace", "king"]
hand6 = ["seven", "six", "eight"]

print bj_highest(hand1)
print bj_highest(hand2)
print bj_highest(hand3)
print bj_highest(hand4)
print bj_highest(hand5)
print bj_highest(hand6)
#caesar cipher
#take a string and move all letters DOWN the alphabet by INTERGER

def caesar_cipher(st, num):  
    if num > 26: #finds the real number for shift if num > alphabet length
        num = num % 26
    
    numeric_string = [] #for letters turned to numbers
    
    shifted_numbers = [] #for numbers after shift
    
    encrypted_string = "" #for shifted numbers back to letters
    
    for s in st: #change our letters to numbers
        numeric_string.append(ord(s))
        
    for n in numeric_string: #this will shift the number string down by num
        if n >= 65 and n <= 90: #capital letters
            if n - num < 65: #for overrun we wrap around the alphabet
                x = num - (n - 65)
                shifted_numbers.append(91 - x)
            else:
                shifted_numbers.append(n - num)
        elif n >= 97 and n <= 122: #lowercase letters
            if n - num < 97: #for overrun
                x = num - (n - 97)
                shifted_numbers.append(123 - x)
            else:
                shifted_numbers.append(n - num)
        else:
            shifted_numbers.append(n) #for punctuation and spaces
    
    for i in shifted_numbers: #reverts numbers back to letters
        encrypted_string += (unichr(i))

    return encrypted_string

str_input = raw_input("encrypt: ")
num_input = int(raw_input("key: "))
    
print caesar_cipher(str_input, num_input)
class writeNumber
{
    String[] dictNums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String[] dictTeens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen"};
    String[] dictTens = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    
    public static String converter(int num)
    {
        int wordCount = 0;
        String[] wordArray;
        
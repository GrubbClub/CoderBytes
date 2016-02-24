class PalindromeString
{
    
    private static String getReverse(String word)
    {
     char[] reverse = new char[word.length()];
     char[] sstring = new char[word.length()];
     
     for (int i = 0; i < word.length(); i++)
     {
         sstring[i] = word.charAt(i);
     }
     
     for (int x = 0; x < word.length(); x++)
     {
         reverse[x] = sstring[word.length() - 1 - x];
     }
     String revstr = new String(reverse);
     return revstr;
    }
    
    public static boolean isPalindrome(String phrase)
    {
        if(phrase.equals(getReverse(phrase)))
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
     String tester = "tester";
     System.out.println(tester);
     String[] test1 = tester.split("");
     for (int i=0; i < test1.length; i++)
     {
         System.out.println(test1[i]);
     }
     System.out.println(getReverse(tester).equals("retset"));
     System.out.println(isPalindrome("tester") == false);
     System.out.println(isPalindrome("racecar") == true);
    }
}
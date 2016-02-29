class isBinary
{
    public static char[] convToStr(int num)
    {
        String tempstr = String.valueOf(num);
        return tempstr.toCharArray();
    }
    
    public static String isBinary(int num)
    {
        char[] convertednum = convToStr(num);
        int len = convertednum.length;
        int[] numArray = new int[len];
        for (int i = 0; i < len; i++)
        {
            numArray[i] = Character.getNumericValue(convertednum[i]);
        }
        for (int i = 0; i < len; i++)
        {
            for(int j = 2; j <= 9; j++){
                if (numArray[i] == j){
                    return "Is not binary";
                }
            }
        }
        return "Is binary";
    }
    
//    public static boolean isBinary(int num)
//    {
//        String numstr = String.valueOf(num);
//        for (int i = 2; i <= 9; i++)
//        {
//            String j = String.valueOf(i);
//            if (numstr.contains(j) == true)
//            {
//                return false;
//            }
//        }
//        return true;
//    }
    
    public static void main (String[] args)
    {
        String tester = "10001";
        System.out.println(tester);
        System.out.println(tester.contains("0"));
        System.out.println(tester.contains("1"));
        System.out.println(tester.contains("2"));
        String bintest = "0b" + tester;
        System.out.println(bintest);
        int testnum = 1001;
        System.out.println(testnum + "hi");
        
        System.out.println(isBinary(10001).equals("Is binary"));
        System.out.println(isBinary(10021));
        System.out.println(isBinary(10021).equals("Is not binary"));
        System.out.println(isBinary(510001).equals("Is not binary"));
        
    }
}
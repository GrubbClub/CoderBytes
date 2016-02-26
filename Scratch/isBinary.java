class isBinary
{
//    public static String[] convToStr(int num)
//    {
//        String tempstr = String.valueOf(num);
//        return tempstr.split("");
//    }
//    
//    public static boolean isBinary(int num)
//    {
//        String[] convertednum = convToStr(num);
//        int len = convertednum.length;
//        int[] numArray = new int[len];
//        for (int i = 0; i < len; i++)
//        {
//            numArray[i] = Integer.parseInt(convertednum[i]);
//        }
//        for (int i = 0; i < len; i++)
//        {
//            for(int j = 2; j <= 9; j++){
//                if (numArray[i] == j){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
    
    public static boolean isBinary(int num)
    {
        String numstr = String.valueOf(num);
        for (int i = 2; i <= 9; i++)
        {
            String j = String.valueOf(i);
            if (numstr.contains(j) == true)
            {
                return false;
            }
        }
        return true;
    }
    
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
        
        System.out.println(isBinary(10001) == true);
        System.out.println(isBinary(10021) == false);
        System.out.println(isBinary(510001) == false);
        
    }
}
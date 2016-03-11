import RandomizedQueue;
import StdIn;
public class Subset
{   
    public static void main(String[] args)
    {
        int k = Integer.parseInt(args[0]);
        String kunztring = StdIn.readString();
        String[] kunzarray = kunztring.split(" ");
        RandomizedQueue kunzq = new RandomizedQueue();
        for (int i= 0; i < kunzarray.length; i++)
        {
            kunzq.enqueue(kunzarray(i));
        }
        for (int i = 0; i <= k; i++)
        {
            System.out.println(kunzq.dequeue());
        }
    }
}
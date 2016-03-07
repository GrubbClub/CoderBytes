import java.util.Random;
import java.util.Iterator;
public class RandomizedQueue<Item> implements Iterable<Item> {
    int size;
    int insertHere;
    int max;
    Object[] rq;
    private class RandomizedQueueIterator implements Iterator
    {
        Object[] rqiarray;
        int current = 0;
       
        public RandomizedQueueIterator(Object[] itarray)
        {
            rqiarray = itarray;
        }
        public boolean hasNext()
        {
            return current < rqiarray.length;
        }
        public void remove()
        {
            throw new UnsupportedOperationException("RS says fuckouttahere");
        }
        public Item next()
        {
            return (Item)rqiarray[current++];
        }
    }
    public RandomizedQueue()                 // construct an empty randomized queue
    {
        rq = new Object[10];
    }
    private RandomizedQueue(Item[] kunz)
    {
        rq = kunz;
    }
    public boolean isEmpty()                 // is the queue empty?
    {
        return size() == 0;
    }
    public int size()                        // return the number of items on the queue
    {
        return size;
    }
    public void enqueue(Item item)           // add the item
    {
        resize();
        rq[insertHere] = item;
        getNextInsertHere(); 
    }
    public Item dequeue()                    // remove and return a random item
    {
        int num;
        do
        {
            num = (int)Math.random() * (max+1);
        } while (rq[num] == null);
        Item toReturn = (Item)rq[num];
        rq[num] = null;
        if (insertHere > num)
        {
            insertHere = num;
        }
        size--;
        return toReturn;
    }
    public Item sample()                     // return (but do not remove) a random item
    {
        int num;
        do
        {
            num = (int)Math.random() * (max+1);
        } while (rq[num] == null);
        return (Item)rq[num];
    }
    
    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
        Object[] itarray = new Object[size];
        RandomizedQueue throwaway = new RandomizedQueue(rq);
        int i = 0;
        while (!throwaway.isEmpty())
        {
            itarray[i++] = throwaway.dequeue();
        }
        return new RandomizedQueueIterator(itarray);
    }
    
    private void resize()
    {
        Object[] temp;
        if  (size >= max / 2)
        {
            temp = new Object[max*2];
            max = max*2;
        }
        else if (size <= max / 4)
        {
            temp = new Object[max/2];
            max = max/2;
        }
        else
        {
            return;
        }
        int j = 0;
        for (int i = 0; i < temp.length; i++)
        {
            if (rq[i] != null)
            {
                temp[j++] = rq[i];
            }
        }
        rq = temp;
    }
    
    private void getNextInsertHere()
    {
        while (rq[++insertHere] != null){}
    }
    
    public static void main(String[] args)   // unit testing
    {
        RandomizedQueue<Integer> kunzq = new RandomizedQueue<Integer>();
        System.out.println(kunzq.isEmpty() == true);
        System.out.println(kunzq.size() == 0);
        kunzq.enqueue(1);
        kunzq.enqueue(2);
        kunzq.enqueue(3);
        System.out.println(kunzq.isEmpty() == false);
        System.out.println(kunzq.size() == 3);
        System.out.println(kunzq.dequeue());
        System.out.println(kunzq.size() == 2);
        System.out.println(kunzq.sample());
        System.out.println(kunzq.size() == 2);
        kunzq.enqueue(4);
        kunzq.enqueue(5);
        kunzq.enqueue(6);
        kunzq.enqueue(7);
        Iterator<Integer> kunzqiterator = kunzq.iterator();
        System.out.println(kunzqiterator.next());
        System.out.println(kunzqiterator.next());
        System.out.println(kunzqiterator.next());
    }
}

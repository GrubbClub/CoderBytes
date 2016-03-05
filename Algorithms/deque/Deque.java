import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
   Node first;
   Node last;
   int size;

   private class Node
   {
       Node next;
       Node prev;
       Item value;
   }
   public Deque()                           // construct an empty deque
   {
       
   }
   public boolean isEmpty()                 // is the deque empty?
   {
       return size() == 0;
   }
       
   public int size()                        // return the number of items on the deque
   {
       return size;
   }

   public void addFirst(Item item)          // add the item to the front
   {
       Node temp = new Node();
       temp.value = item;
       if (isEmpty())
       {
            first = temp;
            last = temp;
            size++;
       }
       else
       {
            first.prev = temp;
            temp.next = first;
            first = temp;
            size++;
       }

   }

   public void addLast(Item item)           // add the item to the end
   {
     Node temp = new Node();
     temp.value = item;
     if (isEmpty())
     {
       first = temp;
       last = temp;
       size++;
     }
     else
     {
       last.next = temp;
       temp.prev = last;
       last = temp;
       size++;
     }

   }
   public Item removeFirst()                // remove and return the item from the front
   {
     Item temp = first.value;
     first.next.prev = null;
     first = first.next;
     size--;
     return temp;     
   }
   public Item removeLast()                 // remove and return the item from the end
   {
     Item temp = last.value;
     last.prev.next = null;
     last = last.prev;
     size--;
     return temp;
   }
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   {       
       return new DequeIterator<Item>();
   }
   
   private class DequeIterator<Item> implements Iterator<Item>
   {
       private Node current = first;
       
       public boolean hasNext()
       {
           return current != null;
       }
       public void remove()
       {
           throw new UnsupportedOperationException("RS says fuckouttahere");
       }
       public Item next()
       {
           Item item = (Item)(current.value);
           current = current.next;
           return item;
       }
   }
   
   public static void main(String[] args)   // unit testing
   {
       Deque kunzel = new Deque();
       System.out.println(kunzel.size == 0);
       kunzel.addFirst(5);
       System.out.println(kunzel.size == 1);
       System.out.println(kunzel.last.value.equals(5));
       kunzel.addLast(6);
       System.out.println(kunzel.size == 2);
       System.out.println(kunzel.first.value.equals(5));
       System.out.println(kunzel.last.value.equals(6));
       kunzel.removeFirst();
       System.out.println(kunzel.first.value.equals(6));
       System.out.println(kunzel.size == 1);
       kunzel.addLast(7);
       kunzel.addLast(8);
       kunzel.addLast(9);
       kunzel.addFirst(5);
       System.out.println(kunzel.size == 5);
       kunzel.removeLast();
       System.out.println(kunzel.size == 4);
       Iterator<Integer> kunziterator = kunzel.iterator();
       System.out.println(kunziterator.hasNext() == true);
       while (kunziterator.hasNext())
       {
           System.out.println(kunziterator.next());
       }
   }
}
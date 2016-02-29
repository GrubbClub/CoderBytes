public class Deque<Item> implements Iterable<Item> {
   Node first;
   Node last;
   int size;
   public class Node
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
 //  public Iterator<Item> iterator()         // return an iterator over items in order from front to end

   public static void main(String[] args)   // unit testing
   {
       Deque kunzel = new Deque();
       kunzel.addFirst(5);
       kunzel.addLast(6);
       
       
   }
}
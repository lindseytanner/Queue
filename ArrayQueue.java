
/**
 * Write a description of class ArrayQueue here.
 *
 * @author Lindsey Tanner
 * @version October 13, 2021
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    private int size;
    private T[] queue;
    private int front;
    private int rear;
    
    public ArrayQueue()
    {
        queue = (T[]) new Object[1];
        size = 0;
        front = 0;
        rear = 0;
    }
    // returns the logical size of the queue
    public int size()  
    {
        return size;
    }
    // tests if this queue is empty
    public boolean empty()
    {
        return size == 0;
    }
    
    // adds an item onto the rear of this queue
    public T add(T item)
    {
        if(size == queue.length)
        enlarge();
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
        return item;
    }
        
    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek() throws QueueUnderflowException
    {
        if(empty())
        throw new QueueUnderflowException("Queue is empty!");
        return queue[front];
    }
    
    // removes the object at the front of this queue 
    // and returns that object as the value of this function
    public T remove() throws QueueUnderflowException
    {
        T removed = peek();
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return removed;
    }
    
    // removes all of the elements from this stack
    public void clear()
    {
        while(!empty())
        {
            remove();
        }
    }
    
    private void enlarge()
    {
        T[] newQueue = (T[]) new Object[queue.length + 2];
        int currSmaller = front;
        for(int currLarger = 0; currLarger < size; currLarger++)
        {
            newQueue[currLarger] = queue[currSmaller];
            currSmaller = (currSmaller + 1) % queue.length;
        }

        queue = newQueue;
        front = 0;
        rear = size - 1;
    }
    
}


/**
 * Write a description of class LinkedQueue here.
 *
 * @author Lindsey Tanner
 * @version October 14, 2021
 */
public class LinkedQueue<T> implements QueueInterface<T>
{

    private LLNode<T> front;
    private int size;
    private LLNode<T> rear;
    public LinkedQueue()
    {
        front = null;
        size = 0;
        rear = null;
    }

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

        LLNode<T> newNode = new LLNode<T>(item);
        if(rear == null)
            front = newNode;
        else
            rear.setLink(newNode);
        rear = newNode;
        size++;
        return item;
    }

    // looks at the object at the front of this queue
    // without removing it from the queue
    public T peek() throws QueueUnderflowException
    {
        if(empty())
            throw new QueueUnderflowException("Queue is empty!");
        return front.getInfo();
    }

    // removes the object at the front of this queue 
    // and returns that object as the value of this function
    public T remove() throws QueueUnderflowException
    {
        if(empty())
            throw new QueueUnderflowException("Queue is empty!");
        else
        {
            T element;
            element = front.getInfo();
            front = front.getLink();
            if(front == null)
                rear = null;
            size--;
            return element;
        }
    }
    // removes all of the elements from this stack
    public void clear()
    {
        while(!empty())
        {
            remove();
        }
    }
}

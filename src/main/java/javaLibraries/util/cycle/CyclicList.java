package javaLibraries.util.cycle;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.util.cycle.exceptions.InvalidLoopSizeException;

import java.util.ArrayList;
import java.util.List;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * A variation of a LinkedList where going out one end of the List places you at the other end
 *
 * @author Deaddorks
 * @version 1.0
 */
public class CyclicList<T> implements Cyclic<T>
{
	
	// ----- Label -----
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private Node node;
	
	private int loopSize;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Creates a CyclicList with the following items as its content.<br>
	 * It should be noted that once this CyclicList is created, it can not be changed.
	 * @param items the desired content of the CyclicList, in order
	 */
	public CyclicList(final List<T> items)
	{
		if (items == null)
		{
			throw new InvalidLoopSizeException(-1);
		}
		if (items.size() < 2)
		{
			throw new InvalidLoopSizeException(items.size());
		}
		this.loopSize = items.size();
		
		List<Node> nodes = new ArrayList<>();
		for (T item : items)
		{
			nodes.add(new Node(item));
		}
		
		Node current;
		Node prev;
		Node next;
		for (int i = 0; i < nodes.size(); i++)
		{
			current = nodes.get(i);
			prev = (i != 0) ? nodes.get(i - 1) : nodes.get(nodes.size() - 1);
			next = (i != nodes.size() - 1) ? nodes.get(i + 1) : nodes.get(0);
			
			current.next = next;
			current.prev = prev;
			
			next.prev = current;
			prev.next = current;
		}
		
		node = nodes.get(0);
	}
	
	/**
	 * Gets the current value of the List
	 *
	 * @return the current value of the List
	 */
	@Override
	public T get()
	{
		return node.item;
	}
	
	/**
	 * Sets the value to the next value in the List,<br>
	 * if you go out the end of the List, you should emerge at the beginning.
	 */
	@Override
	public void next()
	{
		node = node.next;
	}
	
	/**
	 * Sets the value to the previous value in the List,<br>
	 * if you go out the beginning of the List, you should emerge at the end.
	 */
	@Override
	public void prev()
	{
		node = node.prev;
	}
	
	/**
	 * Gets the size of loop that the List contains
	 *
	 * @return the size of loop that the List contains
	 */
	@Override
	public int getLoopSize()
	{
		return loopSize;
	}
	
	/**
	 * Holder used to encapsulate the content of the CyclicList
	 *
	 * @author Deaddorks
	 * @version 1.0
	 */
	private class Node
	{
		
		private T item;
		private Node next;
		private Node prev;
		
		/**
		 * Creates a node with the specified item and null preferences to its neighbors
		 * @param item the item value to be stored
		 */
		private Node(final T item)
		{
			this.item = item;
			next = null;
			prev = null;
		}
		
	}
	
}

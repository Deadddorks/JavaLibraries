package javaLibraries.util.cycle;

/**
 * Interface used to define a Cyclic List
 * @param <T> Type of the List
 *
 * @author Deaddorks
 * @version 1.0
 */
public interface Cyclic<T>
{
	
	/**
	 * Gets the current value of the List
	 * @return the current value of the List
	 */
	T get();
	/**
	 * Sets the value to the next value in the List,<br>
	 * if you go out the end of the List, you should emerge at the beginning.
	 */
	void next();
	/**
	 * Sets the value to the previous value in the List,<br>
	 * if you go out the beginning of the List, you should emerge at the end.
	 */
	void prev();
	
	/**
	 * Calls <strong>next()</strong> and then returns the current value
	 * @return the value of the List after <strong>next()</strong> is called
	 */
	default T getNext()
	{
		next();
		return get();
	}
	/**
	 * Calls <strong>prev()</strong> and then returns the current value
	 * @return the value of the List after <strong>prev()</strong> is called
	 */
	default T getPrev()
	{
		prev();
		return get();
	}
	
	/**
	 * Gets the size of loop that the List contains
	 * @return the size of loop that the List contains
	 */
	int getLoopSize();

}

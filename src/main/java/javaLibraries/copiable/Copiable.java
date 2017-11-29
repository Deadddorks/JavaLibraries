package javaLibraries.copiable;

/**
 * Interface which represents an idea similar to clone()
 *
 * @author Deaddorks
 * @param <T> Type of which a copy should return
 */
public interface Copiable<T>
{
	/**
	 * Should return an Object of type T which `.equals()` `this`, but `!=` `this`
	 * Any changes to anything in the returned Object should not change `this`
	 * @return a copy of `this`
	 */
	T copyOf();
}

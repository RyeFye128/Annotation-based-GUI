import java.lang.reflect.InvocationTargetException;
/*
 * Resolver class. It takes in an annotated class and passes it to a generator and binder. The generator
 * creates the empty GUI, and the binder fills that GUI with values.
 * 
 * Generator is a JFrame.
 * Binder -....
 * 
 * The exception handling isn't too advanced. I just went with the Eclipse recommendation.
 * 
 * IMPORTANT: Generator assumes you have a class AnnotatedClass, which contains the annotatons, in the
 * same directory as Resolver!!!
 */
public class Resolver {
	
	public Resolver()
	{
	
	}

	public void resolve() throws IllegalArgumentException, InvocationTargetException, ReflectiveOperationException {
	
		//Read in annotated class. Later on, we will pass via argument.
		AnnotatedClass t = new AnnotatedClass();
		Class<?> source = t.getClass();
		
		/*
		 * Create the generator. Under dev by Ryan
		 */
		Generator gen = new Generator(source);
		gen.parseAnnotations();;//Prints the annotations
		

	}
	


}

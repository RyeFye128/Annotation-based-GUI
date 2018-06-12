import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * This class holds the annotation definitions. Any file wishing to use these custom annotations
 * must extend this class.
 */
public abstract class Annotations {

	protected final static int GRIDLAYOUT = -10;

	/*
	 * We only support GridLayout currently.
	 */
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface layout
	{
		String windowTitle() default "AutoGui";
		String id() default "-1";
		int type();
		
		String widgetText() default "";
		
		//Dimension
		int range();
		int domain();
		
		int rows();
		int columns();
		
		int hGap() default 0;
		int vGap() default 0;
		
		String desc();
	}

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface label
	{
		String id();
		int width() default 0;
		int height() default 3;
		
		String widgetText() default "";
		
		//layout stuff
		int xCord();
		int yCord();
		
		String desc() default "label";
	}
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface button
	{
		String id();
		
		String widgetText() default "";
		
		//layout stuff
		int xCord();
		int yCord();
		
		String backgroundColor() default "white";
		
		String desc() default "button";
	}
	

}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

import javax.swing.*;

public class RyanBinder implements ActionListener 
{

	Method[] classMethods;
	Container container;
	Component[] widgets;
	Class<?> source;
	
	public RyanBinder(JFrame theFrame, Class<?> source) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		this.source = source;
		
		container = theFrame.getContentPane();
		widgets = container.getComponents();
		classMethods = new Method[100];
		setupListeners();
		recordMethods();
		
		
	}

	/*
	 * This method stores the annotated class' methods in an array, which their index
	 * Corresponds to their id. This will allow instant lookup.
	 */
	private void recordMethods() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		for(Method m: source.getMethods())
		{
			if(isCustomAnnotation(m.getName()))
			{
		
				classMethods[getIdValue(m.getAnnotations())] = m;
			}
			
			//if(m.anno)
			//getIdValue(m.getDeclaredAnnotations());
		}
		
		/*
		 * Array is size 100, so this loop will check all 100. So, since we do not have all 100
		 * populated, we must enforce this null check.
		 */
		for(Method m: classMethods)
		{
			if(m != null)
			{
				System.out.println(m.getName());
			}
		}
	}

	private boolean isCustomAnnotation(String name) {
		if(name.contains("button")  || name.contains("label"))
			return true;
		return false;
	}

	private void setupListeners() {
		// TODO Auto-generated method stub
		for (Component comp : widgets)
		{
			if (comp instanceof JButton)
			{
				((JButton) comp).addActionListener(this);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		Component widget = (Component) e.getSource();
		String widgetId = widget.getName();
		//widgetId = widgetId.substring(widgetId.length() - 2);
		int idAsInt = Integer.parseInt(widgetId);
		
		//The class has to create a new instance, so instead of hardcoding it to always say AnnotatedClass,
		//instead it now works with any mother file name.
	
			try {
				classMethods[idAsInt].invoke(source.newInstance(), new Object[] {});
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//TODO find out how to use parameters.
	

	}
	/*
	 * Similar to the one use din Generator, but works on just the default list obtained from the
	 * reflection on the annotations. It gets the id of each annotation that annotates a method. This id
	 * will serve as the index for the method when it is stored.
	 */
	private int getIdValue(Annotation[] annotations) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Object value;
		Class temp;
		int index = -1;
		// TODO Auto-generated method stub
		for (Annotation aa : annotations)
		{
			temp = ((Annotation) aa).annotationType();
			for (Method met : temp.getDeclaredMethods())
			{
				value = met.invoke(aa, (Object[]) null);
				if(met.getName().equals("id"))
				{
					index = Integer.parseInt(value.toString());
					System.out.println(index);
				}
			}
			return index;
			
		}
		return -1;
	}
}

import javax.swing.*;
import javax.xml.transform.Source;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
@SuppressWarnings("unused")
public class ViewFactory {
	public void Create(){
		View v = new View(); 
	}

	public ViewFactory(){
		
	}
	public ViewFactory(Class<?> source) {
		// TODO Auto-generated constructor stub
		ViewFactory vf = new ViewFactory();
		
		
		ViewAdapter va = new ViewAdapter();
		ViewBuilder vb = new ViewBuilder();
		
		vSource = source.getClass();
		vf.Create();
	}	
	private Class<?> vSource;
}

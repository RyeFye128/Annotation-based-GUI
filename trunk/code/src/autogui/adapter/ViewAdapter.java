package autogui.adapter;

import autogui.binding.*;

import java.awt.Container;
import java.util.List;

public class ViewAdapter{
	
	private List<AbstractBindingStep> Steps;
	public ViewAdapter(List<AbstractBindingStep> steps){
		Steps = steps;
	}
	public void Bind(Container view, Object object) throws IllegalAccessException{
		for (AbstractBindingStep step : Steps)
		{
			AbstractBinding.create(view, object, step);
		}
	}
	
}

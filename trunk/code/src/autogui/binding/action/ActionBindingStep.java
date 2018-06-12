package autogui.binding.action;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.function.BiConsumer;

import autogui.binding.AbstractBindingStep;
import autogui.binding.BindingMode;
import autogui.binding.ListeningType;

public class ActionBindingStep extends AbstractBindingStep {
	public final BiConsumer<Container, ActionListener> AddListenerFunction;
	public final Method ActionMethod;
	
	public ActionBindingStep(String elementId, BindingMode mode, Method actionMethod,
			BiConsumer<Container, ActionListener> addListenerFunction) {
		super(elementId, mode);
		assert actionMethod != null : "Action Method is null";
		assert addListenerFunction != null : "Add listener function is null";
		ActionMethod = actionMethod;
		AddListenerFunction = addListenerFunction;
	}

	@Override
	public ListeningType getType() {
		return ListeningType.Action;
	}

}

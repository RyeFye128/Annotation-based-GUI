package autogui.binding.action;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import autogui.binding.AbstractBinding;
import autogui.binding.ListeningType;

public class ActionBinding extends AbstractBinding implements ActionListener {
	protected ActionBindingStep Invoker;

	public ActionBinding(Container view, Object object, ActionBindingStep invoker) throws IllegalArgumentException {
		super(view, object);
		
		if (invoker.getType() != ListeningType.Action)
			throw new IllegalArgumentException("Invalid mode specified for property binding");
		
		Invoker = invoker;
		addViewListener();
	}

	@Override
	protected void addViewListener() {
		Container view = ViewRef.get();
		if (view != null)
			Invoker.AddListenerFunction.accept(view, this);
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		assert Invoker.ActionMethod != null && Invoker.ActionMethod.getParameterCount() > 1 : "Invalid Set Method";

		Object obj = ObjectRef.get();
		// can be null if garbage collected
		if (obj == null)
			return;

		try {
			// if method accepts parameter, pass along the event
			if (Invoker.ActionMethod.getParameterCount() == 1)
				Invoker.ActionMethod.invoke(obj, arg);
			else
				Invoker.ActionMethod.invoke(obj);
		} catch (InvocationTargetException e) {
		} catch (IllegalAccessException e) {
		}
	}
}

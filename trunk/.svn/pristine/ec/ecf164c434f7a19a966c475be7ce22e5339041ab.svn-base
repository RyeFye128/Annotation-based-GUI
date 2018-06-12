package autogui.binding.property;

import java.awt.Container;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

/**
 * Binding for view objects which support include text
 * 
 * @author Shane
 *
 */
public class InputMethodPropertyBinding extends AbstractPropertyBinding implements InputMethodListener {

	public InputMethodPropertyBinding(Container view, Object object, InputMethodPropertyBindingStep invoker)
			throws IllegalAccessException {
		super(view, object, invoker);
	}

	@Override
	protected void addViewListener() {
		Container view = ViewRef.get();
		if (view != null)
			((InputMethodPropertyBindingStep) Invoker).AddListenerFunction.accept(view, this);
	}

	@Override
	public void caretPositionChanged(InputMethodEvent arg) {
		assert Invoker.SetMethod != null && Invoker.SetMethod.getParameterCount() != 1 : "Invalid Set Method";
		assert Invoker.GetAction != null : "Invalid Get Action";

		saveObjectValue();
	}

	@Override
	public void inputMethodTextChanged(InputMethodEvent arg) {
		assert Invoker.SetMethod != null && Invoker.SetMethod.getParameterCount() != 1 : "Invalid Set Method";
		assert Invoker.GetAction != null : "Invalid Get Action";

		saveObjectValue();
	}

}
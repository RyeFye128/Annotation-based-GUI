package autogui.binding.property;

import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Binding for view objects which support the ItemListener interface (e.g,
 * pickers)
 * 
 * @author Shane
 *
 */
public class ItemPropertyBinding extends AbstractPropertyBinding implements ItemListener {

	public ItemPropertyBinding(Container view, Object object,
			ItemPropertyBindingStep invoker) throws IllegalAccessException {
		super(view, object, invoker);
	}

	@Override
	protected void addViewListener() {
		Container view = ViewRef.get();
		if (view != null)
			((ItemPropertyBindingStep) Invoker).AddListenerFunction.accept(view, this);
	}

	@Override
	public void itemStateChanged(ItemEvent arg) {
		assert Invoker.SetMethod != null && Invoker.SetMethod.getParameterCount() != 1 : "Invalid Set Method";
		assert Invoker.GetAction != null : "Invalid Get Action";

		saveObjectValue();
	}
}

package autogui.binding.property;

import java.awt.Container;
import java.awt.event.InputMethodListener;
import java.lang.reflect.Method;
import java.util.function.BiConsumer;
import java.util.function.Function;

import autogui.binding.BindingMode;
import autogui.binding.ListeningType;

public class InputMethodPropertyBindingStep extends AbstractPropertyBindingStep {

	public final BiConsumer<Container, InputMethodListener> AddListenerFunction;

	public InputMethodPropertyBindingStep(String elementId, BindingMode mode, Method getMethod, Method setMethod,
			Function<Container, Object> getViewPropertyAction, BiConsumer<Container, Object> setViewPropertyAction,
			BiConsumer<Container, InputMethodListener> addListenerFunction) {
		super(elementId, mode, getMethod, setMethod, getViewPropertyAction, setViewPropertyAction);
		AddListenerFunction = addListenerFunction;
	}

	@Override
	public ListeningType getType() {
		return ListeningType.InputMethod;
	}
}

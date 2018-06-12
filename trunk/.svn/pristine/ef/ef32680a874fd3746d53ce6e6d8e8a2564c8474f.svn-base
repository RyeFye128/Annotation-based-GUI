package autogui.binding.property;

import java.awt.Container;
import java.lang.reflect.Method;
import java.util.function.BiConsumer;
import java.util.function.Function;

import javax.swing.event.ChangeListener;

import autogui.binding.BindingMode;
import autogui.binding.ListeningType;

public class ChangePropertyBindingStep extends AbstractPropertyBindingStep {
	public final BiConsumer<Container, ChangeListener> AddListenerFunction;

	public ChangePropertyBindingStep(String elementId, BindingMode mode, Method getMethod, Method setMethod,
			Function<Container, Object> getViewPropertyAction, BiConsumer<Container, Object> setViewPropertyAction,
			BiConsumer<Container, ChangeListener> addListenerFunction) {
		super(elementId, mode, getMethod, setMethod, getViewPropertyAction, setViewPropertyAction);
		AddListenerFunction = addListenerFunction;
	}

	@Override
	public ListeningType getType() {
		return ListeningType.Change;
	}

}

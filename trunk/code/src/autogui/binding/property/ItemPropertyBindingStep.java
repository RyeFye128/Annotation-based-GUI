package autogui.binding.property;

import java.awt.Container;
import java.awt.event.ItemListener;
import java.lang.reflect.Method;
import java.util.function.BiConsumer;
import java.util.function.Function;

import autogui.binding.BindingMode;
import autogui.binding.ListeningType;

public class ItemPropertyBindingStep extends AbstractPropertyBindingStep {

	public final BiConsumer<Container, ItemListener> AddListenerFunction;

	public ItemPropertyBindingStep(String elementId, BindingMode mode, Method getMethod, Method setMethod,
			Function<Container, Object> getViewPropertyAction, BiConsumer<Container, Object> setViewPropertyAction,
			BiConsumer<Container, ItemListener> addListenerFunction) {
		super(elementId, mode, getMethod, setMethod, getViewPropertyAction, setViewPropertyAction);
		AddListenerFunction = addListenerFunction;
	}

	@Override
	public ListeningType getType() {
		return ListeningType.Item;
	}
}

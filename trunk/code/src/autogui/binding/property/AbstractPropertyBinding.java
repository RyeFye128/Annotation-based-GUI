package autogui.binding.property;

import java.awt.Container;
import java.lang.reflect.InvocationTargetException;

import autogui.binding.AbstractBinding;

import java.util.Observer;
import java.util.Observable;

/**
 * Base Class for all Property-Based Binding (i.e., bindings to getters and
 * setters)
 * 
 * @author Shane
 *
 */
public abstract class AbstractPropertyBinding extends AbstractBinding implements Observer {

	protected AbstractPropertyBindingStep Invoker;

	public AbstractPropertyBinding(Container view, Object object, AbstractPropertyBindingStep invoker)
			throws IllegalAccessException {
		super(view, object);

		if (invoker == null)
			throw new IllegalArgumentException("Must provide binding step");
		Invoker = invoker;

		switch (invoker.Mode) {
		case OneTime:
			retrieveObjectValue();
			break;
		case OneWay:
			retrieveObjectValue();
			addObjectListener();
			break;
		case OneWayToSource:
			addViewListener();
			break;
		case TwoWay:
			addViewListener();
			addObjectListener();
			break;
		default:
			throw new IllegalArgumentException("Invalid mode specified for property binding");
		}
	}

	protected abstract void addViewListener();

	protected void addObjectListener() {

		Object obj = ObjectRef.get();
		// can be null if garbage collected
		if (obj != null && obj instanceof Observable)
			((Observable) obj).addObserver(this);

	}

	public void update(Observable obs, Object obj) {
		try {
			retrieveObjectValue();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	protected void saveObjectValue() {
		assert Invoker.SetMethod != null && Invoker.SetMethod.getParameterCount() != 1 : "Invalid Set Method";
		assert Invoker.GetAction != null : "Invalid Get Action";

		Object obj = ObjectRef.get();
		Container view = ViewRef.get();
		// can be null if garbage collected
		if (obj == null || view == null)
			return;

		try {
			Object arg = Invoker.GetAction.apply(view);
			Invoker.SetMethod.invoke(obj, arg);
		} catch (InvocationTargetException e) {
		} catch (IllegalAccessException e) {
		}
	}

	public void retrieveObjectValue() throws IllegalAccessException {
		assert Invoker.GetMethod != null && Invoker.GetMethod.getParameterCount() == 0 : "Invalid Get Method";
		assert Invoker.SetAction != null : "Invalid Set Action";

		Object obj = ObjectRef.get();
		Container view = ViewRef.get();
		// can be null if garbage collected
		if (obj == null || view == null)
			return;

		try {
			Object arg = Invoker.GetMethod.invoke(obj);
			Invoker.SetAction.accept(view, arg);
		} catch (InvocationTargetException e) {
		} catch (IllegalAccessException e) {
			throw e;
		}
	}
}

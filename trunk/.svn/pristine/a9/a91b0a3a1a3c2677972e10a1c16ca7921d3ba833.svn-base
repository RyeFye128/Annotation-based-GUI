import java.lang.reflect.InvocationTargetException;

import autogui.binding.*;
import autogui.binding.property.*;
import autogui.binding.action.*;

import java.lang.reflect.*;
import java.util.Observable;
import java.awt.*;

import javax.swing.*;

import org.junit.*;

/*
 * Test cases for the AutoGui system. Combines both black box and white box methods. Coverage is determined
 * using Jacoco on the Jenkins server. Unit tests are done via JUnit.
 */

public class TestCases {

	private AbstractBindingStep OneTimeLabelBindingStep = new InputMethodPropertyBindingStep("TestId_001",
			BindingMode.OneTime, GetGetValueMethod(), GetSetValueMethod(),
			(view) -> ((JLabel) view).getText(),
			(view, arg) -> ((JLabel) view).setText((String) arg),
			(view, listener) -> ((JLabel) view).addInputMethodListener(listener));
	
	private AbstractBindingStep OneWayLabelBindingStep = new InputMethodPropertyBindingStep("TestId_002",
			BindingMode.OneWay, GetGetValueMethod(), GetSetValueMethod(),
			(view) -> ((JLabel) view).getText(),
			(view, arg) -> ((JLabel) view).setText((String) arg),
			(view, listener) -> ((JLabel) view).addInputMethodListener(listener));
	

	private AbstractBindingStep ButtonBindingStep = new ActionBindingStep("TestId_003",
			BindingMode.Command, GetActionMethod(), 
			(view, listener) -> ((JButton) view).addActionListener(listener));

	JLabel label;
	JButton button;
	TestClass object;

	@Before
	public void setUp() {
		label = new JLabel();
		button = new JButton();
		object = new TestClass();
	}

	@Test
	public void testOneTimeBinding() throws IllegalAccessException {
		object.setValue("InitialValue");
		AbstractBinding binding = AbstractBinding.create(label, object, OneTimeLabelBindingStep);
		Assert.assertEquals("one-time binding failed", object.getValue(), label.getText());
	}

	@Test
	public void testOneWayBinding() throws IllegalAccessException {
		object.setValue("InitialValue");
		AbstractBinding binding = AbstractBinding.create(label, object, OneWayLabelBindingStep);
		Assert.assertEquals("one-way binding failed", object.getValue(), label.getText());
		object.setValue("SecondaryValue");
		Assert.assertEquals("one-way binding failed", object.getValue(), label.getText());
	}

	@Test
	public void testActionBinding() throws IllegalAccessException {
		AbstractBinding binding = AbstractBinding.create(button, object, ButtonBindingStep);
		button.doClick();
		Assert.assertEquals("one-time binding failed", "Action", object.getValue());
	}

	@Test
	public void testMultiBinding() throws IllegalAccessException {
		AbstractBinding.create(label, object, OneWayLabelBindingStep);
		AbstractBinding.create(button, object, ButtonBindingStep);
		button.doClick();
		Assert.assertEquals("one-time binding failed", "Action", label.getText());
	}

	public class TestClass extends Observable {
		private String value = "";
		
		public void action()
		{
			setValue("Action");
		}

		public String getValue() {
			return value;
		}

		public void setValue(String str) {
			value = str;
			setChanged();
			notifyObservers();
		}
	}


	public static Method GetActionMethod() {
		try {

			return TestClass.class.getMethod("action");
		} catch (NoSuchMethodException c) {
			return null;
		}
	}

	public static Method GetGetValueMethod() {
		try {

			return TestClass.class.getMethod("getValue");
		} catch (NoSuchMethodException c) {
			return null;
		}
	}

	public static Method GetSetValueMethod() {
		try {
			return TestClass.class.getMethod("setValue", String.class);
		} catch (NoSuchMethodException c) {
			return null;
		}
	}
}


package autogui.binding;

public abstract class AbstractBindingStep {

	public final String ElementId;
	public final BindingMode Mode;
	
	public AbstractBindingStep(String elementId, BindingMode mode)
	{
		ElementId = elementId;
		Mode = mode;
	}
	
	public abstract ListeningType getType();
}

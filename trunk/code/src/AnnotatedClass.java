import javax.swing.JOptionPane;

/*
 * This is the test class being used for reading in annotations.
 * 
 * The user must create a method called layout and annotate with with layout. This ensures that the JFrame
 * can read the layout information.
 * 
 * This class will create a calculator
 */

public class AnnotatedClass extends Annotations
{

	@layout(columns = 4, rows = 6, desc = "GridLayout", type = GRIDLAYOUT, domain = 300, range = 450,
			vGap = 3, hGap = 2, windowTitle = "Calculator", id = "0")
	public static void layout()
	{

	}

	@button(id = "1", xCord = 0, yCord = 0, widgetText = "%")
	public void button1()
	{

	}

	@button(id = "2", xCord = 0, yCord = 0, widgetText = "Sqrt")
	public void button2()
	{

	}

	@button(id = "3", xCord = 0, yCord = 0, widgetText = "Sq")
	public void button3()
	{
		JOptionPane.showMessageDialog(null, "From the class!");
	}

	@button(id = "4", xCord = 0, yCord = 0, widgetText = "Inv")
	public void button4()
	{

	}

	@button(id = "5", xCord = 0, yCord = 0, widgetText = "CE")
	public void button5()
	{

	}

	@button(id = "6", xCord = 0, yCord = 0, widgetText = "C")
	public void button6()
	{

	}

	@button(id = "7", xCord = 0, yCord = 0, widgetText = "DEL")
	public void button7()
	{

	}

	@button(id = "8", xCord = 0, yCord = 0, widgetText = "/")
	public void button8()
	{

	}

	@button(id = "9", xCord = 0, yCord = 0, widgetText = "7")
	public void button9()
	{

	}

	@button(id = "10", xCord = 0, yCord = 0, widgetText = "8")
	public void button10()
	{

	}

	@button(id = "11", xCord = 0, yCord = 0, widgetText = "9")
	public void button11()
	{

	}

	@button(id = "12", xCord = 0, yCord = 0, widgetText = "X")
	public void button12()
	{

	}

	@button(id = "13", xCord = 0, yCord = 0, widgetText = "4")
	public void button13()
	{

	}

	@button(id = "14", xCord = 0, yCord = 0, widgetText = "5")
	public void button14()
	{

	}

	@button(id = "15", xCord = 0, yCord = 0, widgetText = "6")
	public void button15()
	{

	}

	@button(id = "16", xCord = 0, yCord = 0, widgetText = "-")
	public void button16()
	{

	}

	@button(id = "17", xCord = 0, yCord = 0, widgetText = "1")
	public void button17()
	{

	}

	@button(id = "18", xCord = 0, yCord = 0, widgetText = "2")
	public void button18()
	{

	}
	
	@button(id = "19", xCord = 0, yCord = 0, widgetText = "3")
	public void button19()
	{

	}

	@button(id = "20", xCord = 0, yCord = 0, widgetText = "+")
	public void button20()
	{

	}

	@label(id = "21", xCord = 0, yCord = 0, widgetText = "")
	public void label21()
	{

	}

	@button(id = "22", xCord = 0, yCord = 0, widgetText = "0")
	public void button22()
	{

	}

	@button(id = "23", xCord = 0, yCord = 0, widgetText = ".")
	public void button23()
	{

	}

	@button(id = "24", xCord = 0, yCord = 0, widgetText = "=")
	public void button24()
	{

	}

	/*
	 * @button(xCord = 0, yCord = 0, id = 3) public static void button() {
	 * //what does a button do? }
	 */
}

import javax.swing.*;
import java.util.function.Function;
                             

public class level {
	private int lvl;
	private float target;
	public int disableKeys[];
	private Function <Float, Float> omega;
	private Function <Float, Float> theta1;
	private Function <Float, Float> theta2;
	public level(int lvl, float target, int[] dis, Function <Float, Float> o) {
		this.lvl = lvl;
		this.target = target;
		disableKeys = dis;
		omega = o;
	}
	
	public level(int lvl, float target, int[] dis, Function <Float, Float> t1,Function <Float, Float> t2) {
		this.lvl = lvl;
		this.target = target;
		disableKeys = dis;
		theta1 = t1;
		theta2 = t2;
	}
	
	public float solve(String[] val, int index) {

		if(val[index].equals("Ω")) {
			return omega.apply(this.solve(val, index +1));
		} else {
			return Float.parseFloat(val[index]);
		}
		
	}
	
	
	
}

import javax.swing.*;
import java.util.function.Function;
                             


public class level {
	private int lvl;
	private String name;
	private float target;
	private int disableKeys[];
	private Function <Float, Float> omega;
	private Function <Float, Float> theta1;
	private Function <Float, Float> theta2;
	public level(int lvl, float target, int[] dis, Function <Float, Float> o, Function <Float,Float> t) {
		this.lvl = lvl;
		name = "Level " + String.valueOf(lvl);
		this.target = target;
		disableKeys = dis;
		omega = o;
	}
	public float solve(float val) {
		return omega.apply(val);
	}
	
}

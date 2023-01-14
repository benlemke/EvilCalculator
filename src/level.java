import javax.swing.*;
import java.util.function.Function;
                             

public class level {
	public int lvl;
	public float target;
	public int disableKeys[];
	private Function <Float, Float> omega;
	private Function <Float, Float> theta1;
	private Function <Float, Float> theta2;
	public level() {
		
	}
	public level(int lvl, float target, int[] dis, Function <Float, Float> o) {
		this.lvl = lvl;
		this.target = target;
		disableKeys = dis;
		omega = o;
	}
	
	public level(int lvl, float target, int[] dis, Function <Float, Float> t1,Function <Float, Float> t2) {
		this.lvl = lvl;
		this.target = target;
		this.disableKeys = dis;
		theta1 = t1;
		theta2 = t2;
		
	}
	
	public String solve(String[] val, int index) {

		if(val[index].equals("Ω")) {
			return String.valueOf(omega.apply(Float.parseFloat(solve(val, index +1))));
		} else if(val[index].equals("-Ω")) {
			return String.valueOf(omega.apply(Float.parseFloat(solve(val, index +1))* -1));
		} else {
			return val[index];
		}
		
	}
	
}

class NAlevel extends level {
	private Function <String, String> stringOmega;
	public NAlevel(int lvl, float target, int[] dis, Function <String, String> so) {
		this.lvl = lvl;
		this.target = target;
		disableKeys = dis;
		stringOmega = so;
	}
	
	@Override public String solve(String[] val, int index) {
		if(val[index].equals("Ω")) {
			return stringOmega.apply(solve(val, index +1));
		} else if(val[index].equals("-Ω")) {
			return "-" + stringOmega.apply(solve(val, index +1));
		} else {
			return val[index];
		}
		
	}
}








































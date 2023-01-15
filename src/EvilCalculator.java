import java.awt.Desktop;
import java.net.URI;
import java.util.List;
import java.util.ArrayList;
class entry {
	public float x;
	public float y;
	public entry(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
public class EvilCalculator {
	public static int currentLevel = 5;
	private static level levels[] = new level[100];
	public List<entry>  wolframHistory = new ArrayList<>();
	public String compute(String input) {
		String[] parse = input.split("(?<=Ω)");

		return levels[currentLevel].solve(parse, 0);
	}
	
	public float getX(String input) {
		String[] parse = input.split("(?<=Ω)");
		float result = 0;
		for(int i = 0; i < parse.length; i++)
			if(!(parse[i].equals("-Ω") || parse[i].equals("Ω"))) 
				result = Float.parseFloat(parse[i]);
		return result;
	}
	
	public level returnLvl(String l) {
		currentLevel = Integer.valueOf(l);
		return levels[Integer.valueOf(l)];
	}
	
	public level nextLvl() {
		wolframHistory.clear();
		currentLevel++;
		return levels[currentLevel];
	}
	
	public float returnTar() {
		return levels[currentLevel].target;
	}
	
	public int addHistory(float x, float y) {
		wolframHistory.add(new entry(x,y));
		return wolframHistory.size();
	}
	
	public void openWolfram() {
		String url = "https://www.wolframalpha.com/input?i=";
		for(int i = 0; i < wolframHistory.size(); i++) {
			url += "%7B";
			url += wolframHistory.get(i).x;
			url += "%2C";
			url += wolframHistory.get(i).y;
			url += "%7D";
			url += "%2C";
		}
		try {
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  
			  URI oURL = new URI(url);
			  desktop.browse(oURL);
			} catch (Exception e) {
			  e.printStackTrace();
			}	
	}
	
	public static void main(String[] args) {
		gui game = new gui();
		
		//all levels and their functions are here. no cheating >:(
		levels[1] = new level(1,50,new int[]{11},(a) -> a+6);
		levels[2] = new level(2,30,new int[]{11},(a) -> (a * 2)+9);
		levels[3] = new level(3,15,new int[]{11,7},(a) -> a - 22);
		levels[4] = new level(4,123,new int[]{11,12},(a) -> a * -10);
		levels[5] = new level(5,60,new int[]{2,11},(a) -> {
			if(a % 2 == 1) return a*3;
			else return a-12;
		});
		levels[6] = new level(6,87,new int[]{2,3,4,5,6,7,8,9,11,13},(a) -> {
				int bin = 1;
				int intA = (int) Math.abs(a);
				int result = 0;
				while (intA != 0) {
					if(intA % 10 == 1) result += (bin);
					bin*=2;
					intA /= 10;
				}
				if(a < 0) intA *= -1;
				return (float) result;
			}
		);
		
		game.setLevel(levels[currentLevel]);
		
		
		
		
	}
}

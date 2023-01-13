

public class EvilCalculator {
	public static int currentLevel = 1;
	private static level levels[] = new level[100];
	public int s = 1;
	public float compute(String input) {
		//System.out.println(input);
		
		String[] parse = input.split("(?<=Ω)");
		//(?<=-Ω)|(?=-Ω)|(?=Ω)|(?<=Ω)
		//[0-9]|Ω (?<=-Ω)
		for(int i = 0; i < parse.length; i++) System.out.print(parse[i] + " ");
		System.out.println(" ");
		return levels[currentLevel].solve(parse, 0);
	}
	
	public level returnLvl(String l) {
		return levels[Integer.valueOf(l)];
	}
	
	public level returnLvl() {
		return levels[currentLevel];
	}
	
	public float returnTar() {
		return levels[currentLevel].target;
	}
	public static void main(String[] args) {
		gui game = new gui();
		
		//levels[1] = new level(1,3,new int[]{11},(a) -> (a * 3)+4);
		
		levels[1] = new level(1,50,new int[]{11},(a) -> a+6);
		levels[2] = new level(2,30,new int[]{11},(a) -> (a * 2)+9);
		//gui.
		//System.out.println(d1.solve(2));
		game.setLevel(levels[currentLevel]);
		
		
		
		
	}
}



public class EvilCalculator {
	public static int currentLevel = 1;
	private static level levels[] = new level[100];
	public int s = 1;
	
	public float compute(String input) {
		//System.out.println(input);
		
		String[] result = input.split("((?<=-Ω)|(?=Ω)|(?<=Ω))");
		//(?<=-Ω)|(?=-Ω)|(?=Ω)|(?<=Ω)
		//[0-9]|Ω
		System.out.println(result[0]);
		System.out.println(result[1]);
		return levels[currentLevel].solve(result, 0);
	}
	

	public void start() {
		
	}
	public static void main(String[] args) {
		gui gui = new gui();
		//level d1 = new level(1,3,keys,(a) -> (a * 3)+4);
		//levels[1] = d1;
		//level levels[] = new level[100];
		levels[1] = new level(1,3,new int[]{11},(a) -> (a * 3)+4);
		//gui.
		//System.out.println(d1.solve(2));
		gui.setLevel(levels[currentLevel]);
		
		
		
		
	}
}

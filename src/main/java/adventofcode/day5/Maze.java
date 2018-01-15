package adventofcode.day5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Maze {

	public int numberOfSteps(List<Integer> instructions) {
		int steps = 0;
		int next = 0;
		int exit = instructions.size();

		while (next < exit) {
			int value = instructions.get(next);
			int previous = next;

			next = value + next;
			instructions.set(previous, ++value);

			steps++;
		}

		return steps;
	}

	public static void main(String[] args) {
		Maze m = new Maze();
		
		int steps = m.numberOfSteps(Arrays.asList(0, 3, 0, 1, -3));
		
		if (steps != 5) {
			System.out.println("Expected: 5. Result: " + steps + ". Aborting...");
			return;
		}

		InputStream is = Maze.class.getClassLoader().getResourceAsStream("day5/input");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		List<Integer> input = reader.lines().map(Integer::parseInt).collect(Collectors.toList());
		
		System.out.println(m.numberOfSteps(input));

		
	}

}

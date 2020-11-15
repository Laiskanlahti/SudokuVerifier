import java.util.ArrayList;
import java.util.List;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
//		return 0;
//		
		//check
		

//		A valid Sudoku solution should conform to the following rules:
//			R1: A cell in a Sudoku game can only store positive digits, i.e. 1...9.
//			R2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
//			R3: A digit can appear only once in the rows of the global grid.
//			R4: A digit can appear only once in the columns of the global grid.
		
		List<String> rows = new ArrayList<String>();
		List<String> columns = new ArrayList<String>();
		List<String> cells = new ArrayList<String>();
		if (candidateSolution.matches("^[1-9]+$") && candidateSolution.length() == 81) {
			for(int i=0;i<=8;i++) {
				rows.add(candidateSolution.substring(9*i, 9*i+9));
			}
			System.out.println("rows:"+rows);
			for(int i=0;i<=8;i++) {
				String column = "";
				for (String row : rows) {
					column = column+(Character.toString(row.charAt(i)));
				}
				columns.add(column);
			}
			System.out.println("columns:"+columns);
            for (int k=0;k<=2;k++) {
				for(int i=0;i<=2;i++) {
		            String cell = "";
			            for (int j=0;j<=2;j++) {
			                    cell = cell + candidateSolution.substring((i*3)+(j*9)+k*27, (i*3)+(j*9)+k*27+3);
			            }
			            cells.add(cell);
		            }
			}
			System.out.println("cells:"+cells);
			for (String row : rows) {
				if (isValidNumberGroup(row)==false) {
					return -3;
				}
			
			}
			for (String column : columns) {
				if (isValidNumberGroup(column)==false) {
					return -4;
				}
			}
			for (String cell : cells) {
				if (isValidNumberGroup(cell)==false) {
					return -2;
				}
			}
		}
		else {
			System.out.println("Not valid candidate");
			return -1;
		}
		return 0;
	}
	private boolean isValidNumberGroup(String listOfNumbers) {
		List<String> copy = new ArrayList<String>();
		for(int i=0;i<=8;i++) {
			if (copy.contains(Character.toString(listOfNumbers.charAt(i)))) {
				return false;
			}
			copy.add(Character.toString(listOfNumbers.charAt(i)));
		}
		return true;
	}
}

//417369825632158947958724316825437169791586432346912758289643571573291684164875293
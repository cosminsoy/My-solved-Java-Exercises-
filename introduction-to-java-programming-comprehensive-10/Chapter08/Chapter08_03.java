 
/** (Sort students on grades) Rewrite Listing 8.2, GradeExam.java, to display the
  * students in increasing order of the number of correct answers.
  */

public class GradeExam {
	/** Main method */
	public static void main(String[] args) {
		// Students' answers to the questions
		char[][] answers = {
				{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
				{'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
				{'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
				{'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

		// Key to the questions
		char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

		int[][] sudentsIDAndGrades = getSudentsIDAndGrades(answers, keys);

		sortStudentsIncreasingGradeOrder(sudentsIDAndGrades);

		for (int listGradeIncreasingOrder = 0; listGradeIncreasingOrder < sudentsIDAndGrades.length; listGradeIncreasingOrder++) {

			System.out.println( "Grade: " + sudentsIDAndGrades[listGradeIncreasingOrder][1]
						+ "  Student: " + ( sudentsIDAndGrades[listGradeIncreasingOrder][0] + 1 ) );
		}

	}

	public static int[][] getSudentsIDAndGrades(char[][] s, char[] k) {
		// Student's ID
		int[][] students = new int[s.length][2]; // student[i][{student number, grade}]
 
		// Grade all answers
		for (int i = 0; i < s.length; i++) {
			// Grade one student
			int correctCount = 0;
			for (int j = 0; j < s[i].length; j++) {
				if (s[i][j] == k[j])
				correctCount++;
			}
			students[i][0] = i;  // add student number
			students[i][1] = correctCount;  // add student grade
		}
		return students;
	}

	/** The method for sorting the numbers */ 
	public static void sortStudentsIncreasingGradeOrder(int[][] list) {
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int[][] currentMin = new int[1][2];
			        currentMin[0][1] = list[i][1];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (currentMin[0][1] > list[j][1]) {
					currentMin[0][0] = list[j][0];
					currentMin[0][1] = list[j][1];
					currentMinIndex = j;
				}
			}

			// Swap list[i] with list[currentMinIndex] if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex][0] = list[i][0];
				list[currentMinIndex][1] = list[i][1];

				list[i][0] = currentMin[0][0];
				list[i][1] = currentMin[0][1];
			}
		}
	} 
}

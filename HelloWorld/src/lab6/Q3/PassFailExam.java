package lab6.Q3;


/**
 * This class determines a passing or failing grade for an exam.
 */

public class PassFailExam extends FinalExam {
	private double minPassing;

	/**
	 * The constructor sets the number of questions, the number of questions
	 * missed, and the minimum passing score.
	 * 
	 * @param minPassing
	 *            The minimum passing score.
	 */
	public PassFailExam(int questions, int missed, double minPassing) {
		// Call the superclass constructor.
		super(questions, missed);

		this.minPassing = minPassing;

	}

	/**
	 * The getGrade method returns a letter grade determined from the score
	 * field. This method overrides the superclass method.
	 * 
	 * @return The letter grade.
	 */
	public char getGrade() {
		char letterGrade;

		if (super.getScore() >= minPassing)
			letterGrade = 'P';
		else
			letterGrade = 'F';

		return letterGrade;
	}
}
/**
 * 
 */
package poo.appello3;

/**
 * @author pasquale
 * 
 */
public enum TaglioMoneta {

	ONE_CENT(0.01), TWO_CENT(0.02), FIVE_CENT(0.05), TEN_CENT(0.10), TWENTY_CENT(
			0.20), FIFTY_CENT(0.50), ONE_EURO(1.00), TWO_EURO(2.00), FIVE_EURO(
			5.00), TEN_EURO(10.00), TWENTY_EURO(20.00), FIFTY_EURO(50.00), ONE_UNDRED(
			100.00), TWO_UNDRED(200.00), FIVE_UNDRED(500.00);

	private double val;

	private TaglioMoneta(double val) {
		this.val = val;
	}

	public double getVal() {
		return this.val;
	}

	public static boolean valida(double valore) {
		for (TaglioMoneta taglio : TaglioMoneta.values()) {
			if (taglio.getVal() == valore)
				return true;
		}
		return false;
	}
}

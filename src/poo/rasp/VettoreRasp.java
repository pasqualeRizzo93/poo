package poo.rasp;

public class VettoreRasp {
	public static void main(String[] args) {
		int x = 0;
		int[] v = new int[10];
		for (int i = 0; i < v.length - 1; i++) {
			if (v[i] > v[i + 1])
				break;
		}
		int inf = 0, sup = v.length - 1;
		while (inf <= sup) {
			int med = (inf + sup) / 2;
			if (v[med] == x)
				System.out.println(med);
			if (v[med] > x) {
				sup = med - 1;
			} else {
				inf = med + 1;
			}
		}

	}
}

public class ArrOperation {

	private int array[];

	ArrOperation(int a[]) {
		this.array = a;
	}

	/**
	 * Calculate presence of Mirror of any part of array in array
	 * @return - Total number of mirror part present;
	 */
	public int maxMirror() {
		assert array.length > 0 : "Array is Empty";
		int temp[] = new int[array.length];
		int i, j, max = 0, cnt, x, y;
		int n = array.length - 1;
		for (int k = 0; k < array.length; k++) {
			temp[k] = array[n - k];
		}
		for (i = 0; i < array.length; i++) {
			for (j = 0; j < array.length; j++) {
				cnt = 0;
				x = i;
				y = j;
				while (x < array.length && y < array.length
						&& array[x] == temp[y]) {
					cnt++;
					x++;
					y++;
				}
				if (max < cnt)
					max = cnt;
			}
		}
		return max;
	}

	/**
	 * Find the Index where the array can split in two part.
	 * @return - Index where array can spilt in Two.
	 */
	public int splitArray() {
		assert array.length > 0 : "Array is Empty";
		int total = 0;
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (count == total) {
				return i;
			} else if (count > total) {
				return -1;
			}
			count += array[i];
			total -= array[i];
		}
		return index;
	}

	/**
	 * Count adjacent Elements Occurrence if more than 2
	 * @return - count of clumps
	 */
	public int countClumps() {
		assert array.length > 0 : "Array is Empty";
		int count = 0;
		for (int i = 0; i < array.length;) {
			int temp = 0;
			int j = i;
			while (j < array.length && array[i] == array[j]) {
				temp++;
				j++;
			}
			if (temp >= 2)
				count++;
			i += temp;
		}
		return count;
	}

	/**
	 * Rearrange the value of x and y in array so that they are in adjacent in Array.
	 * @param x - value of X
	 * @param y - value of Y
	 * @return - Rearrange the array
	 */
	public int[] fixXY(int x, int y) {

		// Assertion : START
		assert array.length > 0 : "Array is Empty";

		assert array[array.length - 1] != x : "Not able To find";

		int countx = 0, county = 0;
		for (int l = 0; l < array.length; l++) {
			if (array[l] == x)
				countx++;
			if (array[l] == y)
				county++;
		}
		assert countx != county : "Occurrence are Different";

		for (int l = 0; l < array.length - 1; l++) {
			assert (array[l] != x && array[l + 1] != x) : " Two adjacents X values are there";
		}
		// Assertion : END
		int result[] = new int[array.length];
		result = array;
		int counti = 0;
		for (int l = 0; l < array.length; l++)
			if (array[l] == x)
				counti++;
		int i = 0, j = 0;
		while (counti > 0) {
			while (i < array.length && array[i] != x) {
				i++;
			}
			counti -= 1;
			while (j < array.length && array[j] != y) {
				j++;
			}
			int temp = result[i + 1];
			result[i + 1] = result[j];
			result[j] = temp;
			j = i + 2;
			i++;
		}
		return result;
	}

}

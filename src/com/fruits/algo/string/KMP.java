package com.fairchild.algo.string;

public class KMP {

	private static int[] getNext(char[] pattern) {
		int[] next = new int[pattern.length];
		next[0] = -1;

		int k = -1;

		for (int i = 1; pattern[i] != '\0'; i++) {
			// next[0] next[1] ... next[i-1] -> next[i]
			// k = next[i-1];
			// if(pattern[k + 1] == pattern[i]){
			// next[i] = k + 1;
			// }else{
			// k = next[k];
			// }
			k = next[i - 1];
			while ((k != -1) && (pattern[k + 1] != pattern[i])) {
				k = next[k];
			}

			next[i] = (k + 1);
		}

		return next;
	}

	public static int match(char[] src, char[] pattern) {
		int[] next = getNext(pattern);

		for (int i = 0, j = 0; src[i] != '\0';) {
			if (pattern[j] != src[i]) {
				while ((j = next[j]) != -1) {
					if (pattern[j] == src[i])
						break;
				}// j == -1
			}
			;
			i++;
			j++;

			if (pattern[j] == '\0')
				return (i - j);
		}
		return -1;
	}

	public static void main(String[] args) {
		char[] str = new char[] { '1', '2', '2', '4', '5', '6', '\0' };
		char[] pattern = new char[] { '4', '5', '\0' };
		System.out.println(match(str, pattern));
	}
}

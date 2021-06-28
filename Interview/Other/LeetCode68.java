import java.util.*;

class LeetCode68 {
	public List<String> fullyJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<>();
		int i = 0;
		while (i < words.length) {
			int j = i;
			int width = 0;
			int space = 1;
			int extra = 0;
			StringBuilder sb = new StringBuilder(words[i]);
			while (j < words.length && width + words[j].length() + (j-i) <= maxWidth) {
				width += words[j++].length();
			}

			if (j-i != 1 && j != words.length) {
				space = (maxWidth - width) / (j-i+1);
				extra = (maxWidth - width) % (j-i+1);
			}

			while (++i < j) {
				for (int s = space; s > 0; s--) {
					sb.append(" ");
				}
				if (extra-- > 0) {
					sb.append(" ");
				}
				sb.append(words[i]);
			}

			for (int s = maxWidth - sb.length(); s > 0; s--) {
				sb.append(" ");
			}
			list.add(sb.toString());
		}
		return list;
	}
}
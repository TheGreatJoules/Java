import java.util.*;
//Write a XML/HTML Parser Given: 
//`<a><b><c><d>MyText</d></c>AnotherText</b>Final</a>` 
// Return The formatted version of the same.
// How can you improve it if we need to put styles, url and other related properties in it.

class Solution {
  static String SPACE = " ";
  static String NEWLINE = "\n";
  static String SAMPLE_XML = "<a><b><c><d>MyText</d><e>OtherText</e></c>AnotherText</b>Final</a>"; 
  public static void main(String[] args) {
    String result = xmlParser(SAMPLE_XML);
    System.out.println(result);
  }
  
  private static String xmlParser(String s) {
    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();
    Stack<String> stack = new Stack<>();
    String result = getChild(s, stack, list, 0);
    System.out.println(result);
    return sb.toString();
  }

  private static String getChild(String s, Stack<String> stack, List<String> list, int index) {
    // Terminating condition if index is out of bounds
    if (index >= s.length()) {
      return String.join("", list);
    } 
    // Initialize pointers for the start and end of tag
    int a = s.indexOf('<', index);
    int b = s.indexOf('>', index);
    String current = s.substring(a, b + 1);
    String padding = String.join("", Collections.nCopies(stack.size(), SPACE));
    // If the index of the string is not the start of a new tag, go ahead and pop the previous tag and copy the entire body
    if (s.charAt(index) != '<' && s.charAt(index) != '>') {
      list.set(list.size()-1, padding + stack.pop() + s.substring(index, b+1) + "\n");
    } else if (current.contains("/")) { // If the tag contains a close delimiter, proceed to add the line along with any trailing text after tag
      stack.pop();
      StringBuilder sb = new StringBuilder();
      padding = padding.substring(0, stack.size());
      sb.append(padding);
      sb.append(current);
      int offset = b+1;
      // Continue to add all characters until start of new tag is found
      while (offset < s.length() && offset < s.indexOf('<', b+1)) {
        sb.append(s.charAt(offset++));
      }
      // Only add new line if there are remaining lines
      if (offset != s.length()) {
        sb.append('\n');
      }
      b = offset - 1;
      list.add(sb.toString());
    } else { // If the currrent line is only an open tag proceed to record the current space depth and tag
      list.add(padding + current + "\n");
      stack.add(current);
    }
    // recurse inward and move index forward
    return getChild(s, stack, list, b+1);
  }
}
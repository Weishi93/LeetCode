package leetcode;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;
public class p71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p71 a = new p71();
		System.out.println(a.simplifyPath("/home/"));
	}
	public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int prev = 0;
        String s = path;
        while(s.length() != 0) {
            int curt = getNext(s);
            String tmp = s.substring(prev, curt);
            prev = curt;
            s = s.substring(prev);
            if(tmp == "/" || s == "/.") {
                continue;
            } else if(tmp == "/.." && !stack.empty()) {
                stack.pop();
            } else if(tmp == "/.." && stack.empty()) {
                return "/";
            } else {
                stack.push(tmp);
            }
        }
        String res = "";
        while(!stack.empty()) {
            res = stack.pop() + res;
        }
        return res;
    }
    
    private int getNext(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int i = 1;
        while(i < s.length() && s.charAt(i) != '/') {
            i++;
        }
        return i;
    }

}

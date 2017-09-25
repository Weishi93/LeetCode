package leetcode;

import java.util.*;
import java.util.PriorityQueue;

/**
 * Created by Vincent on 8/22/16.
 */
public class test1 {
    public static void main(String[] args) {
        ReturnType a = new ReturnType();
        a.func0();
        PriorityQueue<Integer> q = new PriorityQueue<Integer> (10);
        q.add(10);
        q.offer(12);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class ReturnType{
    public void func0 () {
        TreeNode curr = new TreeNode(0);
        curr.left = new TreeNode(1);

        func1(curr);

        System.out.println(curr.val);
    }

    private void func1 (TreeNode curr){
        curr = curr.left;
    }
}
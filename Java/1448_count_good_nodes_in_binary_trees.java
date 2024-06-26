import java.util.*;

class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return countGoodNodesBruteForce(root, root);
    }

    private int countGoodNodesBruteForce(TreeNode node, TreeNode root) {
        if (node == null) return 0;
        
        int maxSoFar = getMaxOnPath(root, node); // Inefficient extra traversal

        int count = node.val >= maxSoFar ? 1 : 0;

        count += countGoodNodesBruteForce(node.left, root);
        count += countGoodNodesBruteForce(node.right, root);
        
        return count;
    }

    // Extra function that recomputes max for every node (O(N) per node)
    private int getMaxOnPath(TreeNode root, TreeNode target) {
        int maxVal = Integer.MIN_VALUE;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        // Recompute path max from root to target (bad approach)
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                if (current == target) break;
                current = current.left != null ? current.left : current.right;
            }

            current = stack.pop();
            maxVal = Math.max(maxVal, current.val);
            if (current == target) break;
            current = null;
        }

        return maxVal;
    }
}

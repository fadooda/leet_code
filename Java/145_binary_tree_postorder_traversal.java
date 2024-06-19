import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result; // Edge case: Empty tree

        Set<TreeNode> visited = new HashSet<>(); // Track visited nodes

        while (root != null) {  
            TreeNode deepest = getDeepestUnvisitedNode(root, visited);
            if (deepest == null) break; // If no more nodes, exit
            
            result.add(deepest.val); // Add node in postorder
            visited.add(deepest); // Mark node as visited
        }
        return result;
    }

    // Helper function to find the deepest unvisited node
    private TreeNode getDeepestUnvisitedNode(TreeNode node, Set<TreeNode> visited) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode last = null;

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            // Only return the deepest unvisited node
            if (!visited.contains(current)) {
                last = current;
            }

            // Push right before left (simulate postorder)
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        return last;
    }
}

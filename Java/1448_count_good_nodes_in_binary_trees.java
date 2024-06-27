/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        // Start DFS traversal from root with its value as the initial max
        return countGoodNodes(root, root.val);
    }
    
    /**
     * Recursive DFS function to count "good" nodes.
     * 
     * @param node - Current TreeNode being processed.
     * @param maxSoFar - Maximum value encountered along the current path.
     * @return The number of "good" nodes in the subtree rooted at `node`.
     */
    private int countGoodNodes(TreeNode node, int maxSoFar) {
        // Base case: If the node is null, return 0 since there are no nodes to count.
        if (node == null) {
            return 0;
        }
        
        // Check if the current node is a "good node"
        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1;  // This node is "good" since it meets the condition
            maxSoFar = node.val; // Update the max value for the current path
        }

        // Recursively count good nodes in the left and right subtrees
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        // Return the total count of good nodes found in this subtree
        return count;
    }
}

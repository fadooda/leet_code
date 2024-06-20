class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderNodes = new ArrayList<>();
        if (root == null) return postorderNodes; // Edge case: Empty tree

        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left; // Go as deep left as possible
            } else {
                TreeNode peekNode = stack.peek();
                // Process the right child if it exists and hasn't been visited yet
                if (peekNode.right != null && peekNode.right != lastVisited) {
                    current = peekNode.right;
                } else {
                    postorderNodes.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }

        return postorderNodes;
    }
}

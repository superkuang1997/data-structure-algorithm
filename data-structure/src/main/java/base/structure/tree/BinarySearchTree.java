package base.structure.tree;

/**
 * @author by yorua
 * @classname BinarySearchTree
 * @description 二叉搜索树
 * @date 2020/12/27 5:08 下午
 */
public class BinarySearchTree {
    TreeNode root = null;
    int currentSize = 0;

    public BinarySearchTree() {

    }


    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void put(int key, Object value) {
        if (root != null) {
            put(key, value, root);
        } else {
            root = new TreeNode(key, value);
        }
        currentSize++;
    }

    public void put(int key, Object value, TreeNode currentNode) {

        if (key < currentNode.getKey()) {
            // 向左子树下放
            if (currentNode.hasLeftChild()) {
                put(key, value, currentNode.getLeftChild());
            } else {
                TreeNode newNode = new TreeNode(key, value);
                currentNode.setLeftChild(newNode);
                newNode.setParent(currentNode);

            }
        } else {
            // 向右子树下放
            if (currentNode.hasRightChild()) {
                put(key, value, currentNode.getRightChild());
            } else {
                TreeNode newNode = new TreeNode(key, value);
                currentNode.setRightChild(newNode);
                newNode.setParent(currentNode);
            }
        }
    }

    public TreeNode get(int key) {
        if (root != null) {
            TreeNode res = get(key, root);
            if (res != null) {
                return res;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public TreeNode get(int key, TreeNode currentNode) {
        if (currentNode != null) {
            if (currentNode.getKey() == key) {
                return currentNode;
            } else if (currentNode.getKey() < key) {
                return get(key, currentNode.getRightChild());
            } else if (currentNode.getKey() > key) {
                return get(key, currentNode.getLeftChild());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * the first step of deletion is to get the node of key, then to delete it.
     *
     * @param key the key of BST
     */
    public void delete(int key) {
        if (currentSize > 1) {
            TreeNode node = get(key);
            if (node != null) {
                remove(node);
            } else {
                throw new RuntimeException("specified key not in test.tree.");
            }
        }
    }

    public void remove(TreeNode node) {
        if (node.isLeaf()) {
            // 如果待删除节点没有子节点
            if (node.getParent().getLeftChild() == node) {
                node.getParent().setLeftChild(null);
            } else {
                node.getParent().setRightChild(null);
            }
        } else if (node.hasBothChild()) {
            // 如果待删除节点有两个子节点，寻找后继节点替换被删除的位置，此时后继节点一定存在
            TreeNode successor = node.findSuccessor();
            // 后继节点一定是叶节点或者仅有一个右子节点
            remove(successor);
            node.setKey(successor.getKey());
            node.setValue(successor.getValue());


        } else {
            // 如果待删除节点仅有一个子节点
            if (node.hasLeftChild()) {
                // 仅有一个左子节点
                if (node.isLeftChild()) {
                    // 当前节点是一个左子节点
                    node.getParent().setLeftChild(node.getLeftChild());
                    node.getLeftChild().setParent(node.getParent());
                } else if (node.isRightChild()) {
                    // 当前节点是一个右子节点
                    node.getParent().setRightChild(node.getLeftChild());
                    node.getLeftChild().setParent(node.getParent());
                } else {
                    // 当前节点是一个根节点
                    node.replaceNode(
                            node.getLeftChild().getKey(),
                            node.getLeftChild().getValue(),
                            node.getLeftChild().getLeftChild(),
                            node.getLeftChild().getRightChild()
                    );

                }

            } else {
                // 仅有一个右子节点
                if (node.isLeftChild()) {
                    // 当前节点是一个左子节点
                    node.getParent().setLeftChild(node.getRightChild());
                    node.getRightChild().setParent(node.getParent());
                } else if (node.isRightChild()) {
                    // 当前节点是一个右子节点
                    node.getParent().setRightChild(node.getRightChild());
                    node.getRightChild().setParent(node.getParent());
                } else {
                    // 当前节点是一个根节点
                    node.replaceNode(
                            node.getLeftChild().getKey(),
                            node.getLeftChild().getValue(),
                            node.getLeftChild().getLeftChild(),
                            node.getLeftChild().getRightChild()
                    );

                }
            }
        }
    }

    public void preOrder() {
        if (root != null) {
            preOrder(root);
        }
    }

    public void preOrder(TreeNode current) {
        System.out.println(current);
        if (current.getLeftChild() != null) {
            preOrder(current.getLeftChild());
        }
        if (current.getRightChild() != null) {
            preOrder(current.getRightChild());
        }
    }


}




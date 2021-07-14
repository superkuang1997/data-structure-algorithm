package base.structure.tree;


/**
 * @author by yorua
 * @description 红黑树的实现
 * @date 2021/1/4 11:48 上午
 */

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private RedBlackTreeNode root = null;
    private int currentSize = 0;

    public RedBlackTreeNode getRoot() {
        return root;
    }

    public void setRoot(RedBlackTreeNode root) {
        this.root = root;
    }

    public RedBlackTreeNode get(int key) {
        if (root != null) {
            RedBlackTreeNode res = get(key, root);
            if (res != null) {
                return res;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public RedBlackTreeNode get(int key, RedBlackTreeNode currentNode) {
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

    public void put(int key, Object value) {
        if (root != null) {
            // 沿着根节点下放
            put(key, value, root);
        } else {
            // 根节点设为黑色
            root = new RedBlackTreeNode(key, value, BLACK);
        }
        currentSize++;
    }

    public void put(int key, Object value, RedBlackTreeNode currentNode) {
        if (key < currentNode.getKey()) {
            // 向左子树下放
            if (currentNode.hasLeftChild()) {
                put(key, value, currentNode.getLeftChild());
            } else {
                RedBlackTreeNode newNode = new RedBlackTreeNode(key, value, RED);
                currentNode.setLeftChild(newNode);
                newNode.setParent(currentNode);
                // 对新插入节点造成的影响重新设置红黑树的颜色
                updateNode(newNode);

            }
        } else {
            // 向右子树下放
            if (currentNode.hasRightChild()) {
                put(key, value, currentNode.getRightChild());
            } else {
                RedBlackTreeNode newNode = new RedBlackTreeNode(key, value, RED);
                currentNode.setRightChild(newNode);
                newNode.setParent(currentNode);
                // 对新插入节点造成的影响重新设置红黑树的颜色
                updateNode(newNode);
            }
        }
    }

    /**
     * @param node
     */
    public void updateNode(RedBlackTreeNode node) {

        if (node.getParent().getColor() == RED) {
            rebalance(node);
        }

        if (root.getColor() == RED) {
            root.setColor(BLACK);
        }
    }

    private void rebalance(RedBlackTreeNode node) {
        RedBlackTreeNode parent = node.getParent();
        ;
        RedBlackTreeNode grandParent = parent.getParent();

        if (node.uncleIsRed()) {
            // 叔叔节点是红色
            node.getParent().setColor(BLACK);
            node.getParent().getParent().setColor(RED);
            if (node.hasUncle()) {
                node.getUncle().setColor(BLACK);
            }

        } else {
            // 叔叔节点不是红色
            if (node.isLeftChild() && parent.isLeftChild()) {
                rotateRight(parent.getParent(), true);

            } else if (node.isRightChild() && parent.isRightChild()) {
                rotateLeft(grandParent, true);

            } else if (node.isRightChild() && parent.isLeftChild()) {
                rotateLeft(parent, false);
                rotateRight(grandParent, true);

            } else if (node.isLeftChild() && parent.isRightChild()) {
                rotateRight(parent, false);
                rotateLeft(grandParent, true);

            }

        }

        // 递归，对可能破坏性质4的情况进行处理
        if (grandParent.getParent() != null && grandParent.getParent().getColor() == RED) {
            rebalance(grandParent);
        }

    }


    /**
     * 围绕节点右旋
     *
     * @param oldRoot the node to rotate rightly
     */
    private void rotateRight(RedBlackTreeNode oldRoot, boolean exchange) {
        RedBlackTreeNode newRoot = oldRoot.getLeftChild();
        // 如果newRoot有右子节点，那么令其为oldRoot的左子节点。如果没有，旧根节点的左子节点置空
        if (newRoot.hasRightChild()) {
            newRoot.getRightChild().setParent(oldRoot);
            oldRoot.setLeftChild(newRoot.getRightChild());
        } else {
            oldRoot.setLeftChild(null);
        }


        // 处理oldRoot父节点的引用关系
        if (oldRoot == getRoot()) {
            setRoot(newRoot);
        } else if (oldRoot.isLeftChild()) {
            oldRoot.getParent().setLeftChild(newRoot);
            newRoot.setParent(oldRoot.getParent());
        } else if (oldRoot.isRightChild()) {
            oldRoot.getParent().setRightChild(newRoot);
            newRoot.setParent(oldRoot.getParent());
        }

        // 用新根代替旧根
        newRoot.setRightChild(oldRoot);
        oldRoot.setParent(newRoot);

        // 交换新根和旧根的颜色
        if (exchange) {
            exchangeColor(oldRoot, newRoot);
        }

    }

    /**
     * 围绕节点左旋
     *
     * @param oldRoot the node to rotate rightly
     */
    private void rotateLeft(RedBlackTreeNode oldRoot, boolean exchange) {
        RedBlackTreeNode newRoot = oldRoot.getRightChild();
        // 如果newRoot有左子节点，那么令其为oldRoot的右子节点。如果没有，旧根节点的右子节点置空
        if (newRoot.hasLeftChild()) {
            newRoot.getLeftChild().setParent(oldRoot);
            oldRoot.setRightChild(newRoot.getLeftChild());
        } else {
            oldRoot.setRightChild(null);
        }


        // 处理oldRoot父节点的引用关系
        if (oldRoot == getRoot()) {
            setRoot(newRoot);
            newRoot.setParent(null);
        } else if (oldRoot.isLeftChild()) {
            oldRoot.getParent().setLeftChild(newRoot);
            newRoot.setParent(oldRoot.getParent());
        } else if (oldRoot.isRightChild()) {
            oldRoot.getParent().setRightChild(newRoot);
            newRoot.setParent(oldRoot.getParent());
        }

        // 用新根代替旧根
        newRoot.setLeftChild(oldRoot);
        oldRoot.setParent(newRoot);

        // 交换新根和旧根的颜色
        if (exchange) {
            exchangeColor(oldRoot, newRoot);
        }

    }

    /**
     * 交换两个节点的颜色
     *
     * @param oldRoot
     * @param newRoot
     */
    private void exchangeColor(RedBlackTreeNode oldRoot, RedBlackTreeNode newRoot) {
        newRoot.setColor(BLACK);
        oldRoot.setColor(RED);
    }

    public void preOrder() {
        if (root != null) {
            preOrder(root);
        }
        System.out.println("the length of tree is " + currentSize + ".");
    }

    public void preOrder(RedBlackTreeNode current) {
        System.out.println(current);
        if (current.getLeftChild() != null) {
            preOrder(current.getLeftChild());
        }
        if (current.getRightChild() != null) {
            preOrder(current.getRightChild());
        }
    }
}

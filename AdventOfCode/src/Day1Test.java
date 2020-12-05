import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class Day1Test {

	@Test
	void BinaryTreeInsertTest() {
		BinaryTree tree = new BinaryTree();

		tree.insert(4);
		tree.insert(2);
		tree.insert(5);

		assertEquals(tree.size, 3);
		assertEquals(tree.root.key, 4);

		assertEquals(5, tree.root.right.key);
		assertEquals(2, tree.root.left.key);

		tree.insert(3);

		assertEquals(3, tree.root.left.right.key);
	}

	@Test
	void BinaryTreeSearchTest() {
		BinaryTree tree = new BinaryTree();

		tree.insert(4);
		tree.insert(2);
		tree.insert(5);
		tree.insert(3);

		assertTrue(tree.search(4));
		assertTrue(tree.search(3));

		assertFalse(tree.search(1));
		assertFalse(tree.search(-11));

	}

}

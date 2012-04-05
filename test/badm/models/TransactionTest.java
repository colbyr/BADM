/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badm.models;

import badm.Accounts;
import badm.Transaction;
import java.util.Date;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Transaction Model Test
 *
 * @author Colby Rabideau
 */
public class TransactionTest {

	/**
	 * Transaction
	 */
	public static Transaction transaction;

	/**
	 * Set Up Class
	 *
	 * @return void
	 */
	@BeforeClass
	public static void setUpClass() {
		if (!Accounts.login()) {
			fail("Could not login.");
		}
	}

	/**
	 * Set Up
	 *
	 * @return void
	 */
	@Before
	public void setUp() {
		transaction = new Transaction();
		transaction.setDate(new Date());
		transaction.setAmount(100.00);
		transaction.setSublineId(1);
		if (!transaction.commit()) {
			fail("could not commit transaction");
		}
	}

	/**
	 * Tear Down
	 *
	 * @return void
	 */
	@After
	public void tearDown() {
		transaction.delete();
		transaction = null;
	}

	/**
	 * [test] Create Transaction
	 *
	 * @return void
	 */
	@Test
	public void create() {
		assertTrue(transaction.getId() > -1);
	}

	/**
	 * [test] Read Transaction
	 *
	 * @return void
	 */
	@Test
	public void read() {
		System.out.println("Read");
		Transaction read = Transaction.find(transaction.getId());
		assertEquals(read.getName(), transaction.getName());
	}

	/**
	 * [test] Update Transaction
	 *
	 * @return void
	 */
	@Test
	public void Update() {
		System.out.println("Update");
		transaction.setName("Updated");
		transaction.commit();
		Transaction read = Transaction.find(transaction.getId());
		assertEquals(read.getName(), "Updated");
	}

	@Test
	public void Delete() {
		System.out.println("Delete");
		Integer id = transaction.getId();
		transaction.delete();
		Transaction read = Transaction.find(transaction.getId());
		assertEquals(read, null);
	}
}

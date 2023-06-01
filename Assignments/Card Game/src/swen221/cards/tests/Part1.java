// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import swen221.cards.core.Card;
import swen221.cards.util.AbstractCardGame;

import java.util.List;

/**
 * Tests for part 1 of the assignment.
 *
 * @author David J. Pearce
 *
 */
public class Part1 {
	// ===========================================================================
	// Part 1 --- Card comparisons
	// ===========================================================================

	/**
	 * Test Card.equals() method.
	 */
	@Test
	public void testCardEquals() {
		List<Card> deck1 = AbstractCardGame.createDeck();
		List<Card> deck2 = AbstractCardGame.createDeck();
		for (int i = 0; i != 52; ++i) {
			Card c1 = deck1.get(i);
			Card c2 = deck2.get(i);
			if (!c1.equals(c2)) {
				fail("CARD: " + c1 + " should equal " + c2);
			}
		}
	}

	/**
	 * Test Card.equals() method.
	 */
	@Test
	public void testCardNotEquals() {
		List<Card> deck1 = AbstractCardGame.createDeck();
		for (int i = 0; i != 52; ++i) {
			for (int j = 0; j != 52; ++j) {
				if (i != j) {
					Card c1 = deck1.get(i);
					Card c2 = deck1.get(j);
					if (c1.equals(c2)) {
						fail("CARD: " + c1 + " should not equal " + c2);
					}
				}
			}
		}
	}

	/**
	 * Test Card.compareTo() method.
	 */
	@Test
	public void testCardCompareTo() {
		List<Card> deck1 = AbstractCardGame.createDeck();
		List<Card> deck2 = AbstractCardGame.createDeck();
		for (int i = 1; i != 52; ++i) {
			Card c1 = deck1.get(i - 1);
			Card c2 = deck1.get(i);
			Card c3 = deck2.get(i);
			if (c1.compareTo(c2) >= 0) {
				fail("Card " + c1 + " should be less than " + c2);
			}
			if (c2.compareTo(c1) <= 0) {
				fail("Card " + c2 + " should be greater than " + c1);
			}
			if (c3.compareTo(c2) != 0) {
				fail("Card " + c3 + " should equal " + c2);
			}
		}
	}
}

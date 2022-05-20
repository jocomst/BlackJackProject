import com.blackjack.Card;
import com.blackjack.Suits;
import com.blackjack.Values;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @DisplayName("Get value from card")
    @org.junit.jupiter.api.Test
    void getValue() {
        Card card = new Card(new Card(Suits.DIAMOND, Values.EIGHT));
        assertEquals(8, card.getValue());
    }
}
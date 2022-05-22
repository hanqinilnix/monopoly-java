package model;

import java.util.LinkedList;

import model.card.Card;
import model.card.MoveToPropertyCard;
import model.card.MoveXSpacesCard;
import model.card.PayBankCard;
import model.card.PayPlayersCard;
import model.card.ReceiveCard;
import model.spaces.Property;

public class ChanceManager {
    private LinkedList<Card> chanceCards;

    private static Card ADVANCE_RED; // wait to make the board first
    private static Card GO_BACK_3 = new MoveXSpacesCard("Go back 3 spaces", -3);
    private static Card PAY_CONSERVANCY_FEE = new PayBankCard("Pay conservancy fees of $150", 15);
    private static Card BANK_PAYS_DIVIDEND = new ReceiveCard("Bank pays you dividend of $500", 50);
    private static Card PAY_ALL_PLAYERS = new PayPlayersCard("You have been elected chairman of the board pay each player $500", 50);

}

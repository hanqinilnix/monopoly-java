package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import model.card.AdvanceToGoCard;
import model.card.Card;
import model.card.CollectFromPlayersCard;
import model.card.GetOutOfJailCard;
import model.card.GoToJailCard;
import model.card.PayBankCard;
import model.card.PayPerHouseCard;
import model.card.ReceiveCard;

public class CommunityChestManager {
    private static Card INCOME_TAX_REFUND = new ReceiveCard("Income Tax Refund\nCollect $20", 20);
    private static Card GIC_ISSUES_DIVIDENDS = new ReceiveCard("GIC issues dividends\nCollect $100", 100);
    private static Card ADVANCE_TO_GO = new AdvanceToGoCard("Advance to GO\n(Collect $200)");
    private static Card INHERITANCE = new ReceiveCard("You inherit $100", 100);
    private static Card DOCTOR_FEE = new PayBankCard("Doctor's fee\nPay $50", 50);
    private static Card GRAND_OPERA_OPENING = new CollectFromPlayersCard("Grand Opera Opening\nCollect $50 from every player\nFor opening night seats", 50);
    private static Card LIFE_INSURANCE = new ReceiveCard("Life insurance matures\nCollect $100", 100);
    private static Card PAY_HOSPITAL = new PayBankCard("Pay hospital $100", 100);
    private static Card GO_TO_JAIL = new GoToJailCard("Go to jail\nGo Directly to jail\nDo no pass GO\nDo not collect $200");
    private static Card BANK_ERROR = new ReceiveCard("Bank error in your favour\nCollect $200", 200);
    private static Card STREET_REPAIRS = new PayPerHouseCard("You are assessed for street repairs\n$40 per house\n$115 per hotel", 40, 115);
    private static Card GET_OUT_OF_JAIL_FREE =new GetOutOfJailCard("Get out of jail free\nThis card maybe kept until needed\nor sold");
    private static Card SECOND_PRIZE = new ReceiveCard("You have won second prize in a lucky draw\nCollect 10", 10);
    private static Card SCHOOL_FEES = new PayBankCard("Pay school fees of $150", 150);
    private static Card SALE_STOCK = new ReceiveCard("From sale fo stock you get $45", 45);
    private static Card SERVICES = new ReceiveCard("Receive for services $250", 250);

    private LinkedList<Card> communityChestCards;
    private boolean drawnGetOutOfJail = false;

    public CommunityChestManager() {
        communityChestCards = new LinkedList<>(Arrays.asList(INCOME_TAX_REFUND, GIC_ISSUES_DIVIDENDS, ADVANCE_TO_GO,
                INHERITANCE, DOCTOR_FEE, GRAND_OPERA_OPENING, LIFE_INSURANCE, PAY_HOSPITAL, GO_TO_JAIL, BANK_ERROR,
                STREET_REPAIRS, GET_OUT_OF_JAIL_FREE, SECOND_PRIZE, SCHOOL_FEES, SALE_STOCK, SERVICES));

        Collections.shuffle(communityChestCards);
    }

    public Card draw() {
        Card drawnCard = communityChestCards.poll();

        if (drawnCard.equals(GET_OUT_OF_JAIL_FREE)) {
            drawnGetOutOfJail = true;
        }

        if (communityChestCards.isEmpty()) {
            reshuffle();
        }

        return drawnCard;
    }

    public void reshuffle() {
        communityChestCards = new LinkedList<>(Arrays.asList(INCOME_TAX_REFUND, GIC_ISSUES_DIVIDENDS, ADVANCE_TO_GO,
                INHERITANCE, DOCTOR_FEE, GRAND_OPERA_OPENING, LIFE_INSURANCE, PAY_HOSPITAL, GO_TO_JAIL, BANK_ERROR,
                STREET_REPAIRS, SECOND_PRIZE, SCHOOL_FEES, SALE_STOCK, SERVICES));

        if (!drawnGetOutOfJail) {
            communityChestCards.add(GET_OUT_OF_JAIL_FREE);
        }

        Collections.shuffle(communityChestCards);
    }

    public void returnGetOutOfJailFreeCard() {
        drawnGetOutOfJail = false;
        communityChestCards.add(GET_OUT_OF_JAIL_FREE);

        Collections.shuffle(communityChestCards);
    }
}

package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import commons.PurchasableType;
import model.card.AdvanceToGoCard;
import model.card.AdvanceToNearestCard;
import model.card.Card;
import model.card.GetOutOfJailCard;
import model.card.GoToJailCard;
import model.card.MoveToPropertyCard;
import model.card.MoveXSpacesCard;
import model.card.PayBankCard;
import model.card.PayPerHouseCard;
import model.card.PayAllPlayersCard;
import model.card.ReceiveCard;
import model.spaces.PurchasableSpace;

public class ChanceManager {
    private static final Card ADVANCE_TO_RED3 = new MoveToPropertyCard(String.format("Advance to %1$s", SpaceManager.RED3_NAME), (PurchasableSpace) SpaceManager.RED3);
    private static final Card ADVANCE_TO_NEAREST_UTILITY = new AdvanceToNearestCard("Advance token to nearest utility\nIf unowned, you may buy it from the bank\nIf owned, throw dice and pay owner a total 10 times the amount thrown", PurchasableType.UTILITY);
    private static final Card ADVANCE_TO_NEAREST_STATION = new AdvanceToNearestCard("Advance token to nearest station and pay owner twice the rental to which he/she is otherwise entitled\nIf station is unowned, you may buy it from the bank", PurchasableType.STATION);
    private static final Card ADVANCE_TO_NEAREST_STATION_SECOND = new AdvanceToNearestCard("Advance token to nearest station and pay owner twice the rental to which he/she is otherwise entitled\nIf station is unowned, you may buy it from the bank", PurchasableType.STATION);
    private static final Card GO_BACK_3 = new MoveXSpacesCard("Go back 3 spaces", -3);
    private static final Card PAY_CONSERVANCY_FEE = new PayBankCard("Pay conservancy fees of $150", 15);
    private static final Card BANK_PAYS_DIVIDEND = new ReceiveCard("Bank pays you dividend of $500", 50);
    private static final Card PAY_ALL_PLAYERS = new PayAllPlayersCard("You have been elected chairman of the board pay each player $500", 50);
    private static final Card RIDE_TO_STATION1 = new MoveToPropertyCard(String.format("Take a ride to %1$s\nIf you pass GO collect $200", SpaceManager.STATION1_NAME), (PurchasableSpace) SpaceManager.STATION1);
    private static final Card GET_OUT_OF_JAIL_FREE = new GetOutOfJailCard("Get out of jail free\nThis card may be kept until needed, or sold");
    private static final Card GENERAL_REPAIR = new PayPerHouseCard("Make general repairs on all your property\nFor each house pay $25\nfor each hotel $100", 25, 100);
    private static final Card ADVANCE_TO_BLUE2 = new MoveToPropertyCard(String.format("Take a walk on %1$s\nAdvance token to %2$s", SpaceManager.GREEN3_NAME, SpaceManager.BLUE2_NAME), (PurchasableSpace) SpaceManager.BLUE2);
    private static final Card ADVANCE_TO_PINK1 = new MoveToPropertyCard(String.format("Advance to %1$s\nIf you pass GO, collect $200", SpaceManager.PINK1_NAME), (PurchasableSpace) SpaceManager.PINK1);
    private static final Card CASH_IN_INVESTMENTS = new ReceiveCard("Cash in on investments\nCollect $150", 150);
    private static final Card GO_TO_JAIL = new GoToJailCard("Go directly to jail\nDo not pass go\nDo not collect $200");
    private static final Card ADVANCE_TO_GO = new AdvanceToGoCard("Advance to GO\n(Collect $200)");

    private LinkedList<Card> chanceCards;
    private boolean drawnGetOutOfJail = false;

    public ChanceManager() {
        chanceCards = new LinkedList<>(Arrays.asList(ADVANCE_TO_BLUE2, ADVANCE_TO_GO, ADVANCE_TO_PINK1,
                ADVANCE_TO_RED3, ADVANCE_TO_NEAREST_STATION, ADVANCE_TO_NEAREST_STATION_SECOND,
                ADVANCE_TO_NEAREST_UTILITY, GO_BACK_3, PAY_ALL_PLAYERS, PAY_CONSERVANCY_FEE, BANK_PAYS_DIVIDEND,
                RIDE_TO_STATION1, GET_OUT_OF_JAIL_FREE, GENERAL_REPAIR, CASH_IN_INVESTMENTS, GO_TO_JAIL));

        Collections.shuffle(chanceCards);
    }

    public Card draw() {
        Card drawnCard = chanceCards.poll();

        if (drawnCard.equals(GET_OUT_OF_JAIL_FREE)) {
            drawnGetOutOfJail = true;
        }

        if (chanceCards.isEmpty()) {
            reshuffle();
        }

        return drawnCard;
    }

    public void reshuffle() {
        chanceCards = new LinkedList<>(Arrays.asList(ADVANCE_TO_BLUE2, ADVANCE_TO_GO, ADVANCE_TO_PINK1,
                ADVANCE_TO_RED3, ADVANCE_TO_NEAREST_STATION, ADVANCE_TO_NEAREST_STATION_SECOND,
                ADVANCE_TO_NEAREST_UTILITY, GO_BACK_3, PAY_ALL_PLAYERS, PAY_CONSERVANCY_FEE, BANK_PAYS_DIVIDEND,
                RIDE_TO_STATION1, GENERAL_REPAIR, CASH_IN_INVESTMENTS, GO_TO_JAIL));

        if (!drawnGetOutOfJail) {
            chanceCards.add(GET_OUT_OF_JAIL_FREE);
        }

        Collections.shuffle(chanceCards);
    }

    public void returnGetOutOfJailFreeCard() {
        drawnGetOutOfJail = false;
        chanceCards.add(GET_OUT_OF_JAIL_FREE);

        Collections.shuffle(chanceCards);
    }
}

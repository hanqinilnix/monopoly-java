package model.card;

import model.player.Player;
import model.player.TitleDeeds;

public class PayPerHouseCard extends Card {
    private final int amountPerHouse;
    private final int amountPerHotel;

    public PayPerHouseCard(String description, int amountPerHouse, int amountPerHotel) {
        super(description);
        this.amountPerHouse = amountPerHouse;
        this.amountPerHotel = amountPerHotel;
    }

    @Override
    public void whenDrawn(Player player) {
        TitleDeeds deeds = player.getTitleDeeds();

        int houses = deeds.getTotalOwnedHouses();
        int hotels = deeds.getTotalOwnedHotels();

        int totalCost = houses * amountPerHouse + hotels * amountPerHotel;

        player.giveMoney(totalCost);
    }
}

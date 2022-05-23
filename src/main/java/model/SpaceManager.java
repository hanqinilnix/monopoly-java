package model;

import commons.ColorGroup;
import model.spaces.ActionSpace;
import model.spaces.Property;
import model.spaces.Space;
import model.spaces.Station;
import model.spaces.TaxSpace;
import model.spaces.Utility;

public class SpaceManager {
    public static final int BOARD_SIZE = 40;

    public static final String GO_NAME = "PASS GO";
    public static final String JAIL_NAME = "IN JAIL/ JUST VISITING";
    public static final String FREE_PARKING_NAME = "FREE PARKING";
    public static final String GO_TO_JAIL_NAME = "GO TO JAIL";

    public static final String COMMUNITY_CHEST_NAME = "Community Chest";
    public static final String CHANCE_NAME = "Chance";

    public static final String INCOME_TAX_NAME = "Income Tax";
    public static final String LUXURY_TAX_NAME = "Luxury Tax";

    public static final String UTILITY1_NAME = "Electric Company";
    public static final String UTILITY2_NAME = "Water Works";

    public static final String STATION1_NAME = "Reading Railroad";
    public static final String STATION2_NAME = "Pennsylvania Railroad";
    public static final String STATION3_NAME = "B. & O. Railroad";
    public static final String STATION4_NAME = "Short Line";

    public static final String PURPLE1_NAME = "Mediterranean Avenue";
    public static final String PURPLE2_NAME = "Baltic Avenue";

    public static final String TEAL1_NAME = "Oriental Avenue";
    public static final String TEAL2_NAME = "Vermont Avenue";
    public static final String TEAL3_NAME = "Connecticut Avenue";

    public static final String PINK1_NAME = "St. Charles Place";
    public static final String PINK2_NAME = "States Avenue";
    public static final String PINK3_NAME = "Virginia Avenue";

    public static final String ORANGE1_NAME = "St. James Place";
    public static final String ORANGE2_NAME = "Tennessee Avenue";
    public static final String ORANGE3_NAME = "New York Avenue";

    public static final String RED1_NAME = "Kentucky Avenue";
    public static final String RED2_NAME = "Indiana Avenue";
    public static final String RED3_NAME = "Illinois Avenue";

    public static final String YELLOW1_NAME = "Atlantic Avenue";
    public static final String YELLOW2_NAME = "Vertnor Avenue";
    public static final String YELLOW3_NAME = "Marvin Gardens";

    public static final String GREEN1_NAME = "Pacific Avenue";
    public static final String GREEN2_NAME = "North Carolina Avenue";
    public static final String GREEN3_NAME = "Pennsylvania Avenue";

    public static final String BLUE1_NAME = "Park Palace";
    public static final String BLUE2_NAME = "Boardwalk";

    public static final int HOUSE_PRICE1 = 50;
    public static final int HOUSE_PRICE2 = 100;
    public static final int HOUSE_PRICE3 = 150;
    public static final int HOUSE_PRICE4 = 200;

    public static final int STATION_PRICE = 200;
    public static final int UTILITY_PRICE = 150;

    public static final int PURPLE1_PRICE = 60;
    public static final int PURPLE2_PRICE = 60;

    public static final int[] PURPLE1_RENT = {2, 10, 30, 90, 160, 250};
    public static final int[] PURPLE2_RENT = {4, 20, 60, 180, 320, 450};

    public static final int TEAL1_PRICE = 100;
    public static final int TEAL2_PRICE = 100;
    public static final int TEAL3_PRICE = 120;

    public static final int[] TEAL1_RENT = {6, 30, 90, 270, 400, 550};
    public static final int[] TEAL2_RENT = {6, 30, 90, 270, 400, 550};
    public static final int[] TEAL3_RENT = {8, 40, 100, 300, 450, 600};

    public static final int PINK1_PRICE = 140;
    public static final int PINK2_PRICE = 140;
    public static final int PINK3_PRICE = 160;

    public static final int[] PINK1_RENT = {10, 50, 150, 450, 625, 750};
    public static final int[] PINK2_RENT = {10, 50, 150, 450, 625, 750};
    public static final int[] PINK3_RENT = {12, 60, 180, 500, 700, 900};

    public static final int ORANGE1_PRICE = 180;
    public static final int ORANGE2_PRICE = 180;
    public static final int ORANGE3_PRICE = 200;

    public static final int[] ORANGE1_RENT = {14, 70, 200, 550, 750, 950};
    public static final int[] ORANGE2_RENT = {14, 70, 200, 550, 750, 950};
    public static final int[] ORANGE3_RENT = {16, 80, 220, 600, 800, 1000};

    public static final int RED1_PRICE = 220;
    public static final int RED2_PRICE = 220;
    public static final int RED3_PRICE = 240;

    public static final int[] RED1_RENT = {18, 90, 250, 700, 875, 1050};
    public static final int[] RED2_RENT = {18, 90, 250, 700, 875, 1050};
    public static final int[] RED3_RENT = {20, 100, 300, 750, 925, 1100};

    public static final int YELLOW1_PRICE = 260;
    public static final int YELLOW2_PRICE = 260;
    public static final int YELLOW3_PRICE = 280;

    public static final int[] YELLOW1_RENT = {22, 110, 330, 800, 975, 1150};
    public static final int[] YELLOW2_RENT = {22, 110, 330, 800, 975, 1150};
    public static final int[] YELLOW3_RENT = {24, 120, 360, 850, 1025, 1200};

    public static final int GREEN1_PRICE = 300;
    public static final int GREEN2_PRICE = 300;
    public static final int GREEN3_PRICE = 320;

    public static final int[] GREEN1_RENT = {26, 130, 390, 900, 1100, 1275};
    public static final int[] GREEN2_RENT = {26, 130, 390, 900, 1100, 1275};
    public static final int[] GREEN3_RENT = {28, 150, 450, 1000, 1220, 1400};

    public static final int BLUE1_PRICE = 350;
    public static final int BLUE2_PRICE = 400;

    public static final int[] BLUE1_RENT = {35, 175, 500, 1100, 1300, 1500};
    public static final int[] BLUE2_RENT = {50, 200, 600, 1400, 1700, 2000};

    public static final Space GO = new ActionSpace(GO_NAME, 0);
    public static final Space PURPLE1 = new Property(PURPLE1_NAME, 1, PURPLE1_PRICE, ColorGroup.PURPLE, HOUSE_PRICE1, PURPLE1_RENT);
    public static final Space COMMUNITY_CHEST1 = new ActionSpace(COMMUNITY_CHEST_NAME, 2);
    public static final Space PURPLE2 = new Property(PURPLE2_NAME, 3, PURPLE2_PRICE, ColorGroup.PURPLE, HOUSE_PRICE1, PURPLE2_RENT);
    public static final Space INCOME_TAX = new TaxSpace(INCOME_TAX_NAME, 4, 200);
    public static final Space STATION1 = new Station(STATION1_NAME, 5, STATION_PRICE);
    public static final Space TEAL1 = new Property(TEAL1_NAME, 6, TEAL1_PRICE, ColorGroup.TEAL, HOUSE_PRICE1, TEAL1_RENT);
    public static final Space CHANCE1 = new ActionSpace(CHANCE_NAME, 7);
    public static final Space TEAL2 = new Property(TEAL2_NAME, 8, TEAL2_PRICE, ColorGroup.TEAL, HOUSE_PRICE1, TEAL2_RENT);
    public static final Space TEAL3 = new Property(TEAL3_NAME, 9, TEAL3_PRICE, ColorGroup.TEAL, HOUSE_PRICE1, TEAL3_RENT);
    public static final Space JAIL = new ActionSpace(JAIL_NAME, 10);
    public static final Space PINK1 = new Property(PINK1_NAME, 11, PINK1_PRICE, ColorGroup.PINK, HOUSE_PRICE2, PINK1_RENT);
    public static final Space UTILITY1 = new Utility(UTILITY1_NAME, 12, UTILITY_PRICE);
    public static final Space PINK2 = new Property(PINK2_NAME, 13, PINK2_PRICE, ColorGroup.PINK, HOUSE_PRICE2, PINK2_RENT);
    public static final Space PINK3 = new Property(PINK3_NAME, 14, PINK3_PRICE, ColorGroup.PINK, HOUSE_PRICE2, PINK3_RENT);
    public static final Space STATION2 = new Station(STATION2_NAME, 15, STATION_PRICE);
    public static final Space ORANGE1 = new Property(ORANGE1_NAME, 16, ORANGE1_PRICE, ColorGroup.ORANGE, HOUSE_PRICE2, ORANGE1_RENT);
    public static final Space COMMUNITY_CHEST2 = new ActionSpace(COMMUNITY_CHEST_NAME, 17);
    public static final Space ORANGE2 = new Property(ORANGE2_NAME, 18, ORANGE2_PRICE, ColorGroup.ORANGE, HOUSE_PRICE2, ORANGE2_RENT);
    public static final Space ORANGE3 = new Property(ORANGE3_NAME, 19, ORANGE3_PRICE, ColorGroup.ORANGE, HOUSE_PRICE2, ORANGE3_RENT);
    public static final Space FREE_PARKING = new ActionSpace(FREE_PARKING_NAME, 20);
    public static final Space RED1 = new Property(RED1_NAME, 21, RED1_PRICE, ColorGroup.RED, HOUSE_PRICE3, RED1_RENT);
    public static final Space CHANCE2 = new ActionSpace(CHANCE_NAME, 22);
    public static final Space RED2 = new Property(RED2_NAME, 23, RED2_PRICE, ColorGroup.RED, HOUSE_PRICE3, RED2_RENT);
    public static final Space RED3 = new Property(RED3_NAME, 24, RED3_PRICE, ColorGroup.RED, HOUSE_PRICE3, RED3_RENT);
    public static final Space STATION3 = new Station(STATION3_NAME, 25, STATION_PRICE);
    public static final Space YELLOW1 = new Property(YELLOW1_NAME, 26, YELLOW1_PRICE, ColorGroup.YELLOW, HOUSE_PRICE3, YELLOW1_RENT);
    public static final Space YELLOW2 = new Property(YELLOW2_NAME, 27, YELLOW2_PRICE, ColorGroup.YELLOW, HOUSE_PRICE3, YELLOW2_RENT);
    public static final Space UTILITY2 = new Utility(UTILITY2_NAME, 28, UTILITY_PRICE);
    public static final Space YELLOW3 = new Property(YELLOW3_NAME, 29, YELLOW3_PRICE, ColorGroup.YELLOW, HOUSE_PRICE3, YELLOW3_RENT);
    public static final Space GO_TO_JAIL = new ActionSpace(GO_TO_JAIL_NAME, 30);
    public static final Space GREEN1 = new Property(GREEN1_NAME, 31, GREEN1_PRICE, ColorGroup.GREEN, HOUSE_PRICE4, GREEN1_RENT);
    public static final Space GREEN2 = new Property(GREEN2_NAME, 32, GREEN2_PRICE, ColorGroup.GREEN, HOUSE_PRICE4, GREEN2_RENT);
    public static final Space COMMUNITY_CHEST3 = new ActionSpace(COMMUNITY_CHEST_NAME, 33);
    public static final Space GREEN3 = new Property(GREEN3_NAME, 34, GREEN3_PRICE, ColorGroup.GREEN, HOUSE_PRICE4, GREEN3_RENT);
    public static final Space STATION4 = new Station(STATION4_NAME, 35, STATION_PRICE);
    public static final Space CHANCE3 = new ActionSpace(CHANCE_NAME, 36);
    public static final Space BLUE1 = new Property(BLUE1_NAME, 37, BLUE1_PRICE, ColorGroup.BLUE, HOUSE_PRICE4, BLUE1_RENT);
    public static final Space LUXURY_TAX = new TaxSpace(LUXURY_TAX_NAME, 38, 100);
    public static final Space BLUE2 = new Property(BLUE2_NAME, 39, BLUE2_PRICE, ColorGroup.BLUE, HOUSE_PRICE4, BLUE2_RENT);

    public static final Space[] SPACES = {GO, PURPLE1, COMMUNITY_CHEST1, PURPLE2, INCOME_TAX, STATION1, TEAL1, CHANCE1, TEAL2, TEAL3,
            JAIL, PINK1, UTILITY1, PINK2, PINK3, STATION2, ORANGE1, COMMUNITY_CHEST2, ORANGE2, ORANGE3,
            FREE_PARKING, RED1, CHANCE2, RED2, RED3, STATION3, YELLOW1, YELLOW2, UTILITY2, YELLOW3,
            GO_TO_JAIL, GREEN1, GREEN2, COMMUNITY_CHEST3, GREEN3, STATION4, CHANCE3, BLUE1, LUXURY_TAX, BLUE2};

}

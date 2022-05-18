package logic;


import model.PlayerManager;
import model.player.Player;
import model.spaces.PurchasableSpace;

public class AuctionLogic extends Logic {

    private PlayerManager players;
    private PurchasableSpace toAuctionSpace;

    private int currentBid = 0;

    public AuctionLogic(PlayerManager players, PurchasableSpace toAuctionSpace) {
        this.players = players;
        this.toAuctionSpace = toAuctionSpace;
    }

    @Override
    public void action() {
        while (players.getSize() > 1) {
            Player currentBidder = players.getCurrentPlayer();
            if (!wantToBid()) {
                players.removePlayer(currentBidder);
                continue;
            }

            currentBid = getBid(currentBidder);
        }

        Player auctionWinner = players.getCurrentPlayer();
        toAuctionSpace.buyBy(auctionWinner);
        auctionWinner.buy(toAuctionSpace, currentBid);
    }

    // TODO: implement this method
    private boolean wantToBid() {
        // get some input to check if the player wants to bid
        return true;
    }

    // TODO: implement this method
    private int getBid(Player bidder) {
        // get money input
        int bid = toAuctionSpace.getPrice();
        while (bid < currentBid || !bidder.canPay(bid)) {
            bid = toAuctionSpace.getPrice();
        }

        return bid;
    }
}

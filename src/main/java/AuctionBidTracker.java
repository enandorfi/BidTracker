import java.util.ArrayList;
import java.util.HashSet;

public interface AuctionBidTracker {

    void recordBid(String userId, long itemId, double bidPrice);

    Bid getWinningBid(long itemId);

    HashSet<Bid> getBids(long itemId);

    ArrayList<Long> getItemsForUser(long userId);
}

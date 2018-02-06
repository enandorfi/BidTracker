import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AuctionBidTrackerImpl implements AuctionBidTracker {
//change it so that bids are stored in a hashmap with price being the key?



    //keeps track of bids
    Hashtable<Long,HashSet<Bid>> bids = new Hashtable<>();



    @Override
    public void recordBid(String userName, long itemId, double bidValue){
        Bid newBid = new Bid(userName, itemId, bidValue);
        if (getWinningBid(itemId) == null){
            HashSet<Bid> b = new HashSet<>();
            b.add(newBid);
            bids.put(itemId,b);
        }
        else if(bidValue > getWinningBid(itemId).getBidPrice()) {
            HashSet<Bid> b = bids.get(itemId);
            b.add(newBid);
        } else{
            System.out.println("Bid price lower than current highest");
        }
    }


    @Override
    public Bid getWinningBid(long itemId){
        if (bids.containsKey(itemId)){
            HashSet<Bid> b = bids.get(itemId);
            Bid maxBid = null;
            for(Bid bid : b){
                if (maxBid == null) maxBid
                if(bid.getBidPrice() > maxBid.getBidPrice()) maxBid = bid.getBidPrice();
            }
            return
        }
    }

    @Override
    public HashSet<Bid> getBids(long itemId){
        return bids.get(itemId);
    }

    @Override
    public ArrayList<Long> getItemsForUser(long userId){

    }
}

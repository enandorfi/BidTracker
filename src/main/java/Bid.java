
import org.apache.commons.lang3.StringUtils;

public class Bid {

    String userName;
    long itemId;
    double bidPrice;

    Bid(String userName, long itemId, double bidPrice){
        validateBid(userName, itemId, bidPrice);
        this.userName = userName;
        this.itemId = itemId;
        this.bidPrice = bidPrice;
    }

    validateBid(String userName, Long itemId, double bidPrice) throws InvalidBidException{
        if (StringUtils.isEmpty(userName)) throw new InvalidBidException("Error: Invalid bid, user name not specified");
        //check instead if it is an existing item?
        if (itemId == 0) throw new InvalidBidException("Error: Invalid bid, item id not specified");
        //check if bid is higher than last bid?
        if (bidPrice <= 0) throw new InvalidBidException("Error: Invalid bid, bid price must be greater than 0");
    }

    public double getBidPrice(){
        return this.bidPrice;
    }
}

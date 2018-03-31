package tk.hireyesin.kijijiparserv3;


import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private String title;
    private String link;
    private String description;
    private String imgUrl;
    private String pubDate;
    private double geoLat;
    private double geoLong;
    private double price;

    public Item(String title, String link, String description, String imgUrl, String pubDate, double geoLat, double geoLong, double price) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.imgUrl = imgUrl;
        this.pubDate = pubDate;
        this.geoLat = geoLat;
        this.geoLong = geoLong;
        this.price = price;
    }
    public Item(Parcel in) {
        title = in.readString();
        link = in.readString();
        description = in.readString();
        imgUrl = in.readString();
        pubDate = in.readString();
        geoLat = in.readDouble();
        geoLong = in.readDouble();
        price = in.readDouble();
    }



    public Item(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public double getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(double geoLat) {
        this.geoLat = geoLat;
    }

    public double getGeoLong() {
        return geoLong;
    }

    public void setGeoLong(double geoLong) {
        this.geoLong = geoLong;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "title: '" + title + '\n' +
                "link: '" + link + '\n' +
                "description: '" + description + '\n' +
                "imgUrl: '" + imgUrl + '\n' +
                "pubDate: '" + pubDate + '\n' +
                "geoLat: " + geoLat +"\n"+
                "geoLong: " + geoLong +"\n"+
                "price=" + price+"\n"+
                "=============================\n\n";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(title);
        dest.writeString(link);
        dest.writeString(description);
        dest.writeString(imgUrl);
        dest.writeString(pubDate);
        dest.writeDouble(geoLat);
        dest.writeDouble(geoLong);
        dest.writeDouble(price);
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];

        }
    };
}

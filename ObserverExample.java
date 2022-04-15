import java.util.ArrayList;

class Observer {
    Game game;
    PlayStation station;

    public Observer(Game game, PlayStation station) {
        this.game = game;
        this.station = station;
    }
    void update(Game game){
        this.game = game;
        station.notify(game);
    }

}

class DarkSoulsObserver extends Observer {
    public DarkSoulsObserver(Game game, PlayStation sation){
        super(game, sation);
    }
}

class FifaObserver extends Observer {
    public FifaObserver(Game game, PlayStation station){
        super(game, station);
    }
}

class Game {
    String title, publisher, company, price, date, trailer, discount;
    public Game(String title, String publisher, String company, String price, String date, String trailer, String discount){
        this.title = title;
        this.publisher = publisher;
        this.company = company;
        this.price = price;
        this.date = date;
        this.trailer = trailer;
        this.discount = discount;
    }
}

class PlayStation {
    ArrayList<Observer> observerList;
    
    public PlayStation(){
        observerList = new ArrayList<>();
    }

    void subscribe(Observer observer){
        observerList.add(observer);
    }

    void notify(Game game){
        System.out.println("Notified users");
    }
}


class PlayStationManager {
    PlayStation station;
    ArrayList<Game> games;
    ArrayList<Observer> observers;

    public PlayStationManager(PlayStation station) {
        this.station = station;
        this.games = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addGame(Game game){
        this.games.add(game);
    }

    public void subscribe(Observer observer){
        this.observers.add(observer);
    }
}
import action.*;
import action.peopleinteraction.*;
import enumeration.*;
import geometry.TwoDimensionalPoint;
import location.Buyable;
import location.TwoDimensionalLocation;
import location.TwoDimensionalPizzeria;
import location.TwoDimensionalShop;
import locationobject.item.Photo;
import locationobject.item.Pizza;
import locationobject.item.Sandwich;
import locationobject.item.Tray;
import locationobject.item.Bottle;
import locationobject.person.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        // creation of locations
        TwoDimensionalLocation room = new TwoDimensionalLocation("Main Room", 20, 20);
        TwoDimensionalShop orringtonShop = new TwoDimensionalShop("Shop in Orrington", 30, 30);
        TwoDimensionalPizzeria twoDimensionalPizzeria = new TwoDimensionalPizzeria("Napoli", 10,10);


        // creation of people
        Rachel rachel = new Rachel();
        Dori dori = new Dori();
        Irwin irwin = new Irwin();
        Louis louis = new Louis();
        Gage gage = new Gage();
        Ellie ellie = new Ellie();
        Jud jud = new Jud();


        // creation of items
        Sandwich sandwich1 = new Sandwich("Nutella Sandwich");
        Sandwich sandwich2 = new Sandwich("Oreo Ice Cream Sandwich");
        Tray tray = new Tray(Color.SILVER);
        tray.addItem(sandwich1);
        tray.addItem(sandwich2);
        Photo photo = new Photo("photo of Ellie");
        Bottle beer1 = new Bottle(Liquid.BEER);
        Bottle beer2 = new Bottle(Liquid.BEER);
        Bottle beer3 = new Bottle(Liquid.BEER);
        Pizza pizza1 = new Pizza("Hawaiian pizza");
        Pizza pizza2 = new Pizza("Greek Pizza");

        // filling the room
        room.addLocationObject(rachel, new TwoDimensionalPoint(3, 3));
        room.addLocationObject(dori, new TwoDimensionalPoint(4, 5));
        room.addLocationObject(irwin, new TwoDimensionalPoint(2, 5));
        room.addLocationObject(louis, new TwoDimensionalPoint(4, 14));
        room.addLocationObject(ellie, new TwoDimensionalPoint(13,15));
        room.addLocationObject(jud, new TwoDimensionalPoint(18,16));
        room.addLocationObject(photo, new TwoDimensionalPoint(13,13));
        room.addLocationObject(tray, new TwoDimensionalPoint(13,17));
        room.addLocationObject(sandwich1, null);
        room.addLocationObject(sandwich2, null);




        // creation of actions in room
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new Cry(rachel));
        actions.add(new Approach(room, dori, rachel, Arrangement.FRONT));
        actions.add(new TurnPersonToPerson(room, dori, rachel));
        actions.add(new TurnPersonToPerson(room, rachel, dori));
        actions.add(new Hug(room, rachel, dori));
        actions.add(new PutHeadOnShoulder(room, rachel, dori, Orientation.LEFT));
        actions.add(new AddBelief(rachel,"I think Louis is to blame for Gage's death"));
        actions.add(new PlungeIntoSorrowsAndFantasies(louis));
        actions.add(new Comfort(room, dori, rachel));
        actions.add(new WipeTearsAway(room, dori, rachel));
        actions.add(new Approach(room, irwin, rachel, Arrangement.BEHIND));
        actions.add(new TurnPersonToPerson(room, irwin, rachel));
        actions.add(new PutHandOnShoulder(room, irwin, rachel));
        actions.add(new LookAt(room, irwin, louis, GazeModifier.SECRET_TRIUMPH));
        actions.add(new Approach(room, ellie, tray, Arrangement.LEFT));
        actions.add(new TakeItemByPalm(room, ellie, tray, Orientation.RIGHT));
        actions.add(new Approach(room, ellie, photo, Arrangement.LEFT));
        actions.add(new TakeItemByArmpit(room, ellie, photo, Orientation.LEFT));
        actions.add(new WalkAroundPeople(room, List.of(new Person[]{ellie, louis, jud})));
        actions.add(new AddBelief(louis,"purely theoretically I'm thinking about digging up graves"));
        actions.add(new AddBelief(jud,"maybe louis is thinking about digging up graves"));
        actions.add(new AddBelief(rachel,"I think Louis is thinking about the accident that killed Gage"));
        actions.add(new AddBelief(dori,"I think Louis is thinking about the accident that killed Gage"));
        actions.add(new AddBelief(irwin,"I think Louis is thinking about the accident that killed Gage"));
        actions.add(new AddBelief(ellie,"I think Louis is thinking about the accident that killed Gage"));
        actions.add(new SetGazeModifier(louis, GazeModifier.ABSENT));
        actions.add(new Approach(room, jud, louis, Arrangement.FRONT));
        actions.add(new Condole(room, jud, louis));
        actions.add(new Thank(room, louis, jud));
        actions.add(new Nod(louis));


        // executing actions in room
        for (Action action: actions)
            action.execute();


        // clearing of room and actions array
        room.clear();
        actions.clear();


        // filling the Orrington shop
        orringtonShop.addLocationObject(louis, new TwoDimensionalPoint(1,1));
        orringtonShop.addLocationObject(beer1, new TwoDimensionalPoint(1,4));
        orringtonShop.addLocationObject(beer2, new TwoDimensionalPoint(2,4));
        orringtonShop.addLocationObject(beer3, new TwoDimensionalPoint(3,4));


        // creation of actions in Orrington shop
        actions.add(new Approach(orringtonShop, louis, beer1, Arrangement.FRONT));
        actions.add(new TakeItemByPalm(orringtonShop, louis, beer1, Orientation.LEFT));
        actions.add(new Approach(orringtonShop, louis, beer2, Arrangement.FRONT));
        actions.add(new TakeItemByPalm(orringtonShop, louis, beer2, Orientation.RIGHT));
        actions.add(new Buy(orringtonShop, louis, beer1));
        actions.add(new Buy(orringtonShop, louis, beer2));
        actions.add(new ToOrder(twoDimensionalPizzeria, louis, List.of(new Buyable[]{pizza1, pizza2})));


        // executing actions in Orrington shop
        for (Action action: actions)
            action.execute();


    }


}

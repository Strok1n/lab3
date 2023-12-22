package locationobject.person.bodypart.head.mouth;

import locationobject.LocationObject;
import locationobject.Listenable;
import locationobject.Listener;
import locationobject.person.Person;

import java.util.ArrayList;

public class Mouth extends LocationObject implements Listenable {

    protected ArrayList<Person> listeners;
    protected LipsType lipsType;
    protected int voiceLoudnessLevel;
    protected Character pronounceableLetter;

    protected int pauseLengthAfterLetter;
    protected int pauseLengthAfterWord;
    protected int pauseLengthAfterComma;
    protected int pauseLengthAfterPoint;

    public Mouth(LipsType lipsType, int voiceLoudnessLevel,
                 int pauseLengthAfterLetter,int pauseLengthAfterWord,
                 int pauseLengthAfterComma, int pauseLengthAfterPoint){
        this.listeners = new ArrayList<>();
        this.voiceLoudnessLevel = voiceLoudnessLevel;
        this.lipsType = lipsType;
        this.pauseLengthAfterLetter = pauseLengthAfterLetter;
        this.pauseLengthAfterWord = pauseLengthAfterWord;
        this.pauseLengthAfterComma = pauseLengthAfterComma;
        this.pauseLengthAfterPoint = pauseLengthAfterPoint;
    }
    protected void pronounceLetter(char letter) throws InterruptedException {
        this.pronounceableLetter = letter;
        this.notifyListeners(letter);
        makePauseAfterLetter();
        System.out.print(letter);
    }

    public void sayAText(String sentence) throws InterruptedException {
        for (char c:
             sentence.toCharArray()) {
            if (c == ' ' || c == ',' || c == '.') {
                if (c == ' ') {
                    makePauseAfterWord();
                    this.notifyListeners(' ');
                    System.out.print(" ");
                }
                if (c == ',') {
                    makePauseAfterComma();
                    this.notifyListeners(',');
                    System.out.print(",");
                }
                if (c == '.') {
                    makePauseAfterPoint();
                    System.out.println(".");
                    this.notifyListeners('.');

                }
                } else {
                pronounceLetter(c);
            }
        }
        this.pronounceableLetter = null;
    }

    protected void makePauseAfterLetter() throws InterruptedException {
        Thread.sleep( pauseLengthAfterLetter);
    }
    protected void makePauseAfterWord() throws InterruptedException {
        Thread.sleep( pauseLengthAfterWord);
    }

    protected void makePauseAfterPoint() throws InterruptedException {
        Thread.sleep(pauseLengthAfterPoint);
    }

    protected void makePauseAfterComma() throws InterruptedException {
        Thread.sleep(pauseLengthAfterComma);
    }

    @Override
    public void addListener(Listener listener) {
        this.listeners.add((Person) listener);
    }

    @Override
    public void removeListener(Listener listener) {
        this.listeners.remove((Person) listener);
    }

    @Override
    public void notifyListeners(Character character) throws InterruptedException {
        for (Person observer: this.listeners) {
            if (this.point.distanceSquared(observer.getPoint()) <= (this.voiceLoudnessLevel*this.voiceLoudnessLevel)) {
                if (character == '.') {
                    System.out.println(observer + " heard the proposal.");
                }
                observer.handleEvent(character);
            }
        }
    }








}

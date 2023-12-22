package locationobject.person.bodypart.head;

import enumeration.HairColor;
import locationobject.person.bodypart.head.mouth.LipsType;
import locationobject.person.bodypart.head.mouth.Mouth;

public class HeadOfGage extends Head{
    public HeadOfGage(){
        super(
                HairColor.LIGHT_BLOND,
                new Mouth(
                        LipsType.WIDE,
                        6,
                        60,
                        153,
                        430,
                        1020
                )
        );
    }
}

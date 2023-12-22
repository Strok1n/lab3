package locationobject.person.bodypart.head;

import enumeration.HairColor;
import locationobject.person.bodypart.head.mouth.LipsType;
import locationobject.person.bodypart.head.mouth.Mouth;

public class HeadOfDori extends Head{
    public HeadOfDori(){
        super(
                HairColor.DARK_BROWN,
                new Mouth(
                        LipsType.FULL,
                        10,
                        50,
                        100,
                        200,
                        400
                )
        );
    }
}

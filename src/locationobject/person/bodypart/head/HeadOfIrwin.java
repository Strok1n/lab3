package locationobject.person.bodypart.head;

import enumeration.HairColor;
import locationobject.person.bodypart.head.mouth.LipsType;
import locationobject.person.bodypart.head.mouth.Mouth;

public class HeadOfIrwin extends Head{
    public HeadOfIrwin(){
        super(
                HairColor.WHITE,
                new Mouth(
                        LipsType.ROUND,
                        5,
                        40,
                        253,
                        430,
                        720
                )
        );
    }
}

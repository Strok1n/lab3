package locationobject.person.bodypart.head;

import enumeration.HairColor;
import locationobject.person.bodypart.head.mouth.LipsType;
import locationobject.person.bodypart.head.mouth.Mouth;

public class HeadOfJud extends Head{
    public HeadOfJud(){
        super(
                HairColor.WHITE,
                new Mouth(
                        LipsType.BOW_SHAPED,
                        7,
                        40,
                        123,
                        330,
                        420
                )
        );
    }
}

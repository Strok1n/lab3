package locationobject.person.bodypart.head;

import enumeration.HairColor;
import locationobject.person.bodypart.head.mouth.LipsType;
import locationobject.person.bodypart.head.mouth.Mouth;

public class HeadOfRachel extends Head{
    public HeadOfRachel(){
        super(
                HairColor.GOLDEN_BLOND,
                new Mouth(
                        LipsType.HEART_SHAPED,
                        4,
                        50,
                        233,
                        560,
                        843
                )
        );
    }
}

package locationobject.person.bodypart.head;

import enumeration.HairColor;
import locationobject.person.bodypart.head.mouth.LipsType;
import locationobject.person.bodypart.head.mouth.Mouth;

public class HeadOfEllie extends Head{
    public HeadOfEllie(){
        super(
                HairColor.NATURAL_BROWN,
                new Mouth(
                        LipsType.TOP_HEAVY,
                        8,
                        70,
                        150,
                        300,
                        500
                )
        );
    }
}

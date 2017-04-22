package operations;

import Exeptions.IncorrectCharInSinNumberException;
import Exeptions.InvalidSimNumberLengthExeption;

/**
 * Created by Sonad on 22.04.17.
 */
public class Validation {
    public static void simNumberValidation(String simNumber) throws InvalidSimNumberLengthExeption, IncorrectCharInSinNumberException
    {
        if (simNumber.length() != 11) throw new InvalidSimNumberLengthExeption();
        for (int i = 0; i < simNumber.length(); i++) {
            if (i==3)
                if (simNumber.charAt(i) != '-') throw new IncorrectCharInSinNumberException();
                else continue;
            if (simNumber.charAt(i) < 48 || simNumber.charAt(i) > 57) throw new IncorrectCharInSinNumberException();
        }
    }
}

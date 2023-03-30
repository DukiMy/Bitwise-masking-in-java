import static java.lang.System.out;

/**
 * Task 4.5 - Exclusive OR (*)
 * Animals are generally unisexual, i.e., either female or male. Create a logical expression with appropriate relationship operators that determine whether a particular individual is male or female. Use two different variables to represent the male. Thus a Boolean variable is true about males and a Boolean variable is true about females. Show how you, with exclusive OR (^), can implement a solution where only one gender at a time gives true.
 * Worms are bisexual hermaphrodites, i.e., both male/female. Complement your solution so that the combination of male and female simultaneously shows the result of hermaphrodite.
 */

public class Main {

    public static void main(String[] args) {
        
        final int IS_MALE   = 0b00000001;
        final int IS_FEMALE = 0b00000010;
        final int IS_BOTH   = 0b00000011;
        final int IS_4LEG   = 0b00000100;
        final int IS_2LEG   = 0b00001000;
        
        int animalData = 0b00000000;
        int animalSexMask = 0b00000011;
        int animalLegMask = 0b00001100;
        
        // Decides what the animal will be.
        animalData += IS_MALE;
        animalData += IS_4LEG;

        /**
         * 0000 0101 animalData
         * 0000 0011 animalSexMask
         * 0000 0001 animalData & animalSexMask
         * 0000 0000 (animalData & animalSexMask) ^ IS_MALE)
        */

        if (((animalData & animalSexMask) ^ IS_MALE) == 0) {
            out.println("Animal is male.");
        }

        /**
         * 0000 0110 animalData
         * 0000 0011 animalSexMask
         * 0000 0010 animalData & animalSexMask
         * 0000 0000 (animalData & animalSexMask) ^ IS_FEMALE)
        */

        else if (((animalData & animalSexMask) ^ IS_FEMALE) == 0) {
            out.println("Animal is female.");
        }

        /**
         * 0000 0011 IS_BOTH
         * 0000 0011 animalSexMask
         * 0000 0011 animalData & animalSexMask
         * 0000 0000 (animalData & animalSexMask) ^ IS_BOTH)
        */

        else if (((animalData & animalSexMask) ^ IS_BOTH) == 0) {
            out.println("Animal is both.");
        }
        else{
            out.println("Sex unknown.");
        }

        /**
         * 0000 0100 IS_4LEG
         * 0000 1100 animalLegMask
         * 0000 0100 animalData & animalLegMask
         * 0000 0000 (animalData & animalSexMask) ^ IS_4LEG)
        */

        // Checks for amount of legs.
        if (((animalData & animalLegMask) ^ IS_4LEG) == 0) {
            out.println("Animal is 4 legged.");
        }

        /**
         * 0000 1000 IS_2LEG
         * 0000 1100 animalLegMask
         * 0000 1000 animalData & animalLegMask
         * 0000 0000 (animalData & animalLegMask) ^ IS_4LEG)
        */

        else if (((animalData & animalLegMask) ^ IS_2LEG) == 0) {
            out.println("Animal is 2 legged.");            
        }
        else {
            out.println("Animal has neither 2 or 4 legs.");
        }
    }
}